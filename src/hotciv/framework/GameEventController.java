package hotciv.framework;

import java.util.EnumMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;

public class GameEventController {
    private Map<EventType, Set<GameEventListener>> eventMap;
    public enum EventType { NEW_ROUND, ATTACKER_WON };

    public GameEventController() {
        eventMap = new EnumMap<EventType, Set<GameEventListener>>(EventType.class);
    }

    public void subscribe(GameEventListener event) {
        EventType type = event.getType();
        Set<GameEventListener> events = eventMap.get(type);
        if (events == null) {
            events = new HashSet<GameEventListener>();
            eventMap.put(type, events);
        }
        events.add(event);
    }

    public void unsubscribe(GameEventListener event) {
        EventType type = event.getType();
        Set<GameEventListener> events = eventMap.get(type);
        if (events == null)
            return;
        events.remove(event);
        if (events.isEmpty())
            eventMap.remove(events);
    }

    public void dispatch(EventType type, GameEvent evt) {
        Set<GameEventListener> events = eventMap.get(type);
        if (events == null)
            return;
        for (GameEventListener event : events)
            event.dispatch(evt);
    }
}
