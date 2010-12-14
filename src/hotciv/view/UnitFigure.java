package hotciv.view;

import hotciv.framework.*;
import hotciv.view.GfxConstants;

import java.awt.*;

import minidraw.standard.ImageFigure;

/** UnitFigure is a MiniDraw figure that draws the graphics associated
 * with the proper images for HotCiv, and overlays some graphics that
 * tells ownership and move count left for the unit. The upper circle
 * is the owner color, the lower circle marks green for moves left
 * while red is for no more moves left.  
 *
 * dSoftArk Helper class.
<#if type == "code">

<#include "/data/author.txt">
</#if>
*/

public class UnitFigure extends ImageFigure {
  protected Unit associatedUnit;
  
  public UnitFigure(String name, Point origin, Unit unit) {
    super(name, origin);
    associatedUnit = unit;
  }

  @Override
  public void draw(Graphics g) {
    g.drawImage(fImage, fDisplayBox.x, 
        fDisplayBox.y - GfxConstants.UNIT_OFFSET_Y, 
        fDisplayBox.width, fDisplayBox.height, null);

    // Draw the owner circle
    Color color = 
      GfxConstants.getColorForPlayer(associatedUnit.getOwner());
    g.setColor(color);
    g.fillOval(fDisplayBox.x, fDisplayBox.y, 8, 6);
    g.setColor(Color.black);
    g.drawOval(fDisplayBox.x, fDisplayBox.y, 8, 6);
    
    // Draw the 'movable' box
    g.setColor( associatedUnit.getMoveCount() > 0 ? 
        Color.green : Color.red );
    g.fillOval(fDisplayBox.x, fDisplayBox.y+7, 8, 6);
    g.setColor(Color.black);
    g.drawOval(fDisplayBox.x, fDisplayBox.y+7, 8, 6);
  }
  
  
}
