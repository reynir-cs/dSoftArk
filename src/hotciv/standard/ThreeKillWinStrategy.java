package hotciv.standard;

import hotciv.framework.*;

public class ThreeKillWinStrategy implements WinningStrategy, FightingStrategy {
    private int redKills, blueKills;
    FightingStrategy fightingStrategy;
    
    public ThreeKillWinStrategy(FightingStrategy fightingStrategy) {
	redKills = 0;
	blueKills = 0;
	this.fightingStrategy = fightingStrategy;
    }

    public Player getWinner(Game game) {
	if (redKills >= 3)
	    return Player.RED;
	if (blueKills >= 3)
	    return Player.BLUE;
	return null;
    }

    public boolean attackerWins(Game game, Position attackerPosition, 
				Position defenderPosition) {
	Unit u = game.getUnitAt(attackerPosition);
	boolean result = fightingStrategy.attackerWins(game,attackerPosition,
						       defenderPosition);

	if (result) {
	    if (u.getOwner() == Player.RED)
		redKills++;
	    else
		blueKills++;
	}

	return result;
    }
}
