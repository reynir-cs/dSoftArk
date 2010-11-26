package hotciv.framework;

public interface GameEventListener {
    public void dispatch(GameEvent evt);
    public GameEventController.EventType getType();
}
