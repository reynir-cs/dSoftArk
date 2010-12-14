package hotciv.visual;

import minidraw.standard.*;
import minidraw.framework.*;

import java.awt.*;
import javax.swing.*;

import hotciv.framework.*;
import hotciv.view.*;
import hotciv.stub.*;

/** Show a basic world.
 * 
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
public class ShowWorld {
  
  public static void main(String[] args) {

    System.out.println("===========");
    System.out.println("Hello world");
    System.out.println("===========");

    Game game = new StubGame1();

    DrawingEditor editor = 
      new MiniDrawApplication( "Paint the HotCiv world map...",  
                               new HotCivFactory(game) );
    editor.open();
    
    editor.setTool( new NullTool() );

  }
}

class HotCivFactory implements Factory {
  private Game game;
  public HotCivFactory(Game g) { game = g; }

  public DrawingView createDrawingView( DrawingEditor editor ) {
    DrawingView view = 
      new MapView(editor, game);
    return view;
  }

  public Drawing createDrawing( DrawingEditor editor ) {
    return new StandardDrawing();
  }

  public JTextField createStatusField( DrawingEditor editor ) {
    return null;
  }
}


