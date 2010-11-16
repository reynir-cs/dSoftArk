package hotciv.standard;

import hotciv.framework.*;
import java.util.Map;
import java.util.HashMap;

public class DoooooItHippieCityMonster implements CityLayoutStrategy {
    public Map<Position, City> getCities() {
        Map<Position, City> cities = new HashMap<Position, City>();
        cities.put(new Position(8,12), new CityImpl(Player.RED));
        cities.put(new Position(4,5), new CityImpl(Player.BLUE));
        return cities;
    }
}
