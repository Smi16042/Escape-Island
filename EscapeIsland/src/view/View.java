package view;

import escapeIsland.EscapeIsland;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Austin
 */
public abstract class View implements ViewInterface {

    private String message;
    
    protected final BufferedReader keyboard = EscapeIsland.getInFile();
    protected final PrintWriter console = EscapeIsland.getOutFile();

    public View() {
    }
    
   
    public String getInput(String promptMessage) {

        boolean valid = false;
        String value = null;

        while (!valid) {
            this.console.println(promptMessage);
            try {
                value = this.keyboard.readLine();
            } catch (IOException ex) {
                Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
            }

            value = value.trim();
            this.console.println("");
            if (value.length() < 1) {
                this.console.println("You must enter a non-blank value");

                continue;
            }
            valid = true;

        }
        return value;
    }

    public void display() {

        boolean endOfView = false;
        do {

            String[] inputs = getInputs();

            if (inputs[0].length() < 1 || inputs.equals("Q")) {
                endOfView = true;
            }
            endOfView = doAction(inputs);
        } while (endOfView != true);

    }
}
