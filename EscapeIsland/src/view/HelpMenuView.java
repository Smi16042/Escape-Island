package view;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Actor;
import model.*;

/**
 *
 * @author Austin
 */
public class HelpMenuView extends View {

    public boolean doAction(String[] inputs) {

        char c = inputs[0].trim().toUpperCase().charAt(0);
        Player player = new Player();
        Map map = new Map();

        switch (c) {
            case 'C':
                displayHelpControls();
                break;
            case 'S':
                displayHelpStory();
                break;
            case 'H':
                hints();
                break;
            case 'B':
                battleSystem();
                break;
            case 'P':
        {
            try {
                printReport();
            } catch (IOException ex) {
                Logger.getLogger(HelpMenuView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                break;

            case 'Q':
                return true;
            default:

                ErrorView.display(this.getClass().getName(),
                        "Invald menu option.");
        }

        return false;
    }

    public String[] getInputs() {
        String[] inputs = new String[1];

        inputs = new String[1];

        inputs[0] = getInput("***********************************************************"
                + "\n***********************************************************"
                + "\n*                                                         *"
                + "\n* C - Controls                                            *"
                + "\n* S - Story so far                                        *"
                + "\n* H - Hints                                               *"
                + "\n* B - Battle System                                       *"
                + "\n* Q - Quit to Main Menu                                   *"
                + "\n* P - Print report                                        *"
                + "\n*                                                         *"
                + "\n***********************************************************"
                + "\n***********************************************************");

        return inputs;
    }

    private void battleSystem() {
        this.console.println("\n***********************************************************"
                + "\n***********************************************************"
                + "\n*                                                         *"
                + "\n*                 The Battle System                       *"
                + "\n* Attack     = Player Attack + Player Item - Enemy Defense*"
                + "\n* Turn Order = Player Speed + Player Item / Enemy Speed  +*"
                + "\n* Critical   = Player Attack + Player Item + Player Speed *"
                + "\n* + Item Speed / 100.                                     *"
                + "\n* Defend     = Reduce damage by 50%                       *"
                + "\n* Item       = Use an Combat Item                         *"
                + "\n* Run        = Flee the battle.                           *"
                + "\n*                                                         *"
                + "\n***********************************************************"
                + "\n***********************************************************");
        return;
    }

    private void hints() {
        this.console.println("\n***********************************************************"
                + "\n***********************************************************"
                + "\n*                                                         *"
                + "\n*                        Hints                            *"
                + "\n* The Tool Kit can be used in many areas.                 *"
                + "\n* Sometimes to go forward you must go backwards.          *"
                + "\n* Losing Fights? Try exploring the map.                   *"
                + "\n*                                                         *"
                + "\n***********************************************************"
                + "\n***********************************************************");
        return;
    }

    private void displayHelpControls() {
        this.console.println("\n***********************************************************"
                + "\n***********************************************************"
                + "\n*                                                         *"
                + "\n*                        Controls                         *"
                + "\n* I               - Check items in your inventory         *"
                + "\n* U + 'Item name' - Use an item in your inventory         *"
                + "\n* E + 'Item name' - Equip and item to your person         *"
                + "\n* Row + Column    - Navigate to coordinate                *"
                + "\n* A               - Attack                                *"
                + "\n* D               - Defend                                *"
                + "\n* F               - Flee an opponent                      *"
                + "\n* M               - Display map of current area           *"
                + "\n* Q               - Quit to main menu                     *"
                + "\n* S               - Save current game                     *"
                + "\n*                                                         *"
                + "\n*                                                         *"
                + "\n*                                                         *"
                + "\n*                                                         *"
                + "\n*                                                         *"
                + "\n*                                                         *"
                + "\n*                                                         *"
                + "\n*                                                         *"
                + "\n*                                                         *"
                + "\n*                                                         *"
                + "\n*                                                         *"
                + "\n*                                                         *"
                + "\n*                                                         *"
                + "\n*                                                         *"
                + "\n*                                                         *"
                + "\n*                                                         *"
                + "\n*                                                         *"
                + "\n*                                                         *"
                + "\n***********************************************************"
                + "\n***********************************************************");
        return;
    }

    private void displayHelpStory() {
        this.console.println("\n***********************************************************"
                + "\n***********************************************************"
                + "\n*                                                         *"
                + "\n*                        Story                            *"
                + "\n*      You've woken up on what appears to be a very nice, *"
                + "\n*  paradisaical island. You're on the beach, there isn't  *"
                + "\n*  much in your view, it's blocked by thick forest.       *"
                + "\n*      You should start *"
                + "\n*                                                         *"
                + "\n*                                                         *"
                + "\n*                                                         *"
                + "\n*                                                         *"
                + "\n*                                                         *"
                + "\n*                                                         *"
                + "\n*                                                         *"
                + "\n*                                                         *"
                + "\n*                                                         *"
                + "\n*                                                         *"
                + "\n*                                                         *"
                + "\n*                                                         *"
                + "\n*                                                         *"
                + "\n*                                                         *"
                + "\n***********************************************************"
                + "\n***********************************************************");
        return;
    }

 

    private void printReport() throws IOException {
        System.out.println("Please enter the file path");
        
        FileWriter listFile = null;
        
        try {
            String playerInput = this.keyboard.readLine();
            String newLine = System.getProperty("line.seperator");
            listFile = new FileWriter(playerInput);
           
            listFile.write("\tMonster List" 
                    + System.lineSeparator()
                    + "Monsters"
                    + System.lineSeparator());
            
            
            for (Actor monster: Actor.values() ){

                listFile.write(monster.getActorName() + " "
                        + monster.getActorDescription() + " "
                        + monster.getActorHitPoints() + " "
                        + monster.getActorAttack() + " "
                        + monster.getActorDefense() + " "
                        + monster.getActorSpeed()
                        + System.lineSeparator());
                
                       
                        }
            
            
        } catch (IOException ex) {
            ErrorView.display(this.getClass().getName(),
                    "Error reading input " + ex.getMessage());
        } finally {
            if(listFile != null) {
                listFile.close();
                System.out.println("Success!");
            }
        } 
    } 
        
        
        
    }

