package cse360project;

/**
 * @author Team35
 * @version April 15, 2016
 */
import static org.junit.Assert.*;

import org.junit.Test;

public class ProjectTest {
	
	Project game = new Project();
	Batman batTest = new Batman();
	Superman superTest = new Superman();

	@Test
	public void testBatman() {
		
		//Test health and weapons
		assertEquals(batTest.getHealth(), 100);
		assertEquals(batTest.getWeapon1(), 10);
		assertEquals(batTest.getWeapon1(), 8);
		assertEquals(batTest.getWeapon1(), 5);
		
		//Test health updating
		batTest.updateHealth(75);
		assertEquals(batTest.getHealth(), 75);
		batTest.updateHealth(50);
		assertEquals(batTest.getHealth(), 50);
		batTest.updateHealth(100);
		assertEquals(batTest.getHealth(), 100);
	}
	
	@Test
	public void testSuperman() {
		
		//Test health and weapons
		assertEquals(superTest.getHealth(), 100);
		assertEquals(superTest.getWeapon1(), 10);
		assertEquals(superTest.getWeapon1(), 8);
		assertEquals(superTest.getWeapon1(), 5);
		
		//Test health updating
		superTest.updateHealth(75);
		assertEquals(superTest.getHealth(), 75);
		superTest.updateHealth(50);
		assertEquals(superTest.getHealth(), 50);
		superTest.updateHealth(100);
		assertEquals(superTest.getHealth(), 100);
	}

}
