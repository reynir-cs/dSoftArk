package hotciv.view;

import minidraw.framework.*;
import minidraw.standard.*;
import java.awt.*;

import hotciv.framework.*;

/** MapView: A MiniDraw DrawingView specializing
    in drawing the background for a HotCiv Game
    world including the matrix of tiles.

    Note: this class assumes that the type
    strings used for tiles are identical to
    the names of the GIF files loaded by MiniDraw.
    An exception is the ocean tiles that must
    be named with a binary encoding stating the
    coast line properties.

    Responsibilities:
    1) Draw fixed graphics
    2) Draw the world, consisting of a matrix of terrain tiles.

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

public class MapView 
  extends StdViewWithBackground {
  
  Game game;
  
  public MapView( DrawingEditor editor, Game game ) {
    super(editor, "hotciv-background" );
    this.game = game;
  }

  /** Draw the background graphics. This includes of course the
   * 'frame' and a few other fixed graphics stored in a gif file, but
   * beyond this we have to draw the world of tiles. For most of the
   * tiles this is bascially just drawing the terrain graphics but for
   * oceans we have to be a bit more clever to draw coast lines that
   * appear nice.
   */
  public void drawBackground(Graphics g) {
    // draw the background graphics from the superclass
    super.drawBackground(g);

    ImageManager im = ImageManager.getSingleton();
    Image img;
    Position p;
    
    // draw the map as a matrix of tiles with cities on top
    for ( int r = 0; r < GameConstants.WORLDSIZE; r++ ) {
      for ( int c = 0; c < GameConstants.WORLDSIZE; c++ ) {
        p = new Position(r,c);
        int xpos = GfxConstants.getXFromColumn(c);
        int ypos = GfxConstants.getYFromRow(r);
        // Draw proper terrain
        Tile t = game.getTileAt(p);
        String image_name = t.getTypeString();
        // special handling of ocean coasts
        if ( image_name == GameConstants.OCEANS ) {
          image_name = image_name + 
            MapAlgorithms.getCoastlineCoding(game, p );
        }
        img = im.getImage( image_name );
        g.drawImage( img, xpos, ypos, null );
      }
    }
  }
}
