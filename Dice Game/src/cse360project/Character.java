package cse360project;

import javax.swing.*;

/**
 * Abstract class for implementing the character of the game
 * @author Team35
 * @version April 26, 2016
 */

public class Character {
	int healthBar = 100;
	int weapon1 = 10;
	int weapon2 = 8;
	int weapon3 = 6;
	int hero;
	
	//includes placeholders
	static String[] heroNames = {"Batman", "Superman", "Wonder Woman", "Flash", "5", "6", "7", "8"};

	//String array that holds weapons names 
	//[0][] = Batman, [1][] = Superman, [2][] = Wonder Woman, [3][] = Flash //\\4 are temporary placeholders//\\
	String[][] weapons = new String[][]{
			{"Bataraang","Kick","Grappling Hook"},
			{"Heat Vision","Flying Punch","Ice Breath"},
			{"Sword Slice","Lasso Grab","Shield Bash"},
			{"Sonic Punch","Lightning Kick","Quick Step"},
			{"5 1","5 2","5 3"},
			{"6 1","6 2","6 3"},
			{"7 1","7 2","7 3"},
			{"8 1","8 2","8 3"}
	};
	
	ImageIcon[] pictures = {new ImageIcon(PlayPanel.class.getResource("/cse360project/Batman1.jpg")),
			new ImageIcon(PlayPanel.class.getResource("/cse360project/Superman.jpg")),
			new ImageIcon(PlayPanel.class.getResource("/cse360project/WonderWoman.jpg")),
			new ImageIcon(PlayPanel.class.getResource("/cse360project/Flash.jpg"))};
	
	//Constructor that determines which character you are.
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