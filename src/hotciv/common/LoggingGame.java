package hotciv.common;

import java.util.Collection;
import java.io.PrintStream;
import hotciv.framework.*;


public class LoggingGame implements Game {
    private Game game;
    private PrintStream out;

    public LoggingGame(Game game, PrintStream out) {
        this.game = game;
        this.out = out;
    }
  
    public Tile getTileAt( Position p ) {
        return game.getTileAt(p);
    }

    public Unit getUnitAt( Position p ) {
        return game.getUnitAt(p);
    }
  
    public City getCityAt( Position p ) {
        return game.getCityAt(p);
    }

    public Player getPlayerInTurn() {
        return game.getPlayerInTurn();
    }
    
    public Player getWinner() {
        return game.getWinner();
    }

  
    public int getAge() {
        return game.getAge();
    }
    
  
    public boolean moveUnit( Position from, Position to ) {
        out.printf("%s moves %s from %s to %s.%n",
                getPlayerInTurn(), getUnitAt(from).getTypeString(), from, to);
        return game.moveUnit(from, to);
    }
  
    public void endOfTurn() {
        out.printf("%s ends turn.%n",
                getPlayerInTurn());
        game.endOfTurn();
    }
  
    public void changeWorkForceFocusInCityAt( Position p, String balance ) {
        out.printf("%s changes work force focus in city at %s to %s.%n",
                getPlayerInTurn(), p, balance);
        game.changeWorkForceFocusInCityAt(p, balance);
    }
  
    public void changeProductionInCityAt( Position p, String unitType ) {
        out.printf("%s changes production in city at %s to %s.%n",
                getPlayerInTurn(), p, unitType);
        game.changeProductionInCityAt(p, unitType);
    }
  
    public void performUnitActionAt( Position p ) {
        out.printf("%s performs unit action at %s on a(n) %s.%n",
                getPlayerInTurn(), p, getUnitAt(p).getTypeString());
        game.performUnitActionAt(p);
    }

    public Collection<City> getCities() {
        return game.getCities();
    }

    public void addCityAt( Position p, City c ) {
        game.addCityAt(p, c);
    }

    public GameEventController getEventController() {
        return game.getEventController();
    }
    
    public void addObserver(GameObserver observer){
    }
}
