package structural.decorator;

import model.Ticket;

public class BackstagePassDecorator extends TicketDecorator {
    private double price = 50;

    public BackstagePassDecorator(Ticket ticket) {
        super(ticket);
    }

    @Override
    public double calculateTotalPrice() {
        return ticket.calculateTotalPrice() + price;
    }
}
