package hotciv.framework;

public interface ActionStrategy {
    public Unit performUnitActionAt(Game game, Position pos);
}
