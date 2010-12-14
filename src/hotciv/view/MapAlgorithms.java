package hotciv.view;

import hotciv.framework.*;

/** A library of algorithms used to draw a FreeCiv like map, that
 * is, a map that draws coastlines properly for the oceans to avoid
 * the rectangular look of using ordinary tiles.

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
class MapAlgorithms {
  /** return a string defining a binary number in range 0000..1111
   *  that encodes the coast line properties for a tile ata given
   *  position.  Precondition: the tile at position p is ocean.
   *  @return a 4 digit binary number as a string. For each position
   *  in the number an '1' means "coast line" and "0" means "ocean".
   *  The first binary number is the northern edge, the second the
   *  eastern, the third the southern, and the forth the western.  Ex:
   *  "0000" is returned if the ocean tile at position 'p' in 'game'
   *  has no coast lines to N, E, S, and W. "0110" means ocean tile
   *  'p' as coast line on the E and S tile.
   */
  public static String getCoastlineCoding(Game game, Position center) {
    char[] coding = {'0','0','0','0' };

    int row = center.getRow(), col = center.getColumn();
    Position p; 

    int offsetRow[] = { -1,0,+1,0 };
    int offsetCol[] = { 0,+1,0,-1 };

    // iterate over the four compas directions
    //   for each find the proper tile p and
    //   check if there is a coastline
    for ( int i = 0; i < 4; i++ ) {
      p = new Position( row+offsetRow[i], col+offsetCol[i]);
      if ( p.getRow() >= 0 && p.getRow() < GameConstants.WORLDSIZE &&
           p.getColumn() >= 0 && p.getColumn() < GameConstants.WORLDSIZE &&
           game.getTileAt(p).getTypeString() != GameConstants.OCEANS ) {
        coding[i] = '1';
      }
    }
    String s = new String(coding);
    return s;
  }
}
