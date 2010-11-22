package hotciv.standard;

import hotciv.framework.*;

public class UnitImpl implements Unit {
    private String type;
    private Player owner;
    private int lastMoved;
    private int defStr;
    private int atkStr;
    private boolean isFortified;

    public UnitImpl(String type, Player owner, int lastMoved) {
        this(type, owner, lastMoved, false);
    }

    public UnitImpl(String type, Player owner, int lastMoved, 
            boolean isFortified) {
        this(type, owner, lastMoved, isFortified, 0, 0);

        if (type.equals(GameConstants.ARCHER)) {
            defStr = 3;
            atkStr = 2;
        } else if (type.equals(GameConstants.LEGION)) {
            defStr = 2;
            atkStr = 4;
        } else if (type.equals(GameConstants.SETTLER)) {
            defStr = 3;
        }
    }

    public UnitImpl(String type, Player owner, int lastMoved, 
            boolean isFortified, int defStr, int atkStr) {
	this.type = type;
	this.owner = owner;
	this.lastMoved = lastMoved;
        this.isFortified = isFortified;
        this.defStr = defStr;
        this.atkStr = atkStr;
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
    public int getAttackingStrength() {
        return atkStr;
    }
    
    public int getLastMoved() {
	return lastMoved;
    }

    public boolean isFortified() {
        return isFortified;
    }
}
