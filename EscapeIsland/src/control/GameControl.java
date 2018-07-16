/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import escapeIsland.*;
import java.util.Collections;
import model.*;
import java.util.ArrayList;
import java.util.List;
import static control.MapControl.createLocations;
import exceptions.GameControlException;
import exceptions.MapControlException;
/**
 *
 * @author Austin
 */
public class GameControl {

    public static Player savePlayer(String playersName) {
        // System.out.println("*** SavePlayer() called ***");
        Player player1 = new Player();
        player1.setPlayersName(playersName);
        EscapeIsland.setCurrentPlayer(player1);
        
        return player1;
    }

    public static void createNewGame(Player player)
        throws GameControlException {
        System.out.println("*** createNewGame called ***");
        if (player == null) {
            throw new GameControlException("player is null");
        }
        try {
        //Create new Game
        Game game = new Game();
        game.setPlayer(player);
        //Add the create game ot the game we're playing (EscapeIsland)
        EscapeIsland.setCurrentGame(game);
        
        player.setActor(Actor.Hero);
        
        Riddle[] riddle = createRiddles();
        Map map;
       
        
            map = MapControl.createMap(game, 10, 10);
            
            if (map == null) {
            throw new GameControlException("map is null");
            }
            game.setMap(map);
            
            game.getMap().setLocations(createLocations(10, 10, riddle));
         
            game.getMap().getLocations()[game.getPlayer().getActor().getActorcoordinates().x]
                  [game.getPlayer().getActor().getActorcoordinates().y].setVisited(true);
            
        } catch (MapControlException ex) {
            System.out.println(ex.getMessage());
        }


       
        
    }

    public static Riddle[] createRiddles() {
        System.out.println("*** createRiddles called ***");

        Riddle[] riddles = new Riddle[5];

        for (int i = 0; i < riddles.length; i++) {
            riddles[i] = new Riddle();

        }
        riddles[0].setRiddle("What is the airspeed velocity of a north african swallow");
        riddles[0].setAnswer("");

        riddles[1].setRiddle("What always ends everything?");
        riddles[1].setAnswer("g");
      
        riddles[2].setRiddle("What has four fingers and a thumb, but is not living");
        riddles[2].setAnswer("A glove");

        riddles[3].setRiddle("I have keys but no lock. I have a space but no room. You can enter, but can't go outside. What am I?");
        riddles[3].setAnswer("A keyboard");

        riddles[4].setRiddle("What gets bigger the more you take away.");
        riddles[4].setAnswer("A hole");

        return riddles;
    }
 
    public static void riddleArrayList(){
        List<String> questionArrayList = new ArrayList();
        List<String> answerArrayList = new ArrayList();
        Riddle[] riddles = createRiddles();
        
        for(Riddle riddle : riddles){
//            questionArrayList.add(riddle.getRiddle());//
            answerArrayList.add(riddle.getAnswer());
  //          Collections.sort(questionArrayList);
            Collections.sort(answerArrayList);            
        }
        
        for (int i = 0; i < riddles.length; i++){
        //System.out.println(questionArrayList.get(i));
        System.out.println(answerArrayList.get(i));
    }
     
    
    
    }
  
}
