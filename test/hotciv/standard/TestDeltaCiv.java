package hotciv.standard;

import hotciv.framework.*;

import org.junit.*;
import static org.junit.Assert.*;

public class TestDeltaCiv {
    private Game game;

    @Before
        public void setUp() {
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

            game = new GameImpl(new LinearAgingStrategy(),
			    new SimpleWinningStrategy(),
                            new VoidActionStrategy(),
                            new DoooooItHippieCityMonster(),
                            new DynamicWorldLayoutStrategy(layout));
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
