package hotciv.framework;

public interface FightingStrategy {
    /** return whether the attacking unit wins or not, i.e. loses.
     * @precondition there are units at the two positions and the attack is legal.
     * @param game the game object in question
     * @param attackerPosition the position of the attacking unit
     * @param defenderPosition the position of the defending unit
     * @return true iff the unit at attackerPosition wins
     */
    public boolean attackerWins(Game game, Position attackerPosition, 
				Position defenderPosition);
}
