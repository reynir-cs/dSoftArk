package hotciv.standard;

import hotciv.framework.*;

public class TileImpl implements Tile {
    private String type;
    private Position pos;

    public TileImpl(Position pos, String type) {
	this.pos = pos;
	this.type = type;
    }

    public Position getPosition() {
	return pos;
    }

    public String getTypeString() {
	return type;
    }
}
