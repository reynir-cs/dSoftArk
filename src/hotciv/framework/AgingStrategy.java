package hotciv.framework;

public interface AgingStrategy {
    /** return the year of the next round, given the year in the current round.
     * @param currentYear the year of the current round
     * @return year of the next round
     */
    public int getYear(int currentYear);
}
