package cse360project;

/**
 * @author Team35
 * @version April 29, 2016
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
	}
	
	@Test
	public void testStatsFile()
	{
		//check file existence
		Stats stats = new Stats(2,11);
		File file = new File("statistics.txt");	
		assertEquals(true, file.exists());
	}

	@Test
	public void testNameToInt()
	{
		//initialize the object
		Stats stats = new Stats(2,11);
		assertEquals(0, stats.nameToInt("Batman"), 0);

	}


	@Test
	public void testUpdateFile()
	{
		//initialize the object
		Stats stats = new Stats(2,11);
		
		//create a file object for the statistics
		File file = new File("statistics.txt");
		
		//save length before writing
		long oldLength = file.length();
		
		//call writeStats()
		stats.updateFile();

		//check that the length is the same, there was no change in the stats so the size should be the same
		assertEquals(oldLength, file.length());
	}

}
