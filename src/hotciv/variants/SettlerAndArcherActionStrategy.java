package hotciv.variants;

import hotciv.framework.*;
import hotciv.common.*;

public class SettlerAndArcherActionStrategy implements ActionStrategy {
    public Unit performUnitActionAt(Game game, Position pos) {
        Unit u = game.getUnitAt(pos);
	if (u.getTypeString().equals(GameConstants.SETTLER)) {
	    game.addCityAt(pos, new CityImpl(u.getOwner()));
	    return null;
	}
        if (u.isFortified()) {
            return u.withFortify(false, u.getDefensiveStrength()/2);
        } else {
            return u.withFortify(true, u.getDefensiveStrength()*2);
        }
    }
}
