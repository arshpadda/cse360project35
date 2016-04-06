package cse360project;
/**
 * Basic Abstract Class that has to b inherited into the  character class
 * and implemented
 * @author Arsh Padda
 * @version Apr 6, 2016
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
	abstract getWeapon1();
	/**
	 * Abstract method that when implemented should return the attack
	 * value of Weapon2 
	 */
	abstract getWeapon2();
	/**
	 * Abstract method that when implemented should return the attack
	 * value of Weapon3
	 */
	abstract getWeapon3();
	/**
	 * Abstract method that when implemented should update the value of
	 * the  health of character
	 */
	abstract updateHealth();
	/**
	 * Abstract method that when implemented should return the value of
	 * Health of the character 
	 */
	abstract getHealth();	
}