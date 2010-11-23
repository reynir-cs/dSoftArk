package hotciv.variants;

import hotciv.framework.*;

public class ZetaCivFactory extends StrategyFactory {

    public ZetaCivFactory() {
        this.eventController = new GameEventController();
        this.agingStrategy = new LinearAgingStrategy();
        this.winningStrategy = ChangingWinningStrategy.create(eventController);
        this.actionStrategy = new VoidActionStrategy();
        this.cityLayoutStrategy = new SimpleCityLayoutStrategy();
        this.worldLayoutStrategy = new SimpleWorldLayoutStrategy();
        this.fightingStrategy = new SimpleFightingStrategy();
    }
}
