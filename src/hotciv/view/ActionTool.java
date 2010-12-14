package hotciv.view;

import hotciv.framework.*;

import java.awt.*;
import java.util.*;
import java.awt.event.*;

import minidraw.framework.*;
import minidraw.standard.*;
import minidraw.standard.handlers.*;

public class ActionTool extends NullTool {
    private Game game;
    private DrawingEditor editor;

    public ActionTool(DrawingEditor editor, Game game) {
        this.editor = editor;
        this.game = game;
    }

    @Override public void mouseDown(MouseEvent e, int x, int y) {
        Position pos = coordinateToPosition(x,y);
        if (!onMap(x, y))
            return;
        if (game.getUnitAt(pos) == null)
            return;
        if (!e.isShiftDown())
            return;
        game.performUnitActionAt(pos);
    }

    private boolean onMap(int x, int y) {
        Position pos = coordinateToPosition(x, y);
        if (pos.getRow() < 0 || pos.getRow() > GameConstants.WORLDSIZE - 1
            || pos.getColumn() < 0 || pos.getColumn() > GameConstants.WORLDSIZE - 1) {
            return false;
        }
        return true;
    }

    private Position coordinateToPosition(int x, int y) {
        return new Position((y - GfxConstants.MAP_OFFSET_Y) / GfxConstants.TILESIZE,
                            (x - GfxConstants.MAP_OFFSET_X) / GfxConstants.TILESIZE);
    }
}
