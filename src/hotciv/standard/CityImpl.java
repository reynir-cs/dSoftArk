package hotciv.standard;

import hotciv.framework.*;

public class CityImpl implements City {
    private Player owner;
    private String production;

    public CityImpl(Player owner, String production) {
	this.owner = owner;
	this.production = production;
    }

    public Player getOwner() {
	return owner;
    }

    public int getSize() {
	return 1;
    }

    public String getProduction(){
	return production;
    }

    public String getWorkforceFocus(){return null;}
}
