package view;

import control.MapControl;
import model.Map;
import escapeIsland.EscapeIsland;
import exceptions.MapControlException;
import java.io.IOException;
import model.Player;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Actor;
import model.Item;

/**
 *
 * @author Austin
 */
import model.Location;

public class MapView extends View {

    public MapView() {
    }

    public boolean doAction(String[] inputs) {

        Player player = EscapeIsland.getCurrentPlayer();
        Map map = EscapeIsland.getCurrentGame().getMap();

        while (true) {

            displayMap(map);
            String mapInput = null;
            try {
                mapInput = this.keyboard.readLine();
            } catch (IOException ex) {
                Logger.getLogger(MapView.class.getName()).log(Level.SEVERE, null, ex);
            }
            char c = mapInput.trim().toUpperCase().charAt(0);

            switch (c) {
                case 'W':
                    this.console.println("moveNorth");
                    moveNorth(player, map);
                    break;
                case 'A':
                    this.console.println("moveWest");
                    moveWest(player, map);
                    break;
                case 'S':
                    this.console.println("moveSouth");
                    moveSouth(player, map);
                    break;
                case 'D':
                    this.console.println("moveEast");
                    moveEast(player, map);
                    break;
                case 'V':
                    viewMap(map);
                    break;
                case 'E':
                    exploreScene();
                    break;
                case 'Q':
                    return true;
                default:
                    this.console.println("Invalid Option.");

            }
            map.getLocations()[player.getActor().getActorcoordinates().x][player.getActor().getActorcoordinates().y].setVisited(true);
        }

    }

    public void displayMap(Map map) {

        Location[][] locations = map.getLocations();

        this.console.println("*** displayMap called ***");

        this.console.println("     Mysterious Island");

        this.console.print("  ");
        for (int i = 0; i < map.getColumnCount(); i++) {
            this.console.print((i + 1) + "   ");
        }

        this.console.println("\n -------------------------------------------");

        for (int i = 0; i < map.getRowCount(); i++) {
            if (i < 9) {
                this.console.print((i + 1) + " ");
            } else {
                this.console.print(i + 1);
            }

            for (int j = 0; j < map.getColumnCount(); j++) {
                if (locations[i][j].isVisited()) {

                    if (i == EscapeIsland.getCurrentPlayer().getActor().getActorcoordinates().x
                            && j == EscapeIsland.getCurrentPlayer().getActor().getActorcoordinates().y) {
                        this.console.print("|[H]");
                    } else {
                        this.console.print("| " + locations[i][j].getBackgroundType().getPrintValue() + " ");
                    }
                } else {
                    this.console.print("| ? ");
                }
            }
            this.console.println("|\n -----------------------------------------");
            
        }
        
                this.console.println("***********************************************************"
                    + "\n***********************************************************"
                    + "\n*                                                         *"
                    + "\n* W - Move North                                          *"
                    + "\n* A - Move West                                           *"
                    + "\n* S - Move South                                          *"
                    + "\n* D - Move East                                           *"
                    + "\n* V - View Map                                            *"
                    + "\n* E - Explore Scene                                       *"
                    + "\n* Q - Quit to Main Menu                                   *"
                    + "\n*                                                         *"
                    + "\n***********************************************************"
                    + "\n***********************************************************");    
    }

    public String[] getInputs() {
        {

            String[] inputs = new String[1];
            inputs[0] = getInput("***********************************************************"
                    + "\n***********************************************************"
                    + "\n*                                                         *"
                    + "\n* W - Move North                                          *"
                    + "\n* A - Move West                                           *"
                    + "\n* S - Move South                                          *"
                    + "\n* D - Move East                                           *"
                    + "\n* V - View Map                                            *"
                    + "\n* E - Explore Scene                                       *"
                    + "\n* Q - Quit to Main Menu                                   *"
                    + "\n*                                                         *"
                    + "\n***********************************************************"
                    + "\n***********************************************************");

            return inputs;
        }
    }

    private void moveNorth(Player player, Map map) {
        Actor hero = player.getActor();
        int newRow = hero.getActorcoordinates().x - 1;
        int newColumn = hero.getActorcoordinates().y;

        map.getLocations()[newRow][newColumn].setVisited(true);
        if (!map.getLocations()[newRow][newColumn].isBlocked()) {

            try {
                MapControl.moveActor(hero, newRow, newColumn);
            } catch (MapControlException ex) {
                this.console.println(ex.getMessage());
            }

        } 
        else if(!(map.getLocations()[newRow][newColumn].getItemRequired() == null)){
            if (player.getActor().getActorItems().contains(Item.Key) && map.getLocations()[newRow][newColumn].getItemRequired().equals(Item.Key)) {
               map.getLocations()[newRow][newColumn].setBlocked(false);
                this.console.println("your key unlocked this location");
            } 
        
        }
        else {
            this.console.println("The tile is blocked");
        }
    }

    private void moveEast(Player player, Map map) {
        Actor hero = player.getActor();
        int newRow = hero.getActorcoordinates().x;
        int newColumn = hero.getActorcoordinates().y + 1;

        map.getLocations()[newRow][newColumn].setVisited(true);
        if (!map.getLocations()[newRow][newColumn].isBlocked()) {

            try {
                MapControl.moveActor(hero, newRow, newColumn);
            } catch (MapControlException ex) {
                this.console.println(ex.getMessage());
            }

        } else {
            this.console.println("The tile is blocked");
        }
    }

    private void moveSouth(Player player, Map map) {
        Actor hero = player.getActor();
        int newRow = hero.getActorcoordinates().x + 1;
        int newColumn = hero.getActorcoordinates().y;
        map.getLocations()[newRow][newColumn].setVisited(true);
        if (!map.getLocations()[newRow][newColumn].isBlocked()) {

            try {
                MapControl.moveActor(hero, newRow, newColumn);
            } catch (MapControlException ex) {
                this.console.println(ex.getMessage());
            }

        } else {
            this.console.println("The tile is blocked");
        }
    }

    

    private void moveWest(Player player, Map map) {
        Actor hero = player.getActor();
        int newRow = hero.getActorcoordinates().x;
        int newColumn = hero.getActorcoordinates().y - 1;
        map.getLocations()[newRow][newColumn].setVisited(true);
        if (!map.getLocations()[newRow][newColumn].isBlocked()) {

            try {
                MapControl.moveActor(hero, newRow, newColumn);
            } catch (MapControlException ex) {
                this.console.println(ex.getMessage());
            }

        } else {
            this.console.println("The tile is blocked");
        }

    }

    public void viewMap(Map map) {
        MapView mapView = new MapView();
        mapView.display();
    }

    private void exploreScene() {
        InteractWithEnviromentView interactWithEnvironment = new InteractWithEnviromentView();
        interactWithEnvironment.display();
    }

    public void openMap(Map map, Player player) {

        for (int mapZ = 0; mapZ < map.getRowCount(); mapZ++) {
            for (int mapX = 0; mapX < map.getColumnCount(); mapX++) {
                if (map.getLocations()[mapZ][mapX].getColumn() == player.getActor().getActorcoordinates().getX()
                        && map.getLocations()[mapZ][mapX].getRow() == player.getActor().getActorcoordinates().getY()) {
                    map.getLocations()[mapZ][mapX].setVisited(true);
                }
            }
        }

        for (int mapR = 0; mapR < map.getRowCount(); mapR++) {
            for (int mapC = 0; mapC < map.getColumnCount(); mapC++) {
                if (player.getActor().getActorcoordinates().x == mapR && player.getActor().getActorcoordinates().y == mapC) {
                    this.console.print("H");

                }
                this.console.print(map.physicalMapView[mapR][mapC]);
            }
            this.console.print("\n");
        }
    }

}
