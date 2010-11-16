package hotciv.standard;

import hotciv.framework.*;

public class VoidActionStrategy implements ActionStrategy {
    public Unit performUnitActionAt(Game game, Position pos) {
        return game.getUnitAt(pos);
    }
}
