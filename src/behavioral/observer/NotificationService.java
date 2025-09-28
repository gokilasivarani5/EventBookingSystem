package behavioral.observer;

import model.Event;
import model.User;
import java.util.*;

public class NotificationService implements Subject {
    private Map<String, List<Observer>> subscribers = new HashMap<>();

    @Override
    public void subscribe(String eventId, Observer user) {
        subscribers.putIfAbsent(eventId, new ArrayList<>());
        subscribers.get(eventId).add(user);
    }

    @Override
    public void unsubscribe(String eventId, Observer user) {
        if(subscribers.containsKey(eventId)) {
            subscribers.get(eventId).remove(user);
        }
    }

    @Override
    public void notifySubscribers(Event event) {
        if(subscribers.containsKey(event.getEventId())) {
            for(Observer user : subscribers.get(event.getEventId())) {
                user.update(event);
            }
        }
    }
}
