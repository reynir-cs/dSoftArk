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

        int attackingForce = attacker.getAttackingStrength()
            + countFriends(game, attackerPosition);
        int defendingForce = defender.getDefensiveStrength()
            + countFriends(game, defenderPosition);

        attackingForce *= getTerrainFactor(game, attackerPosition);
        defendingForce *= getTerrainFactor(game, defenderPosition);

	return attackingForce*dieOne > defendingForce*dieTwo;
    }

    private int countFriends(Game game, Position unitPosition) {
        int[] unitColOffsets = { 0, 1, 1, 1, 0, -1, -1, -1 };
        int[] unitRowOffsets = { -1, -1, 0, 1, 1, 1, 0, -1 };

        Player owner = game.getUnitAt(unitPosition).getOwner();

        int count = 0;
        for (int i = 0; i < 8; i++) {
            Position p = new Position(unitPosition.getRow() + unitRowOffsets[i],
                                      unitPosition.getColumn() + unitColOffsets[i]);
            Unit u = game.getUnitAt(p);
            if (u != null && u.getOwner() == owner)
                count++;
        }
        return count;
    }

    private int getTerrainFactor(Game game, Position unitPosition) {
        if (game.getCityAt(unitPosition) != null)
            return 3;

        Tile t = game.getTileAt(unitPosition);
        if (t.getTypeString().equals(GameConstants.FOREST)
            || t.getTypeString().equals(GameConstants.HILLS))
            return 2;

        return 1;
    }
}
