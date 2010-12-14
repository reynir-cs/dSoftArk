package hotciv.view;

import java.awt.*;

import minidraw.standard.ImageFigure;

import hotciv.framework.*;

public class CityFigure extends ImageFigure {
  private City city;
  private Point position;

  public CityFigure(City c, Point p) {
    super("city", p); 
    position = p;
    city = c;
  }
  public void draw(Graphics g) {
    // draw background color
    g.setColor(GfxConstants.getColorForPlayer(city.getOwner()));
    g.fillRect( position.x+1, position.y+1, 
        GfxConstants.TILESIZE-2, 
        GfxConstants.TILESIZE-2 );

    super.draw(g);

    g.setColor(Color.white);

    Font font = new Font("Helvetica", Font.BOLD, 24);
    g.setFont(font);
    
    String size = ""+city.getSize();
    g.drawString(size, 
        position.x + GfxConstants.CITY_SIZE_OFFSET_X, 
        position.y + GfxConstants.CITY_SIZE_OFFSET_Y);
  }
}
