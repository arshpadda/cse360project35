package cse360project;

/**
 * @author Team35
 * @version April 15, 2016
 */

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

public class StatsTest
{

	@Test
	public void testStats()
	{
		//initialize the object
		Stats stats = new Stats(2,11);
		assertNotNull(stats);
		
		//check file existence
		File file = new File("statistics.txt");	
		assertEquals(true, file.exists());
	}

	@Test
	public void testNameToInt()
	{
		//initialize the object
		Stats stats = new Stats(2,11);
		
		assertEquals(0, stats.nameToInt("Batman"), 0);
		assertEquals(0, stats.nameToInt("Superman"), 1);
	}

	@Test
	public void testAttackUpdate()
	{
		//initialize the object
		Stats stats = new Stats(2,11);
		
		//call the method
		//Batman wins, dealing 10 damage in a critical hit to the torso, and taking 5 damage.
		stats.attackUpdate(0, 1, 10, 5, 1, 0, 11, 5, 12, 0);
		
		//check the effect on the statistics
		assertEquals("Wins:		1\nLosses:		0\nDraws:		0\nTotal Turns:		1\nDamage Done:		10\nDamage Taken:	5\nHead Hits:		0\nBody Hits:		1\nLeg Hits:		0\nCritical Hits:		1\nMost Turns:		0\n", stats.printChar(0));
	}

	@Test
	public void testMostTurns()
	{
		//initialize the object
		Stats stats = new Stats(2,11);
		
		//call method
		stats.mostTurns(0, 1, 10);
		
		//check the effect on the most turns statistic
		assertEquals(stats.printChar(0), "Wins:		0\nLosses:		0\nDraws:		0\nTotal Turns:		0\nDamage Done:		0\nDamage Taken:	0\nHead Hits:		0\nBody Hits:		0\nLeg Hits:		0\nCritical Hits:		0\nMost Turns:		10\n");
	}


	@Test
	public void testUpdateFile()
	{
		//initialize the object
		Stats stats = new Stats(2,11);
		
		//create a file object for the statistics
		File file = new File("statistics.txt");
		
		//check that the file exists
		assertEquals(true, file.exists());
		
		//save length before writing
		long oldLength = file.length();
		
		//call writeStats()
		stats.updateFile();
		
		//check existence
		assertEquals(true, file.exists());
		
		//check that the length is the same, there was no change in the stats so the size should be the same
		assertEquals(oldLength, file.length());
	}

}
