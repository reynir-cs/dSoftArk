package hotciv.variants;

import hotciv.framework.*;
import hotciv.common.*;
import java.util.Collection;

public class ConquerAllWinningStrategy implements WinningStrategy {
    public Player getWinner(Game game) {
        Collection<City> cities = game.getCities();
        Player winner = null;
        for (City c : cities) {
            if (winner == null)
                winner = c.getOwner();
            if (c.getOwner() != winner)
                return null;
        }
        return winner;
    }
}
