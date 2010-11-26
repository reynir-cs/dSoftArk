package hotciv.common;

import hotciv.framework.*;

public class AttackerWonEvent implements GameEvent {
    public final Player attacker;

    public AttackerWonEvent(Player attacker) {
        this.attacker = attacker;
    }
//    public final Unit attacker;
//    public final Unit defender;
//    public final Position defenderPos;
//    public final Position attackerPos;

//    public AttackerWonEvent(Unit attacker, Unit defender, Position defenderPos,
//            Position attackerPos) {
//        this.attacker = attacker;
//        this.defender = defender;
//        this.defenderPos = defenderPos;
//        this.attackerPos = attackerPos;
//    }
}
