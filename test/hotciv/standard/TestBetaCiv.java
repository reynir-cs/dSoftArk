package hotciv.standard;

import hotciv.framework.*;

import org.junit.*;
import static org.junit.Assert.*;

public class TestBetaCiv {
    private Game game;

    @Before
	public void setUp() {
	game = new GameImpl(new SlowingAgingStrategy(), 
                new ConquerAllWinningStrategy(), new VoidActionStrategy());
    }
    
    private void endRound() {
	game.endOfTurn();
	game.endOfTurn();
    }

    private void skipNRounds(int n) {
	for (int i=0; i<n; i++) {
	    endRound();
	}
    }

    @Test
	public void yearInSecondRoundIs3900BC() {
	endRound();
	assertEquals("The year in second round should be 3900BC",
		     -3900, game.getAge());
    }

    @Test
	public void yearInRound40Is100BC() {
	skipNRounds(39);
	assertEquals("The year in round 40 should be 100BC",
		     -100, game.getAge());
    }
    
    @Test
	public void yearInRound41Is1BC() {
	skipNRounds(40);
	assertEquals("The year in round 41 should be 1BC",
		     -1, game.getAge());
    }

    @Test
	public void yearInRound42Is1AD() {
	skipNRounds(41);
	assertEquals("The year in round 42 should be 1AD",
		     1, game.getAge());
    }
    
    @Test
	public void yearInRound43Is50AD() {
	skipNRounds(42);
	assertEquals("The year in round 43 should be 50AD",
		     50, game.getAge());
    }

    @Test 
	public void yearInRound77Is1750AD() {
	skipNRounds(76);
	assertEquals("The year in round 77 should be 1750 AD",
		     1750, game.getAge());
    }
    
    @Test
	public void yearInRound83Is1900AD() {
	skipNRounds(82);
	assertEquals("The year in round 83 should be 1900 AD",
		     1900, game.getAge());
    }

    @Test
	public void yearInRound97Is1970AD() {
	skipNRounds(96);
	assertEquals("The year in round 97 should be 1970 AD",
		     1970, game.getAge());
    }

    @Test
	public void yearInRound127Is2000AD() {
	skipNRounds(126);
	assertEquals("The year in round 127 should be 2000 AD",
		     2000, game.getAge());
    }

    @Test
        public void blueWinsAfterConqueringRedCity() {
        Position redCityPosition = new Position(1,1);
        Position blueLegionStart = new Position(3,2);
        game.endOfTurn();
        game.moveUnit(blueLegionStart, new Position(2,1));
        endRound();
        game.moveUnit(new Position(2,1), redCityPosition);
        City redCity = game.getCityAt(redCityPosition);
        assertEquals("Blue should become the owner of red's city after moving his legion "
                     + "onto it", Player.BLUE, redCity.getOwner());
        assertEquals("Blue should win after conquering red's city",
                     Player.BLUE, game.getWinner());
    }

    @Test
        public void redWinsAfterConqueringBlueCity() {
        Position blueCityPosition = new Position(4,1);
        Position redArcherStart = new Position(2,0);
        game.moveUnit(redArcherStart, new Position(3,1));
        endRound();
        game.moveUnit(new Position(3,1), blueCityPosition);
        City blueCity = game.getCityAt(blueCityPosition);
        assertEquals("Red should become the owner of blue's city after moving his archer "
                     + "onto it", Player.RED, blueCity.getOwner());
        assertEquals("Red should win after conquering blue's city",
                     Player.RED, game.getWinner());

    }
}
