/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.CombatControl;
import escapeIsland.EscapeIsland;
import model.Actor;
import model.Item;
import model.Location;

/**
 *
 * @author Austin
 */
public class BattleScene {

    public static long totalAttack(Actor actor) {

        return(actor.getActorAttack() + actor.getCurrentItem().getAttack());

    }

    public static long totalDefense(Actor actor) {

        return (actor.getActorDefense() + actor.getCurrentItem().getDefense());
    }

    public static long calcDamage(long totalAttack, long totalDefense) {

        return (totalAttack - totalDefense);
    }
    
    public static void damageTaken(Actor actor, long calcDamage){
        
       actor.setActorHitPoints(actor.getActorHitPoints() - calcDamage);
    }
    
    public static boolean death(Actor actor){
        if(actor.getActorHitPoints() <= 0){
            return true;
        }
        return false;
    }
    
    public static void defense(Actor actor, long damageTaken){
        
        long damage = damageTaken - BattleScene.totalDefense(actor) * 2;
        actor.setActorHitPoints(actor.getActorHitPoints() - damage);
    }
    
}

