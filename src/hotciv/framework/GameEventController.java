package hotciv.framework;

import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;

public class GameEventController {
    private Map<String, Set<GameEventListener>> eventMap;
    
    public GameEventController() {
        eventMap = new HashMap<String, Set<GameEventListener>>();
    }

    public void subscribe(GameEventListener event) {
        String eventType = event.getType();
        Set<GameEventListener> events = eventMap.get(eventType);
        if (events == null) {
            events = new HashSet<GameEventListener>();
            eventMap.put(eventType, events);
        }
        events.add(event);
    }

    public void unsubscribe(GameEventListener event) {
        String eventType = event.getType();
        Set<GameEventListener> events = eventMap.get(eventType);
        if (events == null)
            return;
        events.remove(event);
        if (events.isEmpty())
            eventMap.remove(events);
    }

    public void dispatch(String eventType, Object o) {
        Set<GameEventListener> events = eventMap.get(eventType);
        if (events == null)
            return;
        for (GameEventListener event : events)
            event.dispatch(o);
    }
}
