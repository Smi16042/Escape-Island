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

    //add exception handling
    public static long totalAttack(Actor actor) {

        if (actor.getCurrentItem() == null) {
            actor.setCurrentItem(Item.fisticuffs);
        }
        return (actor.getActorAttack() + actor.getCurrentItem().getAttack());

    }

    public static long totalDefense(Actor actor) {
        if (actor.getCurrentItem() == null) {
            actor.setCurrentItem(Item.fisticuffs);
        }

        return (actor.getActorDefense() + actor.getCurrentItem().getDefense());
    }

    public static long calcDamage(long totalAttack, long totalDefense) {

        long damage = totalAttack - totalDefense;
        if (damage < 0) {
            damage = 1;
        }
        return damage;
    }

    public static void damageTaken(Actor actor, long calcDamage) {

        actor.setActorHitPoints(actor.getActorHitPoints() - calcDamage);
    }

    public static boolean death(Actor actor) {
        if (actor.getActorHitPoints() <= 0) {
            System.out.println("YOU HAVE DIED");
            return true;
        }
        return false;
    }

    public static void defense(Actor actor, long damageTaken) {

        long damage = damageTaken - BattleScene.totalDefense(actor) * 2;
        if (damage < 0) {
            damage = 1;
        }
        actor.setActorHitPoints(actor.getActorHitPoints() - damage);
    }

}
