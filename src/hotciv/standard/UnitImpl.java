package hotciv.standard;

import hotciv.framework.*;

public class UnitImpl implements Unit {
    private static String type;
    private static Player owner;
    private static int lastMoved;
    private static int defStr;
    private static boolean isFortified;

    public UnitImpl(String type, Player owner, int lastMoved) {
        this(type, owner, lastMoved, false);
    }

    public UnitImpl(String type, Player owner, int lastMoved, 
                    boolean isFortified) {
        this(type, owner, lastMoved, isFortified, 3);
    }

    public UnitImpl(String type, Player owner, int lastMoved, 
            boolean isFortified, int defStr){
	this.type = type;
	this.owner = owner;
	this.lastMoved = lastMoved;
        this.isFortified = isFortified;
        this.defStr = defStr;
    }

    public String getTypeString() {
	return type;
    }
    
    public Player getOwner() {
	return owner;
    }
    
    public int getMoveCount() { return 0; }
    public int getDefensiveStrength() {
        return defStr;
    }
    public int getAttackingStrength() { return 0; }
    
    public int getLastMoved() {
	return lastMoved;
    }

    public boolean isFortified() {
        return isFortified;
    }
}
