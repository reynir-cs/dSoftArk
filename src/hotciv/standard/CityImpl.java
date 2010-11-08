package hotciv.standard;

import hotciv.framework.*;

public class CityImpl implements City {
    private Player owner;

    public CityImpl(Player owner) {
	this.owner = owner;
    }

    public Player getOwner() {
	return owner;
    }

    public int getSize() {
	return 1;
    }

    public String getProduction(){return null;}
    public String getWorkforceFocus(){return null;}
}
