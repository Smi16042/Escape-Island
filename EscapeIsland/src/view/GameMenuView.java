package view;

import model.Player;
import java.util.Scanner;
import model.Map;


/**
 *
 * @author Austin
 */
public class GameMenuView {
 
    public void displayGameMenuView(Player player, Map map){
    String[] inputs = new String[0];
              
        boolean endOfView = false;
        
        do {           
                if (inputs[0].trim().length() < 1){
                    System.out.println("Invald Option.");
                    continue;
                    }
                
                endOfView = doAction(inputs, player, map);
                
        } while (endOfView != true);
        
    }
    
    private String[] getInputs() {
      
        String[] inputs = new String[1];

            System.out.println("***********************************************************"
                           + "\n***********************************************************"
                           + "\n*                                                         *"
                           + "\n* W - Move North                                          *"
                           + "\n* A - Move West                                           *"
                           + "\n* S - Move South                                          *"
                           + "\n* D - Move East                                           *"
                           + "\n* M - Map                                                 *"
                           + "\n* I - Inventory                                           *"
                           + "\n* E - Interact With Enviroment                            *"
                           + "\n* Q - Quit to Main Menu                                   *"
                           + "\n*                                                         *"
                           + "\n***********************************************************"
                           + "\n***********************************************************");

                    String[] menuItem = new String[1];
                    Scanner sc = new Scanner(System.in);
                    menuItem[0] = sc.nextLine();  

                return menuItem;
            }
 
    private boolean doAction(String[] inputs, Player player, Map map) {

        char c = inputs[0].trim().toUpperCase().charAt(0);
       
        switch(c){
            case 'W':
                moveNorth(player);
                break;
            case 'A':
                moveEast(player);
                break;
            case 'S':
                moveSouth(player);
                break;
            case 'D':
                moveWest(player);
                break;
            case 'M':
                openMap(map);
                break;
            case 'I':
                openInventory();
                break;
            case 'E':
                interactWithEnviroment();
                break;
            case 'Q':
                return true;
            default:
                System.out.println("Invalid Option.");
                
        }
        
        return false;    
    }

    private void moveNorth(Player player) {
        int newPosition = player.getPositionY();
        newPosition++;
        player.setPositionY(newPosition);
        System.out.println("Move North One Tile");
        
    }
        
    private void moveEast(Player player){
        int newPosition = player.getPositionX();
        newPosition++;
        player.setPositionX(newPosition);
        System.out.println("Move East One Tile");
        
    }

    private void moveSouth(Player player) {
        int newPosition = player.getPositionY();
        newPosition--;
        player.setPositionY(newPosition);
        System.out.println("Move South One Tile");
        
    }

    private void moveWest(Player player) {
        int newPosition = player.getPositionX();
        newPosition--;
        player.setPositionX(newPosition);
        System.out.println("Move West One Tile");
        
    }

    private void openMap(Map map) {

    }

    private void openInventory() {
        System.out.println("Collins Inventory");
        
    }

    private void interactWithEnviroment() {
    }
}    