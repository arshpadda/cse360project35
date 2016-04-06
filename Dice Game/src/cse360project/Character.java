
	public abstract class Character {
	
	double healthBar;
	int weapon1;
	int weapon2;
	int weapon3;
	
	abstract getWeapon1();
	abstract getWeapon2();
	abstract getWeapon3();
	abstract updateHealth();
	abstract getHealth();
	
	}