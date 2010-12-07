package hotciv.variants;

import hotciv.framework.*;

public class GammaCivFactory extends StrategyFactory {

    public GammaCivFactory() {
        ActionStrategy as = new ActionStrategy() {
                private final ActionStrategy settlerStrat =
                    new SettlerActionStrategy();
                private final ActionStrategy archerStrat =
                    new ArcherActionStrategy();

                public Unit performUnitActionAt(Game game, Position pos) {
                    Unit u = game.getUnitAt(pos);
                    if (u.getTypeString().equals(GameConstants.SETTLER))
                        return settlerStrat.performUnitActionAt(game, pos);
                    if (u.getTypeString().equals(GameConstants.ARCHER))
                        return archerStrat.performUnitActionAt(game, pos);
                    return u;
                }
            };

        this.eventController = new GameEventController();
        this.agingStrategy = new LinearAgingStrategy();
        this.winningStrategy = new SimpleWinningStrategy();
        this.actionStrategy = as;
        this.cityLayoutStrategy = new SimpleCityLayoutStrategy();
        this.worldLayoutStrategy = new SimpleWorldLayoutStrategy();
        this.fightingStrategy = new SimpleFightingStrategy();
    }
}
