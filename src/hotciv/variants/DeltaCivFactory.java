package hotciv.variants;

import hotciv.framework.*;

public class DeltaCivFactory extends StrategyFactory {

    public DeltaCivFactory() {
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
        this.agingStrategy = new LinearAgingStrategy();
        this.winningStrategy = new SimpleWinningStrategy();
        this.actionStrategy = new VoidActionStrategy();
        this.cityLayoutStrategy = new DoooooItHippieCityMonster();
        this.worldLayoutStrategy = new DynamicWorldLayoutStrategy(layout);
        this.fightingStrategy = new SimpleFightingStrategy();
    }
}
