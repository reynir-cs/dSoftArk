package hotciv.standard;

import hotciv.framework.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;
import java.util.Collection;

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
    private AgingStrategy agingStrategy;
    private WinningStrategy winningStrategy;
    private ActionStrategy actionStrategy;

    public GameImpl(AgingStrategy agingStrategy, 
            WinningStrategy winningStrategy, ActionStrategy actionStrategy) {
	this.agingStrategy = agingStrategy;
	this.winningStrategy = winningStrategy;
        this.actionStrategy = actionStrategy;
	inTurn = Player.RED;
	year = -4000;
	units = new HashMap<Position, Unit>();
        units.put(new Position(2,0), new UnitImpl(GameConstants.ARCHER,
                    Player.RED, year - 1));
        units.put(new Position(4,3), new UnitImpl(GameConstants.SETTLER,
                    Player.RED, year - 1));
        units.put(new Position(3,2), new UnitImpl(GameConstants.LEGION,
                    Player.BLUE, year - 1));
	cities = new HashMap<Position, City>();
	cities.put(new Position(1,1), new CityImpl(Player.RED));
        cities.put(new Position(4,1), new CityImpl(Player.BLUE));
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
	return winningStrategy.getWinner(this);
    }
    
    public int getAge() {
	return year;
    }

    private boolean unitCanMoveOnTile(Tile t) {
	String tileType = t.getTypeString();
	return !tileType.equals(GameConstants.MOUNTAINS)
	    && !tileType.equals(GameConstants.OCEANS);
    }

    private boolean isValidMove(Position from, Position to) {
	Tile targetTile = getTileAt(to);
	boolean legalTileType = unitCanMoveOnTile(targetTile);
	boolean legalDistance = Math.abs(to.getRow() - from.getRow()) <= 1
	    && Math.abs(to.getColumn() - from.getColumn()) <= 1;

	Unit u = getUnitAt(from);
        boolean isFortified = u.isFortified();
	Player p = u.getOwner();
	boolean isOwner = (p == inTurn);

        return legalTileType && legalDistance && isOwner && !isFortified;
    }

    public boolean moveUnit(Position from, Position to) {
	if (!isValidMove(from, to))
	    return false;
	Unit u = units.get(from);
	if (u.getLastMoved() == year)
	    return false;

	units.remove(from);
	Unit newUnit = new UnitImpl(u.getTypeString(), u.getOwner(), year);
	units.put(to, newUnit);
        if (getCityAt(to) != null) {
            City conquered = getCityAt(to);
            cities.put(to, new CityImpl(u.getOwner(), conquered.getProduction(),
                                        conquered.getProductionAmount()));
        }
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
	year = agingStrategy.getYear(year);
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
	    String type = c.getProduction();
	    int cost = 0;

	    if (type.equals(GameConstants.ARCHER)) {
		cost = 10;
	    } else if (type.equals(GameConstants.LEGION)) {
		cost = 15;
	    } else if (type.equals(GameConstants.SETTLER)) {
		cost = 30;
	    } 

	    if (c.getProductionAmount() >= cost) {
		Position free = getNextFreeUnitPosition(p);
		if (free != null) {
		    units.put(free, new UnitImpl(type, c.getOwner(), year - 1));
		    cities.put(p, new CityImpl(c.getOwner(), type,
					       c.getProductionAmount() - cost));
		}
	    }
	}
    }

    /**
     * The offsets are prioritized like this:
     * +-+-+-+
     * |8|1|2|
     * +-+-+-+
     * |7|0|3|
     * +-+-+-+
     * |6|5|4|
     * +-+-+-+
     * Where 0 is the city it is produced.
     */
    private int[] unitColOffsets = { 0, 0, 1, 1, 1, 0, -1, -1, -1 };
    private int[] unitRowOffsets = { 0, -1, -1, 0, 1, 1, 1, 0, -1 };

    private Position getNextFreeUnitPosition(Position city) {
	for (int i = 0; i<9; i++) {
	    Position p = new Position(city.getRow() + unitRowOffsets[i],
				      city.getColumn() + unitColOffsets[i]);
	    if (getUnitAt(p) == null &&
		!getTileAt(p).getTypeString().equals(GameConstants.MOUNTAINS) &&
		!getTileAt(p).getTypeString().equals(GameConstants.OCEANS)) {
		return p;
	    }
	}
	return null;
    }

    public void changeWorkForceFocusInCityAt( Position p, String balance ) {}

    public void changeProductionInCityAt( Position p, String unitType ) {
	City old = cities.get(p);
	if (old.getOwner() != inTurn)
	    return;
        cities.put(p, new CityImpl(old.getOwner(), unitType,
                    old.getProductionAmount()));
    }

    public void performUnitActionAt( Position p ) {
        units.put(p, actionStrategy.performUnitActionAt(this, p));
    }

    public Collection<City> getCities() {
        return Collections.unmodifiableCollection(cities.values());
    }

    public void addCityAt(Position p, City c) {
	cities.put(p, c);
    }
}
