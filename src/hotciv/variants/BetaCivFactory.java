package hotciv.variants;

import hotciv.framework.*;

public class BetaCivFactory extends StrategyFactory {

    public BetaCivFactory() {
        this.eventController = new GameEventController();
        this.agingStrategy = new SlowingAgingStrategy();
        this.winningStrategy = new ConquerAllWinningStrategy();
        this.actionStrategy = new VoidActionStrategy();
        this.cityLayoutStrategy = new SimpleCityLayoutStrategy();
        this.worldLayoutStrategy = new SimpleWorldLayoutStrategy();
        this.fightingStrategy = new SimpleFightingStrategy();
    }
}
