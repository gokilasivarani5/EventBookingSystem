package model;

public class Ticket {
    public Event event;
    public int quantity;

    public Ticket(Event event, int quantity) {
        this.event = event;
        this.quantity = quantity;
    }

    public double calculateTotalPrice() {
        return event.getBasePrice() * quantity;
    }
}
