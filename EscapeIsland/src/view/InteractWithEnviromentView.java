package view;

import escapeIsland.EscapeIsland;
import java.util.Scanner;
import model.*;

/**
 *
 * @author Austin
 */
public class InteractWithEnviromentView extends View {

    Actor max = Actor.MonsterZombie;

    public boolean doAction(String[] inputs) {

        Location currentLocation
                = EscapeIsland.getCurrentGame().getMap().getLocations()
                [Actor.Hero.getActorcoordinates().x]
                [Actor.Hero.getActorcoordinates().y];

        char interactionsMenu = inputs[0].trim().toUpperCase().charAt(0);

        switch (interactionsMenu) {
            case 'C':
                if (currentLocation.getActor() != null) {
                    combatControls();
                } else {
                    System.out.println("Invalid Option");
                }
                break;
            case 'I':
                if (currentLocation.getActor() != null) {
                    itemRequiredScene();
                } else {
                    System.out.println("Invalid Option");
                }
                break;
            case 'L':
                if (currentLocation.getActor() != null) {
                    getLoot();
                } else {
                    System.out.println("Invalid Option");
                }
                break;
            case 'T':
                if (currentLocation.getActor() != null) {
                    talkToNPC();
                } else {
                    System.out.println("Invalid Option");
                }
                break;
            case 'P':
                if (currentLocation.getActor() != null) {
                    puzzle();
                } else {
                    System.out.println("Invalid Option");
                }
                break;
            case 'R':
                if (currentLocation.getActor() != null) {
                    riddle(EscapeIsland.getCurrentGame().getMap().getLocations()
                            [(int) Actor.Hero.getActorcoordinates().getY()]
                            [(int) Actor.Hero.getActorcoordinates().getX()]
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

    private void combatControls() {
        System.out.println("\n***********************************************************"
                + "\n***********************************************************"
                + "\n*                                                         *"
                + "\n* Combat                                                  *"
                + "\n*                                                         *"
                + "\n*A - Attack                                               *"
                + "\n*D - Defend                                               *"
                + "\n*I - Item                                                 *"
                + "\n*F - Flee                                                 *"
                + "\n*                                                         *"
                + "\n***********************************************************"
                + "\n***********************************************************");
        return;
    }

    private void itemRequiredScene() {
        
        Location currentLocation
                = EscapeIsland.getCurrentGame().getMap().getLocations()
                [Actor.Hero.getActorcoordinates().x]
                [Actor.Hero.getActorcoordinates().y];
        
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
                = EscapeIsland.getCurrentGame().getMap().getLocations()
                [Actor.Hero.getActorcoordinates().x]
                [Actor.Hero.getActorcoordinates().y];
        
        System.out.println("\n***********************************************************"
                + "\n***********************************************************"
                + "\n*                                                         *"
                + "\n*Congradulations you have obtained " + currentLocation.getObtainItem().getItemName()+ "        *"
                + "\n*                                                         *"
                + "\n***********************************************************"
                + "\n***********************************************************");
        return;
    }

    private boolean talkToNPC() {
        boolean javaIsDumb = true;
        while (javaIsDumb) {
            System.out.println("A - Hello");
            System.out.println("B - How are you");
            System.out.println("C - Thats good");
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
        System.out.println("NPC says \"hello\"");

    }

    private void optionBChat() {
        System.out.println("How are you");
        System.out.println("NPC says \"Good\"");

    }

    private void optionCChat() {
        System.out.println("Thats good");
        System.out.println("NPC says \"Yup\"");
    }

    private void optionDChat() {
        System.out.println("Good bye");
        System.out.println("NPC says \"Bye!\"");

    }
}
