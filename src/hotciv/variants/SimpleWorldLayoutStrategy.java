package hotciv.variants;

import hotciv.framework.*;
import hotciv.common.*;
import java.util.Map;
import java.util.HashMap;

public class SimpleWorldLayoutStrategy implements WorldLayoutStrategy {

    public Map<Position, Tile> getWorld() {
	Map<Position, Tile> world = new HashMap<Position, Tile>();
        for (int r=0; r<GameConstants.WORLDSIZE; r++) {
            for (int c=0; c<GameConstants.WORLDSIZE; c++) {
                Position p = new Position(r,c);
                world.put(p, new TileImpl(p, GameConstants.PLAINS));
            }
        }

	world.put(new Position(1,0),
		  new TileImpl(new Position(1,0), GameConstants.OCEANS));
	world.put(new Position(0,1),
		  new TileImpl(new Position(0,1), GameConstants.HILLS));
	world.put(new Position(2,2),
		  new TileImpl(new Position(2,2), GameConstants.MOUNTAINS));

	return world;
    }
}
