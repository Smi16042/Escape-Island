package escapeIsland;

import model.*;
import control.*;
import static control.GameControl.createRiddles;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.StartProgramView;
import view.GameMenuView;

/**
 *
 * @author collin
 */
public class EscapeIsland {

    private static Game currentGame = null;
    private static Player currentPlayer;

    private static PrintWriter outFile = null;
    private static BufferedReader inFile = null;

    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game currentGame) {
        EscapeIsland.currentGame = currentGame;
    }

    public static Player getCurrentPlayer() {
        return currentPlayer;
    }

    public static void setCurrentPlayer(Player currentPlayer) {
        EscapeIsland.currentPlayer = currentPlayer;
    }

    public static void main(String[] args) {

        try {

            EscapeIsland.inFile = new BufferedReader(new InputStreamReader(System.in));
            EscapeIsland.outFile = new PrintWriter(System.out, true);

            EscapeIsland adidas = new EscapeIsland();
            GameControl gameControl = new GameControl();

            StartProgramView startProgramView = new StartProgramView();
            startProgramView.display();

            gameControl.riddleArrayList();

        } catch (Throwable e) {
            System.out.println("Exception: " + e.toString()
                    + "\nCause: " + e.getCause()
                    + "\nMessage: " + e.getMessage());

            e.printStackTrace();;
        } finally {
            try {
                if (EscapeIsland.inFile != null) {
                    EscapeIsland.inFile.close();
                }
                if (EscapeIsland.outFile != null) {
                    EscapeIsland.outFile.close();
                }
            } catch (IOException ex) {
                System.out.println("Error closing files");
                return;
            }
        }




    }

    public static PrintWriter getOutFile() {
        return outFile;
    }

    public static void setOutFile(PrintWriter outFile) {
        EscapeIsland.outFile = outFile;
    }

    public static BufferedReader getInFile() {
        return inFile;
    }

    public static void setInFile(BufferedReader inFile) {
        EscapeIsland.inFile = inFile;
    }
}
