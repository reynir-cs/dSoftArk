package hotciv.standard;

import hotciv.framework.*;

public class UnitImpl implements Unit {
    private String type;
    private Player owner;
    private int lastMoved;

    public UnitImpl(String type, Player owner, int lastMoved){
	this.type = type;
	this.owner = owner;
	this.lastMoved = lastMoved;
    }

    public String getTypeString() {
	return type;
    }
    
    public Player getOwner() {
	return owner;
    }
    
    public int getMoveCount() { return 0; }
    public int getDefensiveStrength() { return 0; }
    public int getAttackingStrength() { return 0; }
    
    public int getLastMoved() {
	return lastMoved;
    }
}
