package hotciv.standard;

import hotciv.framework.*;
import java.util.Map;
import java.util.HashMap;

public class SimpleWorldLayoutStrategy implements WorldLayoutStrategy {

    public Map<Position, Tile> getWorld() {
	Map<Position, Tile> world = new HashMap<Position, Tile>();
	world.put(new Position(1,0),
		  new TileImpl(new Position(1,0), GameConstants.OCEANS));
	world.put(new Position(0,1),
		  new TileImpl(new Position(0,1), GameConstants.HILLS));
	world.put(new Position(2,2),
		  new TileImpl(new Position(2,2), GameConstants.MOUNTAINS));
	return world;
    }
}
