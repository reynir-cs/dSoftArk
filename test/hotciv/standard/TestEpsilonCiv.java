package hotciv.standard;

import hotciv.framework.*;
import hotciv.common.*;
import hotciv.variants.*;

import org.junit.*;
import static org.junit.Assert.*;

public class TestEpsilonCiv {
    private Game game;

    @Before
        public void setUp() {
	game = new GameImpl(new EpsilonCivFactory(new FixedDieRollStrategy()));
    }

    private void endRound() {
	game.endOfTurn();
	game.endOfTurn();
    }

    @Test
	public void blueWinsTheGameAfterWinningThreeAttacks() {
	Position settlerPos = new Position(4, 3);
	Position legionPos = new Position(3, 2);
	Position archerPos = new Position(2, 0);
	Position intermediatePos = new Position(3, 1);
	Position cityPos = new Position(1, 1);

	// Go to Blue's turn
	game.endOfTurn();

	// Kill the Settler
	game.moveUnit(legionPos, settlerPos);
	
	// Wait one round
	endRound();

	// Move back
	game.moveUnit(settlerPos, legionPos);
	
	// Wait one round
	endRound();

	// Move one step left
	game.moveUnit(legionPos, intermediatePos);
	
	// Wait one round
	endRound();

	// Kill archer
	game.moveUnit(intermediatePos, archerPos);
	
        // Move red archer away from city so he's easy to kill
	game.endOfTurn();
        game.moveUnit(cityPos, new Position(2, 1));
        game.endOfTurn();

	// At this point there should be no winner
	assertNull("No one should have won yet",
		   game.getWinner());

	// Kill new archer
	game.moveUnit(archerPos, new Position(2, 1));

	// Now Blue should have won
	assertEquals("Blue should have won by now",
		     Player.BLUE, game.getWinner());
    }

    @Test
        public void blueLegionAttacksAndDestroysRedSettler() {
            Position legionPos = new Position(3, 2);
            Position settlerPos = new Position(4, 3);

            game.endOfTurn(); // Blue's turn

            game.moveUnit(legionPos, settlerPos);

            assertEquals("Blue legion should have defeated red settler",
                    GameConstants.LEGION, game.getUnitAt(settlerPos).getTypeString());
        }

    @Test
        public void redSettlerAttacksBlueLegionAndDies() {
            Position legionPos = new Position(3, 2);
            Position settlerPos = new Position(4, 3);

            game.moveUnit(settlerPos, legionPos);

            assertNull("Red settler should have died",
                       game.getUnitAt(settlerPos));
            assertEquals("Red settler should have died after attacking blue legion",
                    GameConstants.LEGION, game.getUnitAt(legionPos).getTypeString());
        }
}
