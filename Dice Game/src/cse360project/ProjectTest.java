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
	public void testBatmanHealth() {
	
		//Test health
		assertEquals(batTest.getHealth(), 100);
	}
	
	@Test
	public void testBatmanWeapon1() {
		assertEquals(batTest.getWeapon1(), 10);
	}
	
	@Test
	public void testBatmanWeapon2() {
		assertEquals(batTest.getWeapon2(), 8);
	}

	@Test
	public void testBatmanWeapon3() {
		assertEquals(batTest.getWeapon3(), 6);
	}
	
	@Test
	public void testBatmanUpdateHealth() {
		batTest.updateHealth(75);
		assertEquals(batTest.getHealth(), 75);
	}
	
	
	@Test
	public void testSupermanHealth() {
	
		//Test health
		assertEquals(superTest.getHealth(), 100);
	}
	
	@Test
	public void testSupermanWeapon1() {
		assertEquals(superTest.getWeapon1(), 10);
	}
	
	@Test
	public void testSUpermanWeapon2() {
		assertEquals(batTest.getWeapon2(), 8);
	}

	@Test
	public void testSupermanWeapon3() {
		assertEquals(superTest.getWeapon3(), 6);
	}
	
	@Test
	public void testSupermanUpdateHealth() {
		batTest.updateHealth(75);
		assertEquals(superTest.getHealth(), 75);
	}
}
