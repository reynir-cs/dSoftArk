package hotciv.standard;

import hotciv.framework.*;

import org.junit.*;
import static org.junit.Assert.*;

public class TestEpsilonCiv {
    private Game game;

    @Before
        public void setUp() {
	game = new GameImpl(new LinearAgingStrategy(),
			    new SimpleWinningStrategy(),
			    new VoidActionStrategy(),
			    new SimpleCityLayoutStrategy(),
			    new SimpleWorldLayoutStrategy(),
			    new SimpleFightingStrategy());
        }

    @Test
	public void blueWinsTheGameAfterWinningThreeAttacks() {
	//	assertTrue(false);
	
    }
}
