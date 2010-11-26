package hotciv.variants;

import hotciv.framework.*;
import hotciv.common.*;

public class ChangingWinningStrategy implements WinningStrategy, GameEventListener {
    private GameEventController eventController;
    private WinningStrategy currWin;
    private int round;

    public ChangingWinningStrategy(GameEventController eventController) {
        this.eventController = eventController;
        this.currWin = new ConquerAllWinningStrategy();
        round = 0;
    }

    public Player getWinner(Game game) {
	return currWin.getWinner(game);
    }

    public void dispatch(GameEvent evt) {
        round++;
        if (round == 20) {
            currWin = ThreeKillWinStrategy.create(eventController);
            eventController.unsubscribe(this);
        }
    }

    public GameEventController.EventType getType() {
        return GameEventController.EventType.NEW_ROUND;
    }

    public static ChangingWinningStrategy create(GameEventController eventController) {
        ChangingWinningStrategy thunk = 
            new ChangingWinningStrategy(eventController);
        eventController.subscribe(thunk);
        return thunk;
    }
}
