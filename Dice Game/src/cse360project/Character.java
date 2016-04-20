package cse360project;

import javax.swing.*;

/**
 * Abstract class for implementing the character of the game
 * @author Team35
 * @version April 20, 2016
 */

public class Character {
	int healthBar = 100;
	int weapon1 = 10;
	int weapon2 = 8;
	int weapon3 = 6;
	int hero;
	
	String[] heroNames = {"Batman", "Superman", "Wonder Woman", "Flash"};

	//String array that holds weapons names 
	//[0][] = Batman, [1][] = Superman, [2][] = Wonder Woman, [3][] = Flash
	String[][] weapons = new String[][]{
			{"Bataraang","Kick","Grappling Hook"},
			{"Heat Vision","Flying Punch","Ice Breath"},
			{"Sword Slice","Lasso Grab","Shield Bash"},
			{"Sonic Punch","Lightning Kick","Quick Step"}
	};
	
	ImageIcon[] pictures = {new ImageIcon(PlayPanel.class.getResource("/cse360project/Batman1.jpg")),
			new ImageIcon(PlayPanel.class.getResource("/cse360project/Superman.jpg"))};
	
	Character(int characterSelect){
		hero = characterSelect;
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
	
	String weaponName(int weaponNum){
		return weapons[hero][weaponNum-1];
	}
	
	String heroName(){
		return heroNames[hero];
	}
	
	ImageIcon heroPic(){
		return pictures[hero];
	}
}