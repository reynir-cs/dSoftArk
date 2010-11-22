package hotciv.variants;

import hotciv.framework.*;
import hotciv.common.*;

public class LinearAgingStrategy implements AgingStrategy {
    public int getYear(int currentYear) {
	return currentYear + 100;
    }
}
