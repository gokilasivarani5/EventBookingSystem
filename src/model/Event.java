package model;

import java.time.LocalDate;

public class Event {
    private String eventId;
    private String name;
    private String type;
    private LocalDate date;
    private int capacity;
    private int availableSeats;
    private double basePrice;

    public Event(String eventId, String name, String type, LocalDate date, int capacity, double basePrice) {
        this.eventId = eventId;
        this.name = name;
        this.type = type;
        this.date = date;
        this.capacity = capacity;
        this.availableSeats = capacity;
        this.basePrice = basePrice;
    }

    public String getEventId() { return eventId; }
    public String getName() { return name; }
    public String getType() { return type; }
    public LocalDate getDate() { return date; }
    public int getAvailableSeats() { return availableSeats; }
    public double getBasePrice() { return basePrice; }

    public boolean bookSeats(int quantity) {
        if(quantity <= availableSeats) {
            availableSeats -= quantity;
            return true;
        }
        return false;
    }
}
