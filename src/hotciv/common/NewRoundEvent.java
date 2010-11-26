package hotciv.common;

import hotciv.framework.GameEvent;

public class NewRoundEvent implements GameEvent {
    public final int round;

    public NewRoundEvent(int round) {
        this.round = round;
    }
}
