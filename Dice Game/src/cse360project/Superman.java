/**
 * 
 * @author Arsh Padda
 * @version Apr 9, 2016
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
	
	void updateHealth(double health){
		healthBar = health;
	}
	
	double getHealth(){
		return healthBar;
	}
}
