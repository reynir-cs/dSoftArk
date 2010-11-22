package hotciv.variants;

import hotciv.framework.*;
import hotciv.common.*;

public class FairDieRollStrategy implements DieRollStrategy {

    public int roll() {
	return (int) (Math.random() * 6 + 1);
    }
}
