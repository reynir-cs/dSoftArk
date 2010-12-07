package hotciv.variants;

import hotciv.framework.*;
import hotciv.common.*;
import java.util.Map;
import java.util.HashMap;
import thirdparty.ThirdPartyFractalGenerator;

public class FractalWorldLayoutStrategy implements WorldLayoutStrategy {
    private Map<Position, Tile> world;

    public FractalWorldLayoutStrategy() {
        ThirdPartyFractalGenerator generator = new ThirdPartyFractalGenerator();
        String[] map = new String[GameConstants.WORLDSIZE];
        String line;
        for ( int r = 0; r < GameConstants.WORLDSIZE; r++ ) {
            line = "";
            for ( int c = 0; c < GameConstants.WORLDSIZE; c++ ) {
                line = line + generator.getLandscapeAt(r,c);
            }
            map[r] = line;
        }
        world = (new DynamicWorldLayoutStrategy(map)).getWorld();
    }

    public Map<Position, Tile> getWorld() {
        return world;
    }
}
