
package cse360project;

/**
 * @author Team35
 * @version April 29, 2016
 */

import static org.junit.Assert.*;
import org.junit.Test;


public class ProjectTest {
	
	//initialize objects
	Project game = new Project();
	Character char1 = new Character(0);
	Character char2 = new Character(1);
	
	@Test
	public void testProject() {
		//test object is not null
		assertNotNull(game);
	}
	
	@Test
	public void testChar1() {
		//test object is not null
		assertNotNull(char1);
	}
	
	@Test
	public void testDice() {
		//initialize  Dice Object
		Dice die = new Dice();
		assertNotNull(die);
	}
		
	@Test
	public void testChar1Health() {
		//test to verify the health of character at the beginning of a game
		assertEquals(char1.getHealth(), 100);
	}
	
	@Test
	public void testChar1Weapon1() {
		//test the attack power of Weapon1
		assertEquals(char1.getWeapon1(), 10);
	}
	
	@Test
	public void testChar1Weapon2() {
		//test the attack power of Weapon2
		assertEquals(char1.getWeapon2(), 8);
	}

	@Test
	public void testChar1Weapon3() {
		//test the attack power of Weapon3
		assertEquals(char1.getWeapon3(), 6);
	}
	
	@Test
	public void testChar1UpdateHealth() {
		//test health updates during the game
		char1.updateHealth(75);
		assertEquals(char1.getHealth(), 75);
	}
	

}
