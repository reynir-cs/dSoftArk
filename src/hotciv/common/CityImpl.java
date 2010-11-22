package hotciv.common;

import hotciv.framework.*;

public class CityImpl implements City {
    private final Player owner;
    private final String production;
    private final int productionAmount;

    public CityImpl(Player owner) {
	this(owner, GameConstants.ARCHER, 0);
    }

    public CityImpl(Player owner, String production, int productionAmount) {
	this.owner = owner;
	this.production = production;
	this.productionAmount = productionAmount;
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

    public int getProductionAmount() {
	return productionAmount;
    }
}
