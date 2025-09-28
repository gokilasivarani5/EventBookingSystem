package creational.singleton;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import model.Event;

public class EventManager {
    private static EventManager instance;
    private Map<String, Event> events = new HashMap<>();

    private EventManager() {
        initializeEvents();
    }

    public static EventManager getInstance() {
        if (instance == null) {
            instance = new EventManager();
        }
        return instance;
    }

    private void initializeEvents() {
        // Concerts/Shows
        events.put("EVT101", new Event("EVT101", "StageBook", "CONCERT", LocalDate.of(2025, 10, 10), 100, 150));
        events.put("EVT102", new Event("EVT102", "LiveSpot", "CONCERT", LocalDate.of(2025, 10, 12), 120, 120));
        events.put("EVT103", new Event("EVT103", "MusicMeet", "CONCERT", LocalDate.of(2025, 10, 15), 80, 100));

        // Conferences/Workshops
        events.put("EVT201", new Event("EVT201", "Converge", "CONFERENCE", LocalDate.of(2025, 11, 5), 50, 200));
        events.put("EVT202", new Event("EVT202", "LearnHub", "CONFERENCE", LocalDate.of(2025, 11, 10), 60, 180));
        events.put("EVT203", new Event("EVT203", "MeetSphere", "CONFERENCE", LocalDate.of(2025, 11, 12), 40, 220));

        // Sports Events
        events.put("EVT301", new Event("EVT301", "GameDay", "SPORTS", LocalDate.of(2025, 12, 1), 150, 120));
        events.put("EVT302", new Event("EVT302", "SportsArena", "SPORTS", LocalDate.of(2025, 12, 5), 200, 140));
        events.put("EVT303", new Event("EVT303", "MatchBook", "SPORTS", LocalDate.of(2025, 12, 10), 180, 160));
    }

    public Event getEvent(String eventId) {
        return events.get(eventId);
    }

    public void listEvents() {
        System.out.println("------------------------------------------------------------");
        System.out.println("Concerts/Shows:");
        System.out.println("------------------------------------------------------------");
        events.values().stream()
            .filter(e -> e.getType().equalsIgnoreCase("CONCERT"))
            .forEach(e -> System.out.printf("%s | %s | %s | %s | Seats: %d | $%.2f\n",
                e.getEventId(), e.getName(), e.getType(), e.getDate(), e.getAvailableSeats(), e.getBasePrice()));

        System.out.println("\nConferences/Workshops:");
        System.out.println("------------------------------------------------------------");
        events.values().stream()
            .filter(e -> e.getType().equalsIgnoreCase("CONFERENCE"))
            .forEach(e -> System.out.printf("%s | %s | %s | %s | Seats: %d | $%.2f\n",
                e.getEventId(), e.getName(), e.getType(), e.getDate(), e.getAvailableSeats(), e.getBasePrice()));

        System.out.println("\nSports Events:");
        System.out.println("------------------------------------------------------------");
        events.values().stream()
            .filter(e -> e.getType().equalsIgnoreCase("SPORTS"))
            .forEach(e -> System.out.printf("%s | %s | %s | %s | Seats: %d | $%.2f\n",
                e.getEventId(), e.getName(), e.getType(), e.getDate(), e.getAvailableSeats(), e.getBasePrice()));

        System.out.println("------------------------------------------------------------");
    }
}
