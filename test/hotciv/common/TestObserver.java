package hotciv.common;

import hotciv.framework.*;
import hotciv.common.*;
import hotciv.variants.*;

import org.junit.*;
import static org.junit.Assert.*;

public class TestObserver {
    private Game game;
    private GameObserverTester observer;

    private void endRound() {
	game.endOfTurn();
	game.endOfTurn();
    }

    @Before
        public void setUp() {
	game = new GameImpl(new AlphaCivFactory());
        observer = new GameObserverTester();
        game.addObserver(observer);
    }

    @Test
        public void eventWhenRedSettlerDies() {
        game.endOfTurn();
        assertFalse("Should NOT have recieved a world changed event",
                   observer.worldflag);
        game.moveUnit(new Position(3, 2), new Position(4, 3));
        assertTrue("Should have recieved a world changed event",
                   observer.worldflag);
    }

    @Test
        public void eventWhenRedProducesArcherAfterTwoTurns() {
        endRound();
        assertFalse("Should NOT have recieved a world changed event",
                   observer.worldflag);
        endRound();
        assertTrue("Should have recieved a world changed event",
                   observer.worldflag);
    }

    @Test
        public void eventWhenAddingCity() {
        assertFalse("Should NOT have recieved a world changed event",
                    observer.worldflag);
        game.addCityAt(new Position(5,5), new CityImpl(Player.BLUE));
        assertTrue("Should have recieved a world changed event",
                    observer.worldflag);
    }

    @Test
        public void eventAtEndOfTurn() {
        assertFalse("Should NOT have recieved a end of turn event",
                    observer.turnflag);
        game.endOfTurn();
        assertTrue("Should have recieved a end of turn event",
                    observer.turnflag);
    }
}

class GameObserverTester implements GameObserver {
    public boolean worldflag = false;
    public boolean turnflag = false;
    public void worldChangedAt(Position pos) {
        worldflag = true;
    }

    public void turnEnds(Player nextPlayer, int age) {
        turnflag = true;
    }

    public void tileFocusChangedAt(Position pos) {
    }
}

