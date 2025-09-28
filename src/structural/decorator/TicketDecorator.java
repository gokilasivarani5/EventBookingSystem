package structural.decorator;

import model.Ticket;

public abstract class TicketDecorator extends Ticket {
    protected Ticket ticket;

    public TicketDecorator(Ticket ticket) {
        super(ticket.event, ticket.quantity);
        this.ticket = ticket;
    }

    @Override
    public abstract double calculateTotalPrice();
}
