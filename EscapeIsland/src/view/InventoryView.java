/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.*;
import java.util.ArrayList;
import java.util.Scanner;
import model.*;

/**
 *
 * @author Collin
 */
public class InventoryView {

    public void displayInventoryView() {

        boolean endOfView = false;
        do {
            String[] inputs = getInputs();
            // System.out.println("input name");

            if (inputs[0].trim().length() < 1 || inputs[0].equals('Q')) {
                endOfView = true;
            }
            endOfView = doAction(inputs);
        } while (endOfView != true);

    }

    private String[] getInputs() {
        String[] inputs = new String[1];

        //inputs = new String[1];

        System.out.println("***********************************************************"
                       + "\n***********************************************************"
                       + "\n*                                                         *"
                       + "\n*                    Inventory Menu                       *");
        displayInventory();
                       System.out.println("\n* E - Equip Item                                          *"
                       + "\n* Q - Quit to Game Menu                                   *"
                       + "\n*                                                         *"
                       + "\n***********************************************************"
                       + "\n***********************************************************");

        String[] menuItem = new String[1];
        Scanner sc = new Scanner(System.in);
        menuItem[0] = sc.nextLine();
        
      return menuItem;
    }

    private boolean doAction(String[] inputs) {

        char c = inputs[0].trim().toUpperCase().charAt(0);

            switch (c) {
                case 'P':
                    displayInventory();
                    break;
                case 'E':
                    equipItem();
                    break;
                case 'Q':
                    return true;
                default: 
                    System.out.println("Invalid Option");
            }


        return false;
    }
   


    private void displayInventory() {
        
        
        InventoryControl inventorycontrol = new InventoryControl();
        Actor ralph = Actor.PrisonGaurd;
        ArrayList<Item> inventory = new ArrayList();
        inventory.add(Item.ToolKit);
        inventory.add(Item.Axe);
        inventory.add(Item.Axe);
        inventory.add(Item.Sword);
        ralph.setActorItems(inventory);
        
        System.out.println("* ");
        for (int i = 0; i < inventory.size(); i++){
            int num = i +1; 
            
            
        System.out.print(num + " " +  inventory.get(i).getItemName() + " - " );
        //5 is number of genenteed taken spaces by 2 * and 2 spaces and one number
        int numberOfTakenSpaces = 5 + inventory.get(i).getItemName().length();
        // if number is two didget it will take two spaces
        if(i >=9){
            numberOfTakenSpaces++;
        }
//        //print spaces to the end
//        //59 spaces to the menu
//        for(int j = 50; j > numberOfTakenSpaces; j--)
//                System.out.print(" ");
//        }
//        //print closing *
//        System.out.println("*");
        
        }
        inventorycontrol.displayInventory(ralph);
     }
    
    private void equipItem() {
        
        InventoryControl inventorycontrol = new InventoryControl();
        Actor max = Actor.MonsterZombie;
        
        ArrayList<Item> inventory = new ArrayList();
        inventory.add(Item.Axe);
        inventory.add(Item.Compass);
        inventory.add(Item.ToolKit);
        max.setActorItems(inventory);
        inventorycontrol.displayInventory(max);
        inventorycontrol.equipItem(max, Item.ToolKit);
        
        System.out.println("Item Currently Equipped:");
        System.out.println(max.getCurrentItem().getItemName());
}
}