/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.*;
import exceptions.InventoryControlException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;
import model.*;

/**
 *
 * @author Collin
 */
public class EquipItem extends View {

    @Override
    public String[] getInputs() {
        String[] inputs = new String[1];

        //inputs = new String[1];

        this.console.println("***********************************************************"
                       + "\n***********************************************************"
                       + "\n*                                                         *"
                       + "\n*                    Inventory Menu                       *"
                       + "\n* P - Display Inventory                                   *"
                       + "\n* E - Equip Item                                          *"
                       + "\n* Q - Quit to Game Menu                                   *"
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
                case 'P':
                    displayInventory();
                    break;
                case 'E':
                    equipItem();
                    break;
                case 'Q':
                    return true;
                default:
                    ErrorView.display(this.getClass().getName(),
                    "Invald menu option.");
            }


        return false;
    }
   


    private void displayInventory() {
        
        
        InventoryControl inventorycontrol = new InventoryControl();
        Actor ralph = Actor.PrisonGuard;
        ArrayList<Item> inventory = new ArrayList();
        inventory.add(Item.ToolKit);
        inventory.add(Item.Stick);
        inventory.add(Item.LeadPipe);
        inventory.add(Item.Sword);
        ralph.setActorItems(inventory);
        
        try {
            inventorycontrol.displayInventory(ralph);
        } catch (InventoryControlException ex) {
            this.console.println(ex.getMessage());
        }
     }
    
    private void equipItem() {
        
        InventoryControl inventorycontrol = new InventoryControl();
        Actor max = Actor.MonsterZombie;
        
        ArrayList<Item> inventory = new ArrayList();
        inventory.add(Item.Sword);
        inventory.add(Item.Compass);
        inventory.add(Item.ToolKit);
        max.setActorItems(inventory);
        try {
            inventorycontrol.displayInventory(max);
        } catch (InventoryControlException ex) {
            ErrorView.display(this.getClass().getName(),
                    "Error reading input " + ex.getMessage());
        }
        try {
            inventorycontrol.equipItem(max, Item.ToolKit);
        } catch (InventoryControlException ex) {
            this.console.println(ex.getMessage());ErrorView.display(this.getClass().getName(),
                    "Error reading input " + ex.getMessage());
        }
        
        this.console.println("Item Currently Equipped:");
        this.console.println(max.getCurrentItem().getItemName());
}
}