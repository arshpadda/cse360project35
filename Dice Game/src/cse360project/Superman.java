package cse360project;

/**
 * @author Team35
 * @version April 15, 2016
 */


public class Superman extends Character{
	/**
	 * Superman Class constructor to initialize the health and the attack power of
	 * the 3 weapons 
	 */
	Superman(){
		healthBar = 100;
		weapon1 = 10;
		weapon2 = 8;
		weapon3 = 6;
	}
	
	/**
	 * Return the value of weapon1
	 */
	int getWeapon1(){
		return weapon1;
	}
	
	/**
	 * Return the value of weapon2
	 */
	int getWeapon2(){
		return weapon2;
	}
	
	/**
	 * Return the value of weapon3
	 */
	int getWeapon3(){
		return weapon3;
	}
	
	/**
	 * Update the health of Batman 
	 */
	void updateHealth(int health){
		healthBar = health;
	}
	
	/**
	 * Return the value of healthBar
	 */
	int getHealth(){
		return healthBar;
	}
}
