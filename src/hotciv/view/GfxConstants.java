package hotciv.view;

import hotciv.framework.*;

/** Constants to be accessible by all graphics handling abstractions and
 * coordination mappings.

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

public class GfxConstants {
  // The size of the tile images used, in pixels
  public final static int TILESIZE = 30;
  // Offset the world map by these x and y values in pixels
  public final static int MAP_OFFSET_X = 19;
  public final static int MAP_OFFSET_Y = 15;
  // When drawing the population size number on top of
  // the city graphics, offset this x,y in pixels from
  // top left corner of tile
  public final static int CITY_SIZE_OFFSET_X = 8;
  public final static int CITY_SIZE_OFFSET_Y = 24;
  // When drawing units, this Y offset is subtracted to position their
  // 'feet' on the tile
  public final static int UNIT_OFFSET_Y = 0;
  
  // === Constants that define positions for props on the gfx display
  public final static int TURN_SHIELD_X = 559;
  public final static int TURN_SHIELD_Y = 64;
  public final static int AGE_TEXT_X = 535;
  public final static int AGE_TEXT_Y = 23;
  
  public final static int UNIT_SHIELD_X = 594;
  public final static int UNIT_SHIELD_Y = 188;
  public final static int UNIT_COUNT_X = 598;
  public final static int UNIT_COUNT_Y = 256;

  public static final int CITY_SHIELD_X = 595;
  public static final int CITY_SHIELD_Y = 342;
  public static final int WORKFORCEFOCUS_X = 590;
  public static final int WORKFORCEFOCUS_Y = 444;
  public static final int CITY_PRODUCTION_X = 595;
  public static final int CITY_PRODUCTION_Y = 400;

  // === Names of GIF files loaded by image manager
  public static final String RED_SHIELD = "redshield";
  public static final String BLUE_SHIELD = "blueshield";
  public static final String NOTHING = "black";
  
  /** return the x pixel position on the graphical display
   * for a tile's column position
   * @param column the position of the tile
   * @return the pixel x coordinate corresponding to column
   */
  public static int getXFromColumn( int column ) {
    return column * TILESIZE + MAP_OFFSET_X;
  }
  /** return the y pixel position on the graphical display
   * for a tile's row position
   * @param row the position of the tile
   * @return the pixel y coordinate corresponding to row
   */
  public static int getYFromRow( int row ) {
    return row * TILESIZE + MAP_OFFSET_Y;
  }
  /** get a graphical color based upon game player's color
   * 
   */
  public static java.awt.Color getColorForPlayer(Player p) {
    switch ( p ) {
    case RED : return java.awt.Color.RED;
    case BLUE : return java.awt.Color.CYAN;
    case YELLOW : return java.awt.Color.YELLOW;
    case GREEN : return java.awt.Color.GREEN;
    }
    return java.awt.Color.WHITE;
  }
  /** return a Game Position for a given (x,y) coordinate
   * on a the MapView used to draw the tiles in MiniDraw
   * @param x the x coordinate
   * @param y the y coordinate
   * @return the position of the tile under (x,y) on the
   * graphical view.
   */
  public static Position getPositionFromXY( int x, int y ) {
    return new Position( (y - MAP_OFFSET_Y) / TILESIZE, 
        (x - MAP_OFFSET_X) / TILESIZE );
  } 
}
