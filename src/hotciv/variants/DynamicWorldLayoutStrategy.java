package hotciv.variants;

import hotciv.framework.*;
import hotciv.common.*;
import java.util.Map;
import java.util.HashMap;

public class DynamicWorldLayoutStrategy implements WorldLayoutStrategy {
    private Map<Position, Tile> world;

    public DynamicWorldLayoutStrategy(String[] map) {
        world = new HashMap<Position, Tile>();
        String line;
        for ( int r = 0; r < GameConstants.WORLDSIZE; r++ ) {
            line = map[r];
            for ( int c = 0; c < GameConstants.WORLDSIZE; c++ ) {
                char tileChar = line.charAt(c);
                String type = "error";
                if ( tileChar == '.' ) 
                    type = GameConstants.OCEANS;
                if ( tileChar == 'o' ) 
                    type = GameConstants.PLAINS;
                if ( tileChar == 'M' ) 
                    type = GameConstants.MOUNTAINS;
                if ( tileChar == 'f' ) 
                    type = GameConstants.FOREST;
                if ( tileChar == 'h' ) 
                    type = GameConstants.HILLS;
                Position p = new Position(r,c);
                world.put( p, new TileImpl(p, type));
            }
        }
    }

    public Map<Position, Tile> getWorld() {
        return world;
    }
}
