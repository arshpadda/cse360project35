package cse360project;

/**
 * @author Team35
 * @version April 15, 2016
 */


public class Superman extends Character{

	Superman(){
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
	
	void updateHealth(int health){
		healthBar = health;
	}
	
	int getHealth(){
		return healthBar;
	}
}
