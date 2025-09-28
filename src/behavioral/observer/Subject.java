package behavioral.observer;

import model.Event;

public interface Subject {
    void subscribe(String eventId, Observer user);
    void unsubscribe(String eventId, Observer user);
    void notifySubscribers(Event event);
}
