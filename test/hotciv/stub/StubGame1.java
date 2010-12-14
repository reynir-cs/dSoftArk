package hotciv.stub;

import hotciv.framework.*;
import hotciv.common.*;

import java.util.*;

/** Test stub for game for visual testing of
 * minidraw based graphics.
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

public class StubGame1 implements Game {
    public Unit getUnitAt( Position p ) { return null; }
    public City getCityAt( Position p ) {
        if (p.getRow() == 7 && p.getColumn() == 8)
            return new CityImpl(Player.RED);
        return null;
    }
    public Player getPlayerInTurn() { return null; }
    public Player getWinner() { return null; }
    public int getAge() { return 0; }  
    public boolean moveUnit( Position from, Position to ) { return true; }
    public void endOfTurn() {}
    public void changeWorkForceFocusInCityAt( Position p, String balance ) {}
    public void changeProductionInCityAt( Position p, String unitType ) {}
    public void performUnitActionAt( Position p ) {}  
    public void addObserver(GameObserver observer) {} 
    public void setTileFocus(Position position) {}
    public void addCityAt(Position p, City c) {}
    public GameEventController getEventController() { return null; }
    public Collection<City> getCities() { return null; }
    public StubGame1() { defineWorld(1); }

    // A simple implementation to draw the map of DeltaCiv
    protected Map<Position,Tile> world; 
    public Tile getTileAt( Position p ) { return world.get(p); }


    /** define the world.
     * @param worldType 1 gives one layout while all other
     * values provide a second world layout.
     */
    protected void defineWorld(int worldType) {
        world = new HashMap<Position,Tile>();
        String[] layout;
        if ( worldType == 1 ) {
            layout = new String[] {
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
                ".....ooooooooo..",
            };
        } else {
            layout = new String[] {
                "...ooo..........",
                ".ooooo.ooohooM..",
                ".ooooo.oohooof..",
                "offfoooo.offoooo",
                "oooooooo...ooooo",
                ".ooMMMoooo......",
                ".....ooooooooo..",
                "...ooMooooo.....",
                "..ohhoooofffoo..",
                "...ofooohhoooo..",
                ".oooooMooo...oo.",
                ".ooMMMoooo..oooo",
                ".ofoofooooohhoo.",
                "..ooooooffoooo..",
                "....ooooooooo...",
                "..ooohhoo.......",
            };      
        }
        String line;
        for ( int r = 0; r < GameConstants.WORLDSIZE; r++ ) {
            line = layout[r];
            for ( int c = 0; c < GameConstants.WORLDSIZE; c++ ) {
                char tileChar = line.charAt(c);
                String type = "error";
                if ( tileChar == '.' ) { type = GameConstants.OCEANS; }
                if ( tileChar == 'o' ) { type = GameConstants.PLAINS; }
                if ( tileChar == 'M' ) { type = GameConstants.MOUNTAINS; }
                if ( tileChar == 'f' ) { type = GameConstants.FOREST; }
                if ( tileChar == 'h' ) { type = GameConstants.HILLS; }
                Position p = new Position(r,c);
                world.put( p, new StubTile(p, type));
            }
        }
    }
}
