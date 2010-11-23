package hotciv.variants;

import hotciv.framework.*;
import hotciv.common.*;

import org.junit.*;
import static org.junit.Assert.*;

public class TestZetaCiv {
    private Game game;

    @Before
        public void setUp() {
        GameEventController eventController = new GameEventController();
        WinningStrategy winningStrategy = 
            ChangingWinningStrategy.create(eventController);
	game = new GameImpl(eventController,
                            new LinearAgingStrategy(),
			    winningStrategy,
			    new VoidActionStrategy(),
			    new SimpleCityLayoutStrategy(),
			    new SimpleWorldLayoutStrategy(),
			    new SimpleFightingStrategy());
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
        public void redArcherConquerorsRedsCityAndWinsInRoundTwo() {
	Position settlerPos = new Position(4, 3);
	Position intermediatePos = new Position(4, 2);
	Position blueCityPos = new Position(4, 1);
        game.moveUnit(settlerPos, intermediatePos);
        endRound();
        game.moveUnit(intermediatePos, blueCityPos);
        assertEquals("Red should be the winner now",
                     Player.RED, game.getWinner());
    }

    @Test
	public void blueWinsTheGameAfterWinningThreeAttacksAfter20Rounds() {
        skipNRounds(20);

	Position settlerPos = new Position(4, 3);
	Position legionPos = new Position(3, 2);

	// Go to Blue's turn
	game.endOfTurn();


        game.moveUnit(new Position(3,0), new Position(2,0));
        
        game.moveUnit(new Position(3,1), new Position(2,1));
	
	// At this point there should be no winner
	assertNull("No one should have won yet",
		   game.getWinner());

	// Kill the Settler
	game.moveUnit(legionPos, settlerPos);

	// Now Blue should have won
	assertEquals("Blue should have won by now",
		     Player.BLUE, game.getWinner());
    }

}
