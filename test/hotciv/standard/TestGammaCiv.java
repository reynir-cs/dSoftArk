package hotciv.standard;

import hotciv.framework.*;

import org.junit.*;
import static org.junit.Assert.*;

public class TestGammaCiv {
    private Game game;

    @Before
        public void setUp() {
            game = new GameImpl(new LinearAgingStrategy(),
                    new SimpleWinningStrategy(), 
                    new SettlerAndArcherActionStrategy());
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
            
}
