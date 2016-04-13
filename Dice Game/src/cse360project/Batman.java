package cse360project;

/**
 * @author Team35
 * @version April 15, 2016
 */

public class Batman extends Character{
	/**
	 * Batman Class constructor to initialize the health and the attack power of
	 * the 3 weapons 
	 */
	Batman(){
		healthBar = 100;
		weapon1 = 10;
		weapon2 = 8;
		weapon3 = 5;
	}
	
	int getWeapon1(){
		return weapon1;
	}
	
	int getWeapon2(){
		return weapon2;
	}
	
	int getWeapon3(){
		return weapon3;
	}
	
	void updateHealth(double health){
		healthBar = health;
	}
	
	double getHealth(){
		return healthBar;
	}

}
