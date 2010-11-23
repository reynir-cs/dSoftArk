package hotciv.variants;

import hotciv.framework.*;
import hotciv.common.*;

public class EpsilonCivFactory extends StrategyFactory {

    public EpsilonCivFactory(DieRollStrategy dieRollStrategy) {
        this.eventController = new GameEventController();
        this.agingStrategy = new LinearAgingStrategy();
        this.winningStrategy = ThreeKillWinStrategy.create(eventController);
        this.actionStrategy = new VoidActionStrategy();
        this.cityLayoutStrategy = new SimpleCityLayoutStrategy();
        this.worldLayoutStrategy = new SimpleWorldLayoutStrategy();
        this.fightingStrategy = new AdvancedFightingStrategy(dieRollStrategy);
    }
}
