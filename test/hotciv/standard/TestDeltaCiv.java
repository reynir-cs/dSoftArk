package hotciv.standard;

import hotciv.framework.*;
import hotciv.common.*;
import hotciv.variants.*;

import org.junit.*;
import static org.junit.Assert.*;

public class TestDeltaCiv {
    private Game game;

    @Before
        public void setUp() {
        game = new GameImpl(new DeltaCivFactory());
    }

    @Test
        public void redHasCityAt8_12() {
            assertNotNull("Red should have a city here.",
                    game.getCityAt(new Position(8,12)));
        }
    
    @Test
        public void thereIsOceanAt0_0() {
            assertEquals("There should be ocean at (0,0).",
                    GameConstants.OCEANS, game.getTileAt(
                        new Position(0,0)).getTypeString());
        }
}
