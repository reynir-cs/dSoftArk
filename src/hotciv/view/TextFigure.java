package hotciv.view;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

import minidraw.framework.Figure;
import minidraw.standard.AbstractFigure;

/** A figure representing a text.
 * Rather crude at the moment.

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
public class TextFigure extends AbstractFigure {
  private Point position;
  private String text;
  private Font fFont;
  FontMetrics metrics = null;

  public TextFigure(String text, Point position) {
    this.position = position;
    this.text = text;
    fFont = new Font("Serif", Font.BOLD, 20);
  }

  public void setText(String newText) {
    willChange();
    text = newText;
    changed();
  }

  protected void basicMoveBy(int dx, int dy) {
    position.translate(dx, dy);
  }

  public Rectangle displayBox() {
    Dimension extent = textExtent();
    return new Rectangle(position.x, position.y, extent.width, extent.height);
  }

  public void draw(Graphics g) {
    g.setFont(fFont);
    g.setColor( Color.white);
    metrics = g.getFontMetrics(fFont);
    g.drawString(text, position.x, position.y + metrics.getAscent());
  }

  private Dimension textExtent() {
    // metrics may not have been defined yet if no drawing
    // has occurred, however the error is removed upon first
    // redrawing.
    int fWidth;
    int fHeight; 
    if ( metrics == null ) {
      fWidth = 50;
      fHeight = 20;
    } else {
      fWidth = metrics.stringWidth(text);
      fHeight = metrics.getHeight();
    }
    return new Dimension(fWidth, fHeight);
  }
}
