package hotciv.variants;

import hotciv.framework.*;

public class GammaCivFactory extends StrategyFactory {

    public GammaCivFactory() {
        this.eventController = new GameEventController();
        this.agingStrategy = new LinearAgingStrategy();
        this.winningStrategy = new SimpleWinningStrategy();
        this.actionStrategy = new SettlerAndArcherActionStrategy();
        this.cityLayoutStrategy = new SimpleCityLayoutStrategy();
        this.worldLayoutStrategy = new SimpleWorldLayoutStrategy();
        this.fightingStrategy = new SimpleFightingStrategy();
    }
}
