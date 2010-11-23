package hotciv.variants;

import hotciv.framework.*;
import hotciv.common.*;

public class SlowingAgingStrategy implements AgingStrategy {
    public int getYear(int round) {
        if (round < 40)
            return round * 100 - 4000;
        if (round == 40)
            return -1;
        if (round == 41)
            return 1;
        if (round < 76)
            return (round - 41) * 50;
        if (round < 82)
            return (round - 76) * 25 + 1750;
        if (round < 96)
            return (round - 82) * 5 + 1900;
        return (round - 96) + 1970;
    }
}
