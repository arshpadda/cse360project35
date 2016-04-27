package cse360project;

import javax.swing.*;

/**
 * Abstract class for implementing the character of the game
 * @author Team35
 * @version April 27, 2016
 */

public class Character {
	int healthBar = 100;
	int weapon1 = 10;
	int weapon2 = 8;
	int weapon3 = 6;
	int hero;
	
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
	
	int getHeroNum(){
		return hero;
	}
}