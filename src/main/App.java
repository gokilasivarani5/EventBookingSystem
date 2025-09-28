package main;

import java.util.Scanner;

import creational.singleton.EventManager;
import model.Event;
import behavioral.observer.*;
import behavioral.strategy.*;
import model.Ticket;
import structural.decorator.*;
import structural.adapter.*;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EventManager manager = EventManager.getInstance();
        NotificationService notifier = new NotificationService();

        while (true) {
            System.out.println("\nMenu: 1.List Events 2.Subscribe 3.Book Tickets 4.Exit");
            System.out.print("Enter choice: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1": // List Events
                    manager.listEvents();
                    break;

                case "2": // Subscribe
                    try {
                        System.out.print("Enter event ID and email: ");
                        String[] data = sc.nextLine().split(" ");
                        String eventId = data[0];
                        String email = data[1];
                        Event event = manager.getEvent(eventId);
                        if (event == null) {
                            System.out.println("Event not found.");
                        } else {
                            notifier.subscribe(eventId, new Observer() {
                                @Override
                                public void update(Event event) {
                                    System.out.println("[Notification] Event " + event.getName() + " updated.");
                                }
                            });
                            System.out.println("[Subscribed] You will receive notifications for event " + event.getName());
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid input.");
                    }
                    break;

                case "3": // Book Tickets
                    try {
                        System.out.print("Enter event ID, quantity, perks(Drinks,B1ackstage(comma-separated)), payment(paypal/stripe): ");
                        String[] data = sc.nextLine().split(" ");
                        String eventId = data[0];
                        int qty = Integer.parseInt(data[1]);
                        String[] perks = data[2].split(",");
                        String paymentMethod = data[3];

                        Event event = manager.getEvent(eventId);
                        if (event == null) {
                            System.out.println("Invalid Event ID.");
                            break;
                        }
                        if (qty > event.getAvailableSeats()) {
                            System.out.println("Not enough seats.");
                            break;
                        }

                        // Base Ticket
                        Ticket ticket = new Ticket(event, qty);

                        // Decorators
                        for (String perk : perks) {
                            if (perk.equalsIgnoreCase("backstage"))
                                ticket = new BackstagePassDecorator(ticket);
                            if (perk.equalsIgnoreCase("drinks"))
                                ticket = new FreeDrinkDecorator(ticket);
                        }

                        // Pricing Strategy
                        PricingStrategy strategy = new EarlyBirdPricing(); // change logic if needed
                        double price = strategy.calculatePrice(event.getBasePrice(), qty);
                        price += (ticket.calculateTotalPrice() - price); // add perks
                        System.out.println("Total Price: $" + price);

                        // Payment Adapter
                        PaymentGateway gateway = paymentMethod.equalsIgnoreCase("paypal") ? new PayPalAdapter()
                                : new StripeAdapter();
                        if (gateway.processPayment(price)) {
                            event.bookSeats(qty);
                            notifier.notifySubscribers(event);
                            System.out.println("[Booking Confirmed] " + qty + " tickets for " + event.getName()
                                    + ". Seats Remaining: " + event.getAvailableSeats());
                        }
                    } catch (Exception e) {
                        System.out.println("Booking failed. Check input format.");
                    }
                    break;

                case "4":
                    System.out.println("Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
