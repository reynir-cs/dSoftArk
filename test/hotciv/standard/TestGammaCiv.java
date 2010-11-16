package hotciv.standard;

import org.junit.*;
import static org.junit.Assert.*;

import hotciv.framework.*;

public class TestGammaCiv {
    private Game game;
    @Before
        public void setUp() {
        game = new GameImpl(new LinearAgingStrategy(), new SimpleWinningStrategy(),
                            new SettlerAndArcherStrategy());
    }
        
    @Test
        public void redArcherCannotMoveAfterPerformingAction() {
        game.performUnitActionAt(new Position(2,0));
        game.moveUnit(new Position(2,0), new Position(3,0));
        assertNull("Red archer should not be able to move after being fortified",
                   game.getUnitAt(new Position(3,0)));
    }
}

