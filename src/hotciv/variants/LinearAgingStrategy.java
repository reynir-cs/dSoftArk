package hotciv.variants;

import hotciv.framework.*;
import hotciv.common.*;

public class LinearAgingStrategy implements AgingStrategy {
    public int getYear(int round) {
	return 100 * round - 4000;
    }
}
