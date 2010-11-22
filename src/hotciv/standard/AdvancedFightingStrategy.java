package hotciv.standard;

import hotciv.framework.*;

public class AdvancedFightingStrategy implements FightingStrategy {
    DieRollStrategy dieRollStrategy;

    public AdvancedFightingStrategy(DieRollStrategy dieRollStrategy) {
        this.dieRollStrategy = dieRollStrategy;
    }

    public boolean attackerWins(Game game, Position attackerPosition, 
            Position defenderPosition) {
        int dieOne = dieRollStrategy.roll();
        int dieTwo = dieRollStrategy.roll();

        Unit attacker = game.getUnitAt(attackerPosition);
        Unit defender = game.getUnitAt(defenderPosition);
        
        int attackingForce = attacker.getAttackingStrength();
        int defendingForce = defender.getDefensiveStrength();

	return attackingForce*dieOne > defendingForce*dieTwo;
    }
}
