package hotciv.standard;

import hotciv.framework.*;

public class FairDieRollStrategy implements DieRollStrategy {

    public int roll() {
	return (int) (Math.random() * 6 + 1);
    }
}
