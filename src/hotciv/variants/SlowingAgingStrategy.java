package hotciv.variants;

import hotciv.framework.*;
import hotciv.common.*;

public class SlowingAgingStrategy implements AgingStrategy {
    public int getYear(int currentYear) {
	if (currentYear < -100) {
	    return currentYear + 100;
	} else if (currentYear == -100) {
	    return -1;
	} else if (currentYear == -1) {
	    return 1;
	} else if (currentYear == 1) {
	    return 50;
	} else if (currentYear < 1750) {
	    return currentYear + 50;
	} else if (currentYear < 1900) {
	    return currentYear + 25;
	} else if (currentYear < 1970) {
	    return currentYear + 5;
	} else {
	    return currentYear + 1;
	}
    }
}
