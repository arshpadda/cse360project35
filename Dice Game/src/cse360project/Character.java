package cse360project;

/**
 * @author Team35
 * @version April 15, 2016
 */

public abstract class Character {
	double healthBar;
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
	abstract void updateHealth(double health);
	/**
	 * Abstract method that when implemented should return the value of
	 * Health of the character 
	 */
	abstract double getHealth();	
}