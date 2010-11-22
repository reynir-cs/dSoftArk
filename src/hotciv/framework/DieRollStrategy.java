package hotciv.framework;

public interface DieRollStrategy {

    /** rolls a 6-sided dice
     * @return a number in the range 1..6
     */
    public int roll();
}
