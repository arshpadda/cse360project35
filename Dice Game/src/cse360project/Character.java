package cse360project;
/**
 * Basic Abstract Class that has to b inherited into the  character class
 * and implemented
 * @author Arsh Padda
 * @version Apr 6,2016
 */
public abstract class Character {
	int healthBar;
	int weapon1;
	int weapon2;
	int weapon3;
	
	/**
	 * Abstract method that when implemented should return the attack
	 * value of Weapon1  
	 */
	abstract int getWeapon1();
	/**
	 * Abstract method that when implemented should return the attack
	 * value of Weapon2 
	 */
	abstract int getWeapon2();
	/**
	 * Abstract method that when implemented should return the attack
	 * value of Weapon3
	 */
	abstract int getWeapon3();
	/**
	 * Abstract method that when implemented should update the value of
	 * the Health of character
	 */
	abstract void updateHealth(int health);
	/**
	 * Abstract method that when implemented should return the value of
	 * Health of the character 
	 */
	abstract int getHealth();	
}