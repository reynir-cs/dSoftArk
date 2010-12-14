package hotciv.view;

import hotciv.framework.*;

import java.awt.*;
import java.util.*;
import java.awt.event.*;

import minidraw.framework.*;
import minidraw.standard.*;
import minidraw.standard.handlers.*;

public class EndTurnTool extends NullTool {
    private Game game;
    private DrawingEditor editor;

    public EndTurnTool(DrawingEditor editor, Game game) {
        this.editor = editor;
        this.game = game;
    }

    @Override public void mouseDown(MouseEvent e, int x, int y) {
        Figure shield = editor.drawing().findFigure(GfxConstants.TURN_SHIELD_X, GfxConstants.TURN_SHIELD_Y);
        if (shield == null)
            return;
        if (shield.displayBox().contains(x,y))
            game.endOfTurn();
    }
}
