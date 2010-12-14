package hotciv.framework;

public interface GameObserver {
    public void worldChangedAt(Position pos);
    public void turnEnds(Player nextPlayer, int age);
    public void tileFocusChangedAt(Position pos);
}
