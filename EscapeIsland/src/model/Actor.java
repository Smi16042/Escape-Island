/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Austin
 */
public enum Actor implements Serializable {
    
    
 // each monster in mapcontrol location needs to be unique, aka MonsterGoblinJoe...
 // or you can turn the enum into a template and create a monster class. I dont have enough time
 // or I would do this. 
 MonsterZombie("Zombie" , new Point(1,1),"a frightful zombie", 3, 2, 2, 10, Item.fisticuffs ),
 MonsterSkeleton("Skeleton" , new Point(1,1),"a terrifying skeleton", 2, 3, 2, 10, Item.fisticuffs ),
 MonsterGoblin("Goblin" , new Point(1,1),"a spooky goblin", 1, 1, 1, 10, Item.fisticuffs ),
 PrisonGuard("Erik" , new Point(2,2), "a tired prison guard", 2, 2, 1, 10, Item.fisticuffs ),
 Inmate02("Inmate02" , new Point(2,2), "an enraged prison inmate", 3, 3, 1, 10, Item.fisticuffs ),
 Inmate09("Inmate09" , new Point(2,2), "an enraged prison inmate", 2, 3, 1, 10, Item.fisticuffs ),
 Inmate08("Inmate08" , new Point(2,2), "an enraged prison inmate", 4, 1, 1, 10, Item.fisticuffs ),
 OldMan("Magnus Stone" , new Point(7,2),"a lonesome old man trapped on the island", 10, 10, 10, 50, Item.Sword ),
 Hero("Hero" , new Point(7,2), "The hero", 4, 4, 2, 15, Item.fisticuffs);

private String actorName;
private Point actorcoordinates;
private String actorDescription;
private long actorAttack;
private long actorDefense;
private long actorSpeed;
private ArrayList <Item> actorItems = new ArrayList();
private Item currentItem;
private long actorHitPoints;

    private Actor() {
    }


    private Actor(String actorName, Point actorcoordinates, String actorDescription, long actorAttack, long actorDefense, long actorSpeed, long actorHitPoints, Item currentItem) {
        this.actorName = actorName; 
        this.actorcoordinates = actorcoordinates;
        this.actorDescription = actorDescription;
        this.actorAttack = actorAttack;
        this.actorDefense = actorDefense;
        this.actorSpeed = actorSpeed;
        this.actorHitPoints = actorHitPoints;
        this.currentItem = currentItem;
 }
    
    
    public long getActorHitPoints() {
        return actorHitPoints;
    }

    public void setActorHitPoints(long actorHitPoints) {
        this.actorHitPoints = actorHitPoints;
    }

    public String getActorName() {
        return actorName;
    }

    public Point getActorcoordinates() {
        return actorcoordinates;
    }

    public String getActorDescription() {
        return actorDescription;
    }

    public long getActorAttack() {
        return actorAttack;
    }

    public long getActorDefense() {
        return actorDefense;
    }

    public long getActorSpeed() {
        return actorSpeed;
    }

    public ArrayList<Item> getActorItems() {
        return actorItems;
    }

    @Override
    public String toString() {
        return "Actor{" + "actorName=" + actorName + ", actorcoordinates=" + actorcoordinates + ", actorDescription=" + actorDescription + ", actorAttack=" + actorAttack + ", actorDefense=" + actorDefense + ", actorSpeed=" + actorSpeed + ", actorItems=" + actorItems + '}';
    }

    public void setActorItems(ArrayList<Item> actorItems) {
        this.actorItems = actorItems;
    }
    
    public void setActorCoordinates(Point newCoords) {
        this.actorcoordinates = newCoords;
    }

    public Item getCurrentItem() {
        return currentItem;
    }

    public void setCurrentItem(Item currentItem) {
        this.currentItem = currentItem;
    }

    public void setActorName(String setActorName){
        this.actorName = setActorName;
    }

    
    
}
