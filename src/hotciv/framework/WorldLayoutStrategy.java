package hotciv.framework;

import java.util.Map;

public interface WorldLayoutStrategy {

    /** get the layout of the game's world.
     * @return a map from positions to tiles defining the game's world
     */
    public Map<Position, Tile> getWorld();
}
