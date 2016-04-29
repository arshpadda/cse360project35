package cse360project;

import javax.swing.*;

/**
 * Abstract class for implementing the character of the game
 * @author Team35
 * @version April 29, 2016
 */

public class Character {
	int healthBar = 100;	// Health of the character when the battle begins	
	int weapon1 = 10;		// Attack Power of weapon 1
	int weapon2 = 8;		// Attack Power of weapon 2
	int weapon3 = 6;		// Attack Power of weapon 3
	int hero;				// hero Selector Number
	
	static String[] heroNames = {"Batman", "Superman", "Wonder Woman", "Flash", "Green Lantern", "Aquaman", "Cyborg", "Hawkman"};

	//String array that holds weapons names 
	//[0][]=Batman, [1][]=Superman, [2][]=Wonder Woman, [3][]=Flash, [4][]=Green Lantern, [5][]=Aquaman,[6][]=Cyborg,[7][]=Hawkman 
	String[][] weapons = new String[][]{
			{"Bataraang","Kick","Grappling Hook"},
			{"Heat Vision","Flying Punch","Ice Breath"},
			{"Sword Slice","Lasso Grab","Shield Bash"},
			{"Sonic Punch","Lightning Kick","Quick Step"},
			{"Energy Beam","Ring Construct","Fist Construct"},
			{"Trident Throw","Shark Attack","Whirpool"},
			{"Sonic Disruptor","Shock","Metal Fist"},
			{"Mace Swing","Heatbutt","Katar Attack"}
	};
	
	ImageIcon[] pictures = {new ImageIcon(PlayPanel.class.getResource("/cse360project/Batman1.jpg")),
			new ImageIcon(PlayPanel.class.getResource("/cse360project/Superman.jpg")),
			new ImageIcon(PlayPanel.class.getResource("/cse360project/WonderWoman.jpg")),
			new ImageIcon(PlayPanel.class.getResource("/cse360project/Flash.jpg")),
			new ImageIcon(PlayPanel.class.getResource("/cse360project/GreenLantern.jpg")),
			new ImageIcon(PlayPanel.class.getResource("/cse360project/Aquaman.jpg")),
			new ImageIcon(PlayPanel.class.getResource("/cse360project/Cyborg.jpg")),
			new ImageIcon(PlayPanel.class.getResource("/cse360project/Hawkman.jpg")),
			};		
	// Images of the SuperHero 
	
	//Constructor that determines which character you are.
	Character(int characterSelect){
		hero = characterSelect;
	}
	
	//Return the attack value of first weapon 
	int getWeapon1(){
		return weapon1;
	}
	
	//Return the attack value of second weapon
	int getWeapon2(){
		return weapon2;
	}
	
	//Return the attack value of third weapon
	int getWeapon3(){
		return weapon3;
	}
	
	// Update the health value of the health bar 
	void updateHealth(int health){
		healthBar = health;
	}
	
	// Get the health value of the health bar
	int getHealth(){
		return healthBar;
	}
	
	// Return the weapon name of the specified character 
	String weaponName(int weaponNum){
		return weapons[hero][weaponNum-1];
	}
	
	// Return the hero name
	String heroName(){
		return heroNames[hero];
	}
	
	// Return the pic of the hero selected
	ImageIcon heroPic(){
		return pictures[hero];
	}
	
	// Return the number assigned to the hero 
	int getHeroNum(){
		return hero;
	}
}