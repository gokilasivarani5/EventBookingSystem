package structural.decorator;

import model.Ticket;

public class FreeDrinkDecorator extends TicketDecorator {
    private double price = 10;

    public FreeDrinkDecorator(Ticket ticket) {
        super(ticket);
    }

    @Override
    public double calculateTotalPrice() {
        return ticket.calculateTotalPrice() + price;
    }
}
