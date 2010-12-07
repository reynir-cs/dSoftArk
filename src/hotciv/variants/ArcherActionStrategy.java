package hotciv.variants;

import hotciv.framework.*;
import hotciv.common.*;

public class ArcherActionStrategy implements ActionStrategy {
    public Unit performUnitActionAt(Game game, Position pos) {
        Unit u = game.getUnitAt(pos);
	if (!u.getTypeString().equals(GameConstants.ARCHER))
            return u;

        if (u.isFortified()) {
            return u.withFortify(false, u.getDefensiveStrength()/2);
        } else {
            return u.withFortify(true, u.getDefensiveStrength()*2);
        }
    }
}
