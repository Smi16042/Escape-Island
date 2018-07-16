package view;

import control.InventoryControl;
import escapeIsland.EscapeIsland;
import exceptions.InventoryControlException;
import java.util.Scanner;
import model.*;
import view.BattleScene.*;
import java.util.Random;
import java.awt.Point;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Austin
 */
public class InteractWithEnviromentView extends View {

    public boolean doAction(String[] inputs) {

        Location currentLocation
                = EscapeIsland.getCurrentGame().getMap().getLocations()[Actor.Hero.getActorcoordinates().x][Actor.Hero.getActorcoordinates().y];

        char interactionsMenu = inputs[0].trim().toUpperCase().charAt(0);

        switch (interactionsMenu) {
            case 'C':
                if (currentLocation.getActor() != null) {
                    if (combatControls()) {
                        return false;
                    }
                } else {
                    System.out.println("Invalid Option");
                }
                break;
            case 'I':
                if (currentLocation.getItemRequired() != null) {
                    itemRequiredScene();
                } else {
                    System.out.println("Invalid Option");
                }
                break;
            case 'L':
                if (currentLocation.getObtainItem() != null) {
                    getLoot();
                } else {
                    System.out.println("Invalid Option");
                }
                break;
            case 'T':
                if (currentLocation.getTalkToNPC() != null) {
                    talkToNPC();
                } else {
                    System.out.println("Invalid Option");
                }
                break;
            case 'R':
                if (currentLocation.getRiddle() != null) {
                    riddle(EscapeIsland.getCurrentGame().getMap().getLocations()[(int) Actor.Hero.getActorcoordinates().getY()][(int) Actor.Hero.getActorcoordinates().getX()]
                            .getRiddle());
                } else {
                    System.out.println("Invalid Option");
                }
                break;
            case 'M':
                return true;
            default:
                System.out.println("Invalid Option");
        }

        return false;
    }

    public String[] getInputs() {
        String[] inputs = new String[1];

        Location currentLocation
                = EscapeIsland.getCurrentGame().getMap().getLocations()[Actor.Hero.getActorcoordinates().x][Actor.Hero.getActorcoordinates().y];

        System.out.println("***********************************************************"
                + "\n***********************************************************"
                + "\n*                                                         *"
                + "\n* Interactions                                            *"
                + "\n*                                                         *");

        if (currentLocation.getActor() != null) {
            System.out.println("* C - Combat ");
        };
        if (currentLocation.getItemRequired() != null) {
            System.out.println("* I - Item Required");
        }
        if (currentLocation.getObtainItem() != null) {
            System.out.println("* L - Loot");
        }
        if (currentLocation.getTalkToNPC() != null) {
            System.out.println("* T - Talk");
        }
        if (currentLocation.getRiddle() != null) {
            System.out.println("* R - Riddle");
        }

        System.out.println("\n* M - Return to map                                        *"
                + "\n*                                                         *"
                + "\n***********************************************************"
                + "\n***********************************************************");

        String[] menuItem = new String[1];
        Scanner sc = new Scanner(System.in);
        menuItem[0] = sc.nextLine();

        return menuItem;
    }

    private boolean combatControls() {

        Location location = EscapeIsland.getCurrentGame().getMap().getLocations()[Actor.Hero.getActorcoordinates().x][Actor.Hero.getActorcoordinates().y];

        Actor monster = location.getActor();
        while (deathScene(Actor.Hero, monster)) {

            Actor hero = EscapeIsland.getCurrentPlayer().getActor();

            System.out.println("***********************************************************"
                    + "\n***********************************************************"
                    + "\n*                                                         *"
                    + "\n*      Combat Scene                                       *"
                    + "\n*                                                         *");

            // get Hero Current HP, attack and defense
            System.out.println(EscapeIsland.getCurrentPlayer().getPlayersName() + "                                      " + monster.getActorName());
            System.out.println("Hit Points: " + Actor.Hero.getActorHitPoints() + "                            " + "Hit Points: " + monster.getActorHitPoints());
            System.out.println("Attack: " + BattleScene.totalAttack(Actor.Hero) + "                                 " + "Attack: " + BattleScene.totalAttack(monster));
            System.out.println("Defense: " + BattleScene.totalDefense(Actor.Hero) + "                                " + "Defense: " + BattleScene.totalDefense(monster));

            System.out.println("\n                                                          "
                    + "\n* A - Attack                                              *"
                    + "\n* D - Defend                                              *"
                    + "\n* I - Item                                                *"
                    + "\n* F - Flee                                                *"
                    + "\n*                                                         *"
                    + "\n***********************************************************"
                    + "\n***********************************************************");

            Scanner sc = new Scanner(System.in);
            String talkToNPC = sc.nextLine();

            char combatOptions = talkToNPC.trim().toUpperCase().charAt(0);

            switch (combatOptions) {

                case 'A':
                    attack(hero, monster);
                    break;

                case 'D':
                    defend(hero, monster);
                    break;

                case 'I':
                    item();
                    break;

                case 'F':
                    return false;

                default:
                    System.out.println("Invalid Option");

            }

            if (combatAI(monster)) {
                attack(monster, hero);
            } else {
                defend(monster, hero);
            }

 

        }
        return false;
    }

    private void attack(Actor attacker, Actor defender) {
        long damage = BattleScene.calcDamage(BattleScene.totalAttack(attacker), BattleScene.totalDefense(defender));
        BattleScene.damageTaken(defender, damage);
        System.out.println(attacker.getActorName() + " attacks " + defender.getActorName() + " for " + damage + " damage.");
    }

    private void defend(Actor defender, Actor attacker) {
        long damage = BattleScene.defense(attacker, BattleScene.totalAttack(defender));
        //BattleScene.damageTaken(defender, damage);
        System.out.println(defender.getActorName() + " defends, It seems pointless.");
    }

    private void item() {

    }

    private boolean combatAI(Actor monster) {

        Random combatAI = new Random();

        int n = combatAI.nextInt(3) + 1;

        if (n <= 2) {
            return true;
        }
        return false;
    }

    private void itemRequiredScene() {

        Location currentLocation
                = EscapeIsland.getCurrentGame().getMap().getLocations()[Actor.Hero.getActorcoordinates().x][Actor.Hero.getActorcoordinates().y];

        if (Actor.Hero.getCurrentItem() != currentLocation.getItemRequired()) {
            System.out.println("\n***********************************************************"
                    + "\n***********************************************************"
                    + "\n*                                                         *"
                    + "\n*The " + currentLocation.getItemRequired().getItemName() + "                   *"
                    + "\n*is required to progress                                  *"
                    + "\n                                                          *"
                    + "\n***********************************************************"
                    + "\n***********************************************************");
            return;
        } else {
            System.out.println("\n***********************************************************"
                    + "\n***********************************************************"
                    + "\n*                                                         *"
                    + "\n*The " + currentLocation.getItemRequired().getItemName() + "                   *"
                    + "\n* allowed you to progress.                                *"
                    + "\n*                                                         *"
                    + "\n***********************************************************"
                    + "\n***********************************************************");
        }
    }

    private void getLoot() {

        Location currentLocation
                = EscapeIsland.getCurrentGame().getMap().getLocations()[Actor.Hero.getActorcoordinates().x][Actor.Hero.getActorcoordinates().y];

        Actor player1 = EscapeIsland.getCurrentPlayer().getActor();
        try {
            InventoryControl.addItemToInventory(player1, currentLocation.getObtainItem());
        } catch (InventoryControlException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("\n***********************************************************"
                + "\n***********************************************************"
                + "\n*                                                         *"
                + "\n*Congradulations you have obtained " + currentLocation.getObtainItem().getItemName() + "        *"
                + "\n*                                                         *"
                + "\n***********************************************************"
                + "\n***********************************************************");
        return;
    }

    private boolean talkToNPC() {
        boolean javaIsDumb = true;
        while (javaIsDumb) {
            System.out.println("A - Hello");
            System.out.println("B - Who are you?");
            System.out.println("C - What things roam?");
            System.out.println("D - Good bye");

            Scanner sc = new Scanner(System.in);
            String talkToNPC = sc.nextLine();

            char chatOptions = talkToNPC.trim().toUpperCase().charAt(0);

            switch (chatOptions) {

                case 'A':
                    optionAChat();
                    break;

                case 'B':
                    optionBChat();
                    break;

                case 'C':
                    optionCChat();
                    break;

                case 'D':
                    optionDChat();
                    return true;

                case 'Q':
                    return true;

                default:
                    System.out.println("Invalid Option");

            }
        }
        return false;
    }

    private void puzzle() {
        System.out.println("\n***********************************************************"
                + "\n***********************************************************"
                + "\n*                                                         *"
                + "\n*                                                         *"
                + "\n*Puzzle Text                                              *"
                + "\n*                                                         *"
                + "\n*                                                         *"
                + "\n*                                                         *"
                + "\n***********************************************************"
                + "\n***********************************************************");
        return;
    }

    private void riddle(Riddle riddle) {
        System.out.println("\n***********************************************************"
                + "\n***********************************************************"
                + "\n*                                                         *"
                + "\n*                                                         *"
                + riddle
                + "\n*                                                         *"
                + "\n*                                                         *"
                + "\n***********************************************************"
                + "\n***********************************************************");

        Scanner riddleScanner = new Scanner(System.in);
        String rScanner = riddleScanner.nextLine();

        if (rScanner == riddle.getAnswer()) {
            System.out.println("Correct!");
            riddle.setRiddleDone(true);
        } else {
            System.out.println("Incorrect, try agian.");
        }
        return;
    }

    private void optionAChat() {
        System.out.println("Hello");
        System.out.println("Marcus says \"Hey their sunny boy, welcome to our own personal hell. "
                + "Before you explore the island you should equip yourself. Strange things travel in the night"
                + " I'm to old to be of much use now, but I have found some "
                + "interesting trinkets in my glory days. Loot this camp and the camp directly to the "
                + "west before you explore the island... or dont, its your life. \"");

    }

    private void optionBChat() {
        System.out.println("Who are you?");
        System.out.println("Marcus says \"My name is Marcus Stone, I was an explorer in the Queens Royal Navy, "
                + "my vessal marroned here, and I've been surviving ever since. Its been over 30 years now. \"");

    }

    private void optionCChat() {
        System.out.println("What things roam?");
        System.out.println("Marcus says \" Monsters, and the remenants of my old crew. There is something odd about this place. "
                + "Something that makes the blood curl and myths become real. Best ye watch yourself.\"");
    }

    private void optionDChat() {
        System.out.println("Good bye");
        System.out.println("Marcus says \"God speed and good luck... you'll need it.\"");

    }

    private boolean deathScene(Actor hero, Actor monster) {

        if (BattleScene.death(hero)) {
            System.out.println("YOU HAVE DIED");
            hero.setActorCoordinates(new Point(7, 2));
            hero.setActorHitPoints(15);
            return false;
            
        } else if (BattleScene.death(monster)) {
            System.out.println("VICTORY!");
            return false;
        }
        return true;

    }

}
