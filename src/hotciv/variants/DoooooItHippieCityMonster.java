package hotciv.variants;

import hotciv.framework.*;
import hotciv.common.*;
import java.util.Map;
import java.util.HashMap;

/** An implementation of CityLayoutStrategy.
 * The rather obscure name of this class is derived from a rather obscure
 * stack trace produced by the gcalcli python program. The program has been
 * included in the ubuntu repositories for a number of years.
 * http://code.google.com/p/gcalcli/issues/detail?id=18 
 */
public class DoooooItHippieCityMonster implements CityLayoutStrategy {
    public Map<Position, City> getCities() {
        Map<Position, City> cities = new HashMap<Position, City>();
        cities.put(new Position(8,12), new CityImpl(Player.RED));
        cities.put(new Position(4,5), new CityImpl(Player.BLUE));
        return cities;
    }
}
