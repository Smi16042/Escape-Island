/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.GameControl;
import escapeIsland.EscapeIsland;
import exceptions.GameControlException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Game;

/**
 *
 * @author collin
 */
public class SaveGameView extends View {

    @Override
    public String[] getInputs() {
        String[] inputs = new String[1];

        System.out.println("***********************************************************"
                + "\n***********************************************************"
                + "\n*                                                         *"
                + "\n* S - Save Current Game                                   *"
                + "\n* Q - Quit                                                *"
                + "\n*                                                         *"
                + "\n***********************************************************"
                + "\n***********************************************************");

        String[] menuItem = new String[1];
        Scanner sc = new Scanner(System.in);
        menuItem[0] = sc.nextLine();

        return menuItem;}

    @Override
    public boolean doAction(String[] inputs) {

        char c = inputs[0].trim().toUpperCase().charAt(0);
        switch (c) {
            case 'S':
        {
            try {
                saveGame();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            } catch (GameControlException ex) {
                System.out.println(ex.getMessage());
            }
        }
                break;
            case 'Q':
                return true;
            default:
                System.out.println("Invalid Option");
        }

        return false;
    }
    
    
    public void saveGame() throws IOException, GameControlException{
       System.out.println("please enter file path for save file");
       String filepath = this.keyboard.readLine()+".txt";
        
        Game e = EscapeIsland.getCurrentGame();
        GameControl.saveGame(e, filepath);
        
        System.out.println("Game Saved!");
    }
    
    
    
}
