package hotciv.standard;

import hotciv.framework.*;

public class LinearAgingStrategy implements AgingStrategy {
    public int getYear(int currentYear) {
	return currentYear + 100;
    }
}
