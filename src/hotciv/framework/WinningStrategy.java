package hotciv.framework;

public interface WinningStrategy {
    /** return the winner of the game, or null if noone has won yet
     * @param game A reference to the Game object for which to decide the winner
     * @return the game winner, null if there is none
     */
    public Player getWinner(Game game);
}
