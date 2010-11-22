package hotciv.variants;

import hotciv.framework.*;
import hotciv.common.*;
import java.util.Map;
import java.util.HashMap;

public class SimpleCityLayoutStrategy implements CityLayoutStrategy {

    public Map<Position, City> getCities() {
	Map<Position, City> cities = new HashMap<Position, City>();
	cities.put(new Position(1,1), new CityImpl(Player.RED));
	cities.put(new Position(4,1), new CityImpl(Player.BLUE));
	return cities;
    }
}
