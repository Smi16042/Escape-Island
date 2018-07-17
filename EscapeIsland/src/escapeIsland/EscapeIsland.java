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

    private static PrintWriter logFile = null;
    private static BufferedReader input;
    private static PrintWriter output;
    
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
            
            input = new BufferedReader(new InputStreamReader(System.in));
            output = new PrintWriter(System.out, true);
            
            logFile = new PrintWriter("logFile.txt");
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
                if(logFile != null){
                logFile.close();
                }
            } catch (IOException ex) {
                System.out.println("Error closing files");
                return;
            }
        }
        

//Riddle[] riddle = createRiddles();
//        Location[][] location = currentGame.createLocations(6, 6, riddle);
//        if (location[0][0] != null) {
//            System.out.println(-1);
//        }
//
//        System.out.println(location[0][0].getBackgroundType());
// System.out.println(derp[0][1].getBackgroundType());
//        for(Location[] la: derp) {
//              for(Location l : derp[0]){
//                  if (l.getBackgroundType() != null){
//                    System.out.println(l.getBackgroundType());
//                }
//              }
//          }
//        GameMenuView gameMenuView = new GameMenuView();
//        gameMenuView.displayGameMenuView(player, map);
//        gameMenuView.openMap(map);
//        // TODO code application logic here
//        Player austin = new Player();
//            austin.setPlayerName("austin");
//        
//        
//        Game game = new Game();
//        Player[] list = new Player[1];
//        list[0] = austin;
//            game.setPlayer(list);
//        System.out.println(game.toString());
//        
//        System.out.println(Actor.PrisonGaurd.toString());
//        
//        System.out.println(Item.ToolKit.toString());
//        
//        System.out.println(BackgroundType.Beach.toString());
//        
//        
//        Map map1 = new Map("test map",1,1,1,1);
//        System.out.println(map1.toString());
//        
//        Location location1 = new Location(1,1,true,true,"1",BackgroundType.Beach,true);
//        
//        System.out.println(location1.toString());
//        
//        PuzzleLocation room = new PuzzleLocation("interaction",1,1,true,true,"1",BackgroundType.Beach,true);
//        
//        System.out.println(room.toString());
//        
//        Riddle question1 = new Riddle("favorite color","blue");
//        
//        System.out.println(question1.toString());
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

    public static PrintWriter getLogFile() {
        return logFile;
    }

    public static void setLogFile(PrintWriter logFile) {
        EscapeIsland.logFile = logFile;
    }

    public static BufferedReader getInput() {
        return input;
    }

    public static void setInput(BufferedReader input) {
        EscapeIsland.input = input;
    }

    public static PrintWriter getOutput() {
        return output;
    }

    public static void setOutput(PrintWriter output) {
        EscapeIsland.output = output;
    }
    
}
