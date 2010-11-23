package hotciv.framework;

public interface GameEventListener {
    public void dispatch(Object o);
    public String getType();
}
