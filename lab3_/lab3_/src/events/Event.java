package events;

import characters.Shorty;

import java.util.List;

public class Event {
    private EventType type;
    private Object triggeredBy;
    private List<Shorty> affectedTargets;

    public Event(EventType type, Object triggeredBy, List<Shorty> affectedTargets) {
        this.type = type;
        this.triggeredBy = triggeredBy;
        this.affectedTargets = affectedTargets;
    }

    public EventType getType() {
        return type;
    }

    public void trigger() {
        System.out.println("Событие " + type + " запущено.");
    }

    public void resolve() {
        System.out.println("Событие " + type + " завершено.");
    }
}
