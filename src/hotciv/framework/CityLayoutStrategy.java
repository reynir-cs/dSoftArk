package hotciv.framework;

import java.util.Map;

public interface CityLayoutStrategy {

    /** get the initial placements of the players' cities
     * @return a map from positions to cities
     */
    public Map<Position, City> getCities();
}
