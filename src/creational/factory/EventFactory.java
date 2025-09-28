package creational.factory;

import model.Event;
import java.time.LocalDate;

public class EventFactory {
    public Event createEvent(EventType type, String id, String name, LocalDate date, int capacity, double basePrice) {
        return new Event(id, name, type.name(), date, capacity, basePrice);
    }
}
