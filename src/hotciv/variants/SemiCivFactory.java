package hotciv.variants;

import hotciv.framework.*;

public class SemiCivFactory extends StrategyFactory {

    public SemiCivFactory(DieRollStrategy dieRollStrategy) {
        String[] layout = new String[] {
            "...ooMooooo.....",
            "..ohhoooofffoo..",
            ".oooooMooo...oo.",
            ".ooMMMoooo..oooo",
            "...ofooohhoooo..",
            ".ofoofooooohhoo.",
            "...ooo..........",
            ".ooooo.ooohooM..",
            ".ooooo.oohooof..",
            "offfoooo.offoooo",
            "oooooooo...ooooo",
            ".ooMMMoooo......",
            "..ooooooffoooo..",
            "....ooooooooo...",
            "..ooohhoo.......",
            ".....ooooooooo.."

        };

        this.eventController = new GameEventController();
        this.agingStrategy = new SlowingAgingStrategy();
        this.winningStrategy = ThreeKillWinStrategy.create(eventController);
        this.actionStrategy = new SettlerActionStrategy();
        this.cityLayoutStrategy = new DoooooItHippieCityMonster();
        this.worldLayoutStrategy = new DynamicWorldLayoutStrategy(layout);
        this.fightingStrategy = new AdvancedFightingStrategy(dieRollStrategy);
    }
}
