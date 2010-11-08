package hotciv.standard;

import hotciv.framework.*;
import java.util.HashMap;
import java.util.Map;

/** Skeleton implementation of HotCiv.
 
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

public class GameImpl implements Game {
    private Player inTurn;
    private int year;
    private Map<Position, Unit> units;
    private Map<Position, City> cities;

    public GameImpl() {
	inTurn = Player.RED;
	year = -4000;
	units = new HashMap<Position, Unit>();
	units.put(new Position(2,0), new UnitImpl(GameConstants.ARCHER, Player.RED));
	units.put(new Position(4,3), new UnitImpl(GameConstants.SETTLER, Player.RED));
	units.put(new Position(3,2), new UnitImpl(GameConstants.LEGION, Player.BLUE));
	cities = new HashMap<Position, City>();
	cities.put(new Position(1,1), new CityImpl(Player.RED, GameConstants.ARCHER, 0));
	cities.put(new Position(4,1), new CityImpl(Player.BLUE, GameConstants.ARCHER, 0));
    }

    public Tile getTileAt( Position p ) {
	if (p.getRow() == 1 && p.getColumn() == 0)
	    return new TileImpl(p,GameConstants.OCEANS);
	if (p.getRow() == 0 && p.getColumn() == 1)
	    return new TileImpl(p,GameConstants.HILLS);
	if (p.getRow() == 2 && p.getColumn() == 2)
	    return new TileImpl(p,GameConstants.MOUNTAINS);
	return new TileImpl(p,GameConstants.PLAINS);
    }

    public Unit getUnitAt( Position p ) {
	return units.get(p);
    }

    public City getCityAt( Position p ) {
	return cities.get(p);
    }

    public Player getPlayerInTurn() {
	return inTurn;
    }

    public Player getWinner() {
	if (year >= -3000)
	    return Player.RED;
	return null;
    }
    
    public int getAge() {
	return year;
    }

    private boolean isValidMove(Position from, Position to) {
	String tileType = getTileAt(to).getTypeString();

	boolean legalTileType = !tileType.equals(GameConstants.MOUNTAINS)
	    && !tileType.equals(GameConstants.OCEANS);
	boolean legalDistance = Math.abs(to.getRow() - from.getRow()) <= 1
	    && Math.abs(to.getColumn() - from.getColumn()) <= 1;

	Unit u = getUnitAt(from);
	Player p = u.getOwner();
	boolean isOwner = (p == inTurn);

	return legalTileType && legalDistance && isOwner;
    }

    public boolean moveUnit(Position from, Position to) {
	if (!isValidMove(from, to))
	    return false;
	Unit u = units.remove(from);
	units.put(to, u);
	return true;
    }

    public void endOfTurn() {
	if (inTurn == Player.RED) {
	    inTurn = Player.BLUE;
	} else {
	    inTurn = Player.RED;
	    endOfRound();
	}
    }

    private void endOfRound() {
	year += 100;
	incrementProductionAmount();
	produceUnits();
    }

    private void incrementProductionAmount() {
	for (Position p : cities.keySet()) {
	    City old = cities.get(p);
	    cities.put(p, new CityImpl(old.getOwner(), old.getProduction(),
				       old.getProductionAmount() + 6));
	}
    }

    private void produceUnits() {
	for (Position p : cities.keySet()) {
	    City c = cities.get(p);
	    if (c.getProductionAmount() >= 10) {
		units.put(p, new UnitImpl(GameConstants.ARCHER, c.getOwner()));
	    }
	}
    }

    public void changeWorkForceFocusInCityAt( Position p, String balance ) {}

    public void changeProductionInCityAt( Position p, String unitType ) {
	City old = cities.get(p);
	cities.put(p, new CityImpl(old.getOwner(), unitType, old.getProductionAmount()));
    }

    public void performUnitActionAt( Position p ) {}
}
