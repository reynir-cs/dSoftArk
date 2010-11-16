package hotciv.framework;

public interface ActionStrategy {
    /** Perform the action of the unit at position pos in 'game'.
     * @param game The game the unit is in.
     * @param pos The position the unit is at.
     */

    public void performUnitActionAt(Game game, Position pos);
}
