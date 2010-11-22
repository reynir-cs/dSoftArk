package hotciv.variants;

import hotciv.framework.*;
import hotciv.common.*;

public class VoidActionStrategy implements ActionStrategy {
    public Unit performUnitActionAt(Game game, Position pos) {
        return game.getUnitAt(pos);
    }
}
