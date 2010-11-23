package hotciv.variants;

import hotciv.framework.*;
import hotciv.common.*;

public class ThreeKillWinStrategy implements WinningStrategy, GameEventListener {
    private int redKills, blueKills;
    FightingStrategy fightingStrategy;
    
    public ThreeKillWinStrategy() {
	redKills = 0;
	blueKills = 0;
    }

    public Player getWinner(Game game) {
	if (redKills >= 3)
	    return Player.RED;
	if (blueKills >= 3)
	    return Player.BLUE;
	return null;
    }

    public void dispatch(Object o) {
        Player p = (Player) o;
        if (p == Player.RED)
            redKills++;
        else
            blueKills++;
    }

    public String getType() {
        return "ATTACKER_WON";
    }

    public static ThreeKillWinStrategy create(GameEventController eventController) {
        ThreeKillWinStrategy thunk = new ThreeKillWinStrategy();
        eventController.subscribe(thunk);
        return thunk;
    }
}
