package hotciv.standard;

import hotciv.framework.*;

public class SettlerAndArcherActionStrategy implements ActionStrategy {
    public Unit performUnitActionAt(Game game, Position pos) {
        Unit u = game.getUnitAt(pos);
        if (u.isFortified()) {
            return new UnitImpl(u.getTypeString(), u.getOwner(), u.getLastMoved(),
                    false, 3);
        } else {
            return new UnitImpl(u.getTypeString(), u.getOwner(), u.getLastMoved(),
                    true, 6);
        }
    }
}
