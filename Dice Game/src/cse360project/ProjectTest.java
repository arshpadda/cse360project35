package cse360project;

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
		
	}

}
