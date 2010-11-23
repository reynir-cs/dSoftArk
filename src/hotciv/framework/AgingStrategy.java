package hotciv.framework;

public interface AgingStrategy {
    /** return a year given a round number.
     * @precondition round >= 0
     * @param round the round for which to calculate the year
     * @return year the year of the corresponding round
     */
    public int getYear(int round);
}
