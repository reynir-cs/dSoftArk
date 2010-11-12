package hotciv.standard;

import hotciv.framework.*;

public class SimpleWinningStrategy implements WinningStrategy {
    public Player getWinner(Game game) {
	return game.getAge() >= -3000 ? Player.RED : null;
    }
}
