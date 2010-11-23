package hotciv.standard;

import hotciv.framework.*;
import hotciv.common.*;
import hotciv.variants.*;

import org.junit.*;
import static org.junit.Assert.*;

public class TestGammaCiv {
    private Game game;

    @Before
        public void setUp() {
	game = new GameImpl(new GameEventController(),
                            new LinearAgingStrategy(),
			    new SimpleWinningStrategy(),
			    new SettlerAndArcherActionStrategy(),
			    new SimpleCityLayoutStrategy(),
			    new SimpleWorldLayoutStrategy(),
			    new SimpleFightingStrategy());
        }

    @Test
        public void redArcherCannotMoveAfterPerformingAction() {
            game.performUnitActionAt(new Position(2,0));
            game.moveUnit(new Position(2,0), new Position(3,0));
            assertNull("Red archer should not have been allowed to move after"
                    +" being fortified.",
                    game.getUnitAt(new Position(3,0)));
        }

    @Test
        public void redArchersDefenceIsDoubledAfterFortify() {
            Position pos = new Position(2,0);
            game.performUnitActionAt(pos);
            Unit u = game.getUnitAt(pos);
            assertEquals("Archer's defensive strength should be doubled.",
                    6, u.getDefensiveStrength());
        }

    @Test
	public void redSettlerIsRemovedAfterPerformingItsAction() {
	game.performUnitActionAt(new Position(4,3));
	assertNull("Red settler should be removed after performing its action",
		   game.getUnitAt(new Position(4,3)));
    }

    @Test
	public void redSettlerBuildsRedCityAt4_3() {
	Position p = new Position(4,3);
	game.performUnitActionAt(p);
	assertNotNull("Red settler should have built a city at " + p,
		      game.getCityAt(p));
    }
}
