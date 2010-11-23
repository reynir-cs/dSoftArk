package hotciv.variants;

import hotciv.framework.*;

public class AlphaCivFactory extends StrategyFactory {

    public AlphaCivFactory() {
        this.eventController = new GameEventController();
        this.agingStrategy = new LinearAgingStrategy();
        this.winningStrategy = new SimpleWinningStrategy();
        this.actionStrategy = new VoidActionStrategy();
        this.cityLayoutStrategy = new SimpleCityLayoutStrategy();
        this.worldLayoutStrategy = new SimpleWorldLayoutStrategy();
        this.fightingStrategy = new SimpleFightingStrategy();
    }
}
