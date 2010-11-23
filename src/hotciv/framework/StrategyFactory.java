package hotciv.framework;

public abstract class StrategyFactory {

    protected GameEventController eventController;
    protected AgingStrategy agingStrategy;
    protected WinningStrategy winningStrategy;
    protected ActionStrategy actionStrategy;
    protected CityLayoutStrategy cityLayoutStrategy;
    protected WorldLayoutStrategy worldLayoutStrategy;
    protected FightingStrategy fightingStrategy;

    public GameEventController getEventController() {
        return eventController;
    }

    public AgingStrategy getAgingStrategy() {
        return agingStrategy;
    }

    public WinningStrategy getWinningStrategy() {
        return winningStrategy;
    }

    public ActionStrategy getActionStrategy() {
        return actionStrategy;
    }

    public CityLayoutStrategy getCityLayoutStrategy() {
        return cityLayoutStrategy;
    }

    public WorldLayoutStrategy getWorldLayoutStrategy() {
        return worldLayoutStrategy;
    }

    public FightingStrategy getFightingStrategy() {
        return fightingStrategy;
    }
}
