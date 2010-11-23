package hotciv.common;

import hotciv.framework.*;

public class UnitImpl implements Unit {
    private final String type;
    private final Player owner;
    private final int lastMoved;
    private final int defStr;
    private final int atkStr;
    private final boolean isFortified;

    public UnitImpl(String type, Player owner, int lastMoved, 
            boolean isFortified, int defStr, int atkStr) {
	this.type = type;
	this.owner = owner;
	this.lastMoved = lastMoved;
        this.isFortified = isFortified;
        this.defStr = defStr;
        this.atkStr = atkStr;
    }

    public static UnitImpl create(String type, Player owner, int lastMoved) {
        int defStr, atkStr;

        if (type.equals(GameConstants.ARCHER)) {
            defStr = 3;
            atkStr = 2;
        } else if (type.equals(GameConstants.LEGION)) {
            defStr = 2;
            atkStr = 4;
        } else if (type.equals(GameConstants.SETTLER)) {
            defStr = 3;
            atkStr = 0;
        } else {
            defStr = 0;
            atkStr = 0;
        }

        return new UnitImpl(type, owner, lastMoved, false, defStr, atkStr);
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

    public Unit withLastMoved(int moved) {
        return new UnitImpl(type, owner, moved, isFortified, defStr, atkStr);
    }

    public Unit withFortify(boolean fortify, int defStr) {
        return new UnitImpl(type, owner, lastMoved, fortify, defStr, atkStr);
    }
}
