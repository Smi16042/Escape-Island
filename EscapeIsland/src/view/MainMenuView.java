package view;

import control.GameControl;
import escapeIsland.EscapeIsland;
import java.util.Scanner;
import exceptions.GameControlException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Austin
 */
public class MainMenuView extends View {

   

    public String[] getInputs() {
        String[] inputs = new String[1];

        this.console.println("***********************************************************"
                + "\n***********************************************************"
                + "\n*                                                         *"
                + "\n* N - New Game                                            *"
                + "\n* L - Load Game                                           *"
                + "\n* S - Save Game                                           *"
                + "\n* H - Help                                                *"
                + "\n* Q - Quit                                                *"
                + "\n*                                                         *"
                + "\n***********************************************************"
                + "\n***********************************************************");

        String[] menuItem = new String[1];
        try {
            menuItem[0] = this.keyboard.readLine();
        } catch (IOException ex) {
            Logger.getLogger(MainMenuView.class.getName()).log(Level.SEVERE, null, ex);
        }

        return menuItem;
    }

    @Override
    public boolean doAction(String[] inputs) {

        char c = inputs[0].trim().toUpperCase().charAt(0);
        switch (c) {
            case 'N':
                startNewGame();
                break;
            case 'L':
        {
            try {
                loadGame();
            } catch (IOException ex) {
                Logger.getLogger(MainMenuView.class.getName()).log(Level.SEVERE, null, ex);
            } catch (GameControlException ex) {
                Logger.getLogger(MainMenuView.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MainMenuView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                break;
            case 'S':
                SaveGameView sg = new SaveGameView();
                sg.display();
                break;
            case 'H':
                helpMenu();
                break;
            case 'Q':
                return true;
            default:
                this.console.println("Invalid Option.");
        }

        return false;

    }

    private void startNewGame() {
        
        
        try {
           GameControl.createNewGame(EscapeIsland.getCurrentPlayer());
            
            GameMenuView gameMenuView = new GameMenuView();
            gameMenuView.display();
            

        } catch (GameControlException ex) {
            ErrorView.display(this.getClass().getName(),
                    "Error reading input " + ex.getMessage());
        }
    }

    private void loadGame() throws IOException, GameControlException, FileNotFoundException, ClassNotFoundException {
        System.out.println("enter file name");
        GameControl.loadGame(this.keyboard.readLine());
        System.out.println("game loaded");
        GameMenuView mv = new GameMenuView();
        mv.display();
    }

    private void helpMenu() {
        HelpMenuView help = new HelpMenuView();
        help.display();

    }

}
