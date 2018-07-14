package view;

import escapeIsland.EscapeIsland;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Scanner;
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

        Scanner sc = new Scanner(System.in);
        boolean valid = false;
        String value = "";

        while (valid == false) {
            System.out.println(promptMessage);
            value = sc.nextLine();

            value = value.trim();
            System.out.println("");
            if (value.length() < 1) {
                System.out.println("You must enter a non-blank value");

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
