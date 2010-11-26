package hotciv.variants;

import hotciv.framework.*;
import hotciv.common.*;

public class SettlerActionStrategy implements ActionStrategy {
    public Unit performUnitActionAt(Game game, Position pos) {
        Unit u = game.getUnitAt(pos);
	if (u.getTypeString().equals(GameConstants.SETTLER)) {
	    game.addCityAt(pos, new CityImpl(u.getOwner()));
	    return null;
	}
        return u;
    }
}
