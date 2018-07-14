/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import exceptions.CombatControlException;

/**
 *
 * @author collin
 */

public class CombatControl {
     
    public static double calcSpeed(double actorEnemySpeed, double actorPlayerSpeed, double actorItem) 
            throws CombatControlException {


     if (actorEnemySpeed < 1) {
          throw new CombatControlException("invalid actorEnemySpeed");
     }
     
     if (actorEnemySpeed < 1 || actorEnemySpeed > 100){
         throw new CombatControlException("invalid actorEnemySpeed1");
     }
     
     if (actorPlayerSpeed < 1){
          throw new CombatControlException("invalid actorPlayerSpeed");
     }
     
     if(actorPlayerSpeed < 1 || actorPlayerSpeed > 100){
         throw new CombatControlException("invalid actorPlayerSpeed1");
    }
     
     if(actorItem < 1){
         throw new CombatControlException("invalid actorItem");
     }
     
     if(actorItem < 1 || actorItem > 100){
         throw new CombatControlException("invalid actorItem1");
    }
     
        double playerSpeed = actorItem + actorPlayerSpeed;
        double fightSpeed = playerSpeed / actorEnemySpeed;
       
        return fightSpeed;
        

        
        }
    
    public static double calcDamageDealt(double actorPlayerStrength, double actorWeapon, double actorEnemyDefense)
        throws CombatControlException{
        
        if (actorPlayerStrength < 1) {
            throw new CombatControlException("invalid actorPlayerStrength");
        }	
        
        if (actorPlayerStrength < 1 || actorPlayerStrength > 100){
            throw new CombatControlException("invalid actorPlayerStrength1");
        }
        
        if (actorWeapon < 1){
           throw new CombatControlException(" invalid actorWeapon");
        }
        
        if (actorWeapon < 1 || actorWeapon > 100){
          throw new CombatControlException(" invalid actorWeapon1");
        }
        
        if (actorEnemyDefense < 1){
          throw new CombatControlException(" invalid actorEnemyDefense");
        }
        
        if (actorEnemyDefense < 1 || actorEnemyDefense > 100){
          throw new CombatControlException(" invalid actorEnemyDefense1");
        }
        
        double playerDamageDealt = actorPlayerStrength + actorWeapon;
        double damageDealt = playerDamageDealt - actorEnemyDefense;
        
        return damageDealt;
  
    }
     


    public static double calcCrit (double aa, double as, double ais, double aia, double chance)
        throws CombatControlException {

	if (aa < 0 || as < 0 || ais < 0 || aia <0) {
		throw new CombatControlException(" invalid CombatControlException");
    }
	if (aa > 100 || as > 100 || ais > 100 || aia > 100) {
		throw new CombatControlException(" invalid CombatControlException1");
    }

    double criticalHitChance = (aa + as + ais + aia) / 100;

   
        System.out.println(criticalHitChance);
        System.out.println(chance);
        //System.out.println(derp);
if (criticalHitChance > chance) {
	return aa*2;
}
else {
    return 0;
} 

    }   
}