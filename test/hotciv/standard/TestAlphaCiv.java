package hotciv.standard;

import hotciv.framework.*;

import org.junit.*;
import static org.junit.Assert.*;

/** Skeleton class for AlphaCiv test cases

This source code is from the book 
"Flexible, Reliable Software:
Using Patterns and Agile Development"
published 2010 by CRC Press.
Author: 
Henrik B Christensen 
Computer Science Department
Aarhus University
   
This source code is provided WITHOUT ANY WARRANTY either 
expressed or implied. You may study, use, modify, and 
distribute it for non-commercial purposes. For any 
commercial use, see http://www.baerbak.com/
*/
public class TestAlphaCiv {
    private static Position mountainPosition = new Position(2,2);
    private static Position oceanPosition = new Position(1,0);
    private static Position redCityPosition = new Position(1,1);
    private static Position blueCityPosition = new Position(4,1);
    private Game game;
    private UnitInfo archer;
    private UnitInfo legion;
    private UnitInfo settler;
    
    private class UnitInfo {
	public Position pos;
	public Player owner;
	public String type;
	
	public UnitInfo(int row, int column, Player owner, String type) {
	    this.pos = new Position(row, column);
	    this.owner = owner;
	    this.type = type;
	}
    }

    /** Fixture for alphaciv testing. */
    @Before
	public void setUp() {
	game = new GameImpl();
	archer = new UnitInfo(2, 0, Player.RED, GameConstants.ARCHER);
	legion = new UnitInfo(3, 2, Player.BLUE, GameConstants.LEGION);
	settler = new UnitInfo(4, 3, Player.RED, GameConstants.SETTLER);
    }

    @Test
	public void shouldHaveRedCityAt1_1() {
	City c = game.getCityAt(redCityPosition);
	assertNotNull("There should be a city at " + redCityPosition, c);
	Player p = c.getOwner();
	assertEquals( "City at " + redCityPosition + " should be owned by red",
		      Player.RED, p );
    }

    @Test
	public void shouldHaveBlueCityAt4_1() {
	City c = game.getCityAt(blueCityPosition);
	assertNotNull("There should be a city at " + blueCityPosition, c);
	Player p = c.getOwner();
	assertEquals( "City at " + blueCityPosition + " should be owned by blue",
		      Player.BLUE, p );
    }

    @Test
	public void shouldHaveOceanAt1_0() {
        Tile t = game.getTileAt(oceanPosition);
	assertNotNull("There should be a tile at " + oceanPosition, t);
	assertEquals( "Tile at " + oceanPosition + " should be ocean",
		      GameConstants.OCEANS, t.getTypeString() );
    }

    @Test
	public void shouldHaveHillsAt0_1() {
        Tile t = game.getTileAt(new Position(0,1));
	assertNotNull("There should be a tile at (0,1)", t);
	assertEquals( "Tile at (0,1) should be hill",
		      GameConstants.HILLS, t.getTypeString() );
    }

    @Test
	public void shouldHavePlainsAt4_5() {
        Tile t = game.getTileAt(new Position(4,5));
	assertNotNull("There should be a tile at (4,5)", t);
	assertEquals( "Tile at (4,5) should be plains",
		      GameConstants.PLAINS, t.getTypeString() );
    }

    @Test
	public void shouldHaveMountainsAt2_2() {
        Tile t = game.getTileAt(mountainPosition);
	assertNotNull("There should be a tile at " + mountainPosition, t);
	assertEquals( "Tile at " + mountainPosition + " should be mountains",
		      GameConstants.MOUNTAINS, t.getTypeString() );
    }

    @Test
	public void shouldReportTileAt0_1As0_1() {
        Tile t = game.getTileAt(new Position(0,1));
	assertNotNull("There should be a tile at (0,1)", t);
	assertEquals( "Tile at (0,1) should report position (0,1)",
		      new Position(0,1), t.getPosition());
    }

    @Test
	public void shouldHaveRedAsStartingPlayer() {
	Player p = game.getPlayerInTurn();
	assertNotNull("There should be a player in turn", p);
	assertEquals( "The starting player in the game should be red",
		      Player.RED, p);
    }

    @Test
	public void shouldHaveBlueInTurnAfterRed() {
	Player p = game.getPlayerInTurn();
	assertNotNull("There should be a player in turn", p);
	assertEquals( "The starting player in the game should be red",
		      Player.RED, p);
	game.endOfTurn();
	p = game.getPlayerInTurn();
	assertNotNull("There should be a player in turn", p);
	assertEquals( "The player in the second turn of the game should be blue",
		      Player.BLUE, p);
    }

    @Test
	public void shouldHaveRedInTurnAfterBlue() {
	Player p = game.getPlayerInTurn();
	assertNotNull("There should be a player in turn", p);
	assertEquals( "The starting player in the game should be red",
		      Player.RED, p);
	game.endOfTurn();
	p = game.getPlayerInTurn();
	assertNotNull("There should be a player in turn", p);
	assertEquals( "The player in the second turn of the game should be blue",
		      Player.BLUE, p);
	game.endOfTurn();
	p = game.getPlayerInTurn();
	assertNotNull("There should be a player in turn", p);
	assertEquals( "The player in the third turn of the game should be red",
		      Player.RED, p);
    }

    @Test
	public void shouldStartInYear4000BC() {
	int age = game.getAge();
	assertEquals("The game should start in year 4000 BC",
		     -4000, age);
    }

    @Test
	public void shouldBeAge3900BCInSecondRound() {
	game.endOfTurn();
	game.endOfTurn();
	int age = game.getAge();
	assertEquals("The year should be 3900 BC in the second round",
		     -3900, age);
    }
    
    @Test
	public void redShouldWinInRound3000BC() {
	while (game.getAge() < -3000) {
	    assertNull("The game should not be over yet",
		       game.getWinner());
	    game.endOfTurn();
	}
	Player p = game.getWinner();
	assertNotNull("The game should be over now",
		      p);
	assertEquals("Red should have won the game",
		     Player.RED, p);
    }

    private void checkUnitAtPosition(UnitInfo unit, Position pos) {
	Unit u = game.getUnitAt(pos);
	assertNotNull("There should be a unit at " + pos,
		      u);
	assertEquals("The unit at " + pos + " should be a(n) " + unit.type,
		     unit.type, u.getTypeString());
	assertEquals("The " + unit.type + " at " + pos + " should be " + unit.owner,
		     unit.owner, u.getOwner());
    }

    private void checkUnitAtPosition(UnitInfo unit) {
	checkUnitAtPosition(unit, unit.pos);
    }

    @Test
	public void shouldHaveRedArcherAt2_0Initially() {
	checkUnitAtPosition(archer);
    }

    @Test
	public void shouldHaveRedSettlerAt4_3Initially() {
	checkUnitAtPosition(settler);
    }

    @Test
	public void shouldHaveBlueLegionAt3_2Initially() {
	checkUnitAtPosition(legion);
    }

    @Test
	public void redArcherCanMoveOneTileToTheRight() {
	Position from = archer.pos;
	Position to = new Position(archer.pos.getRow(), archer.pos.getColumn()+1);
	checkUnitAtPosition(archer);
	game.moveUnit(from, to);
	assertNull("Archer should have moved", game.getUnitAt(from));
	checkUnitAtPosition(archer, to);
    }

    private void disallowUnitMove(Position from, Position to, UnitInfo unit) {
	checkUnitAtPosition(unit, from);
	assertFalse("Move should not have been allowed",
		    game.moveUnit(from, to));
	assertNull("Unit at " + from + " should not have been allowed to move over " + to,
		   game.getUnitAt(to));
    }

    @Test
	public void legionAt3_2ShouldNotBeAbleToMoveOverMountains() {
	/* It has to be Blue's turn */
	game.endOfTurn();
	disallowUnitMove(legion.pos, mountainPosition, legion);
    }

    @Test
	public void archerAt2_0ShouldNotBeAbleToMoveOverOceans() {
	disallowUnitMove(archer.pos, oceanPosition, archer);
    }

    @Test
	public void archerAt2_0ShouldNotBeAbleToMoveTo3_3InOneMove() {
	disallowUnitMove(archer.pos, new Position(3,3), archer);
    }

    @Test
	public void redCannotMoveBlueLegionAt3_2() {
	disallowUnitMove(legion.pos, new Position(3,3), legion);
    }

    @Test
	public void blueLegionAttacksAndDestroysRedSettler() {
	/* It has to be Blue's turn */
	game.endOfTurn();
	boolean moveSuccessful = game.moveUnit(legion.pos, settler.pos);
	assertTrue("The move was not successful!",
		   moveSuccessful);
	checkUnitAtPosition(legion, settler.pos);
    }

    @Test
	public void redCityProductionAmountIs0AtFirstRound() {
	assertEquals("The production amount of the red city should be 0 in the first round",
		     0, game.getCityAt(redCityPosition).getProductionAmount());
    }

    @Test
	public void redCityProductionAmountIs6AtSecondRound() {
	// Go to second round
	game.endOfTurn();
	game.endOfTurn();

	assertEquals("The production amount of the red city should be 6 in the second round",
		     6, game.getCityAt(redCityPosition).getProductionAmount());
    }

    @Test
	public void redCanChangeProductionToLegion() {
	game.changeProductionInCityAt(redCityPosition, GameConstants.LEGION);
	City c = game.getCityAt(redCityPosition);
	assertEquals("Red city should produce legions",
		     GameConstants.LEGION, c.getProduction());
    }

    @Test
	public void redCityInitialProductionIsArcher() {
	City c = game.getCityAt(redCityPosition);
	assertEquals("Red city should produce archers initially",
		     GameConstants.ARCHER, c.getProduction());
    }

    @Test
	public void blueCanChangeProductionToLegion() {
	game.changeProductionInCityAt(blueCityPosition, GameConstants.LEGION);
	City c = game.getCityAt(blueCityPosition);
	assertEquals("Blue city should produce legions",
		     GameConstants.LEGION, c.getProduction());
    }
}
