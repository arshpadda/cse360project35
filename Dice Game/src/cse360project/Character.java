package cse360project;

/**
 * Abstract class for implementing the character of the game
 * @author Team35
 * @version April 15, 2016
 */

public class Character {
	int healthBar = 100;
	int weapon1 = 10;
	int weapon2 = 8;
	int weapon3 = 6;
	
	//String array that holds weapons names 
	//[0][] = Batman, [1][] = Superman, [2][] = Wonder Woman, [3][] = Flash
	String[][] weapons = new String[][]{
			{"Bataraang","Kick","Grappling Hook"},
			{"Heat Vision","Flying Punch","Ice Breath"},
			{"Sword Slice","Lasso Grab","Shield Bash"},
			{"Sonic Punch","Lightning Kick","Quick Step"}
	};
	
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
	
	String weaponName(int hero, int weaponNum){
		return weapons[hero][weaponNum];
	}
}