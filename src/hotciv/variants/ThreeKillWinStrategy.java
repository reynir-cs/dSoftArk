package hotciv.variants;

import hotciv.framework.*;
import hotciv.common.*;

public class ThreeKillWinStrategy implements WinningStrategy, GameEventListener {
    private int redKills, blueKills;
    
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

    public void dispatch(GameEvent evt) {
        AttackerWonEvent e = (AttackerWonEvent) evt;
        if (e.attacker == Player.RED)
            redKills++;
        else
            blueKills++;
    }

    public GameEventController.EventType getType() {
        return GameEventController.EventType.ATTACKER_WON;
    }

    public static ThreeKillWinStrategy create(GameEventController eventController) {
        ThreeKillWinStrategy thunk = new ThreeKillWinStrategy();
        eventController.subscribe(thunk);
        return thunk;
    }
}
