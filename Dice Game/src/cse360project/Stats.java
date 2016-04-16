package cse360project;

/**
 * @author Team35
 * @version April 15, 2016
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//Stats class for all characters
public class Stats
{
	/*
	stats to be tracked between sessions, 2d int array.
	row index, stat:			column index, character:
	wins		 = 0			batman 		= 0
	losses		 = 1			superman 	= 1
	draws		 = 2
	
	turns		 = 3
	damageDone	 = 4
	damageTaken	 = 5
	
	hitHead		 = 6
	hitChest	 = 7
	hitLegs		 = 8
	
	criticalHits = 9
	mostTurns	 = 10
	 */
	//initialize array for persistent stats
	private int[][] stats;
	private int numChars;
	private int numStats;
	
	//stats tracked in one tournament, tournament is not implemented yet
	private int[] tempDamageDone;
	private int[] tempDamageTaken;
	
	//String array containing names of all characters
	private String[] characters;
	

	
	/**
	 * Constructor for Stats, reads the statistics file
	 * @param numChars number of characters to read stats for
	 * @param numStats number of statistics to be read
	 */
	public Stats(int numChars, int numStats)
	{
		//String array contains the names of characters
		//for now, initialize array here, rather than read from file
		characters = new String[] {"Batman","Superman"};
		
		//initialize temporary stats to 0
		tempDamageDone = new int[numChars];
		tempDamageTaken = new int[numChars];
		for(int charIndex = 0; charIndex < numChars; charIndex++)
		{
			tempDamageDone[charIndex] = 0;
			tempDamageTaken[charIndex] = 0;
		}
		
		//create with the correct size
		stats = new int[numStats][numChars];
		
		//initialize numChars and numStats
		this.numChars = numChars;
		this.numStats = numStats;
		
		//file operations to open the file, inside a try block in case the file is not found
		try
		{
			//create the File
			File file = new File("statistics.txt");
			//check the existence of the file
			if(file.exists())
			{
				//if the file exists, create a Scanner for it
				Scanner scan = new Scanner(file);
				//loop through each statistic, for each character
				for(int statIndex = 0; statIndex < numStats; statIndex++)
				{
					for(int charIndex = 0; charIndex < numChars; charIndex++)
					{
						//read the next integer into the stat array
						stats[statIndex][charIndex] = scan.nextInt();
					}
				}
				//close the Scanner
				scan.close();
			}
			else
			{
				//create the statistics file
				file.createNewFile();
				//FileWriter to write to the file
				FileWriter writer = new FileWriter(file);
				//write a 0 for every statistic, for every character
				for(int statIndex = 0; statIndex < numStats; statIndex++)
				{
					for(int charIndex = 0; charIndex < numChars; charIndex++)
					{
						//set the value to 0, and write a 0 to the file
						stats[statIndex][charIndex] = 0;
						writer.write('0');
						
						//write a space or new line
						if(charIndex < numChars-1)
							writer.write(' ');
						else
							writer.write('\n');
					}
				}
				//close the FileWriter
				writer.close();
			}
		}
		//catches might need more work
		catch(FileNotFoundException error)
		{
			error.printStackTrace();			
		} 
		catch (IOException error)
		{
			error.printStackTrace();
		}
	}
	
	/**
	 * Convert a character's name into an integer representing them
	 * @param name search for the name in the array
	 * @return the integer represent the name, also the index in the array
	 */
	int nameToInt(String name)
	{
		//search for the name in the characters array
		int nameIndex = 0;
		boolean nameFound = false;
		while(nameIndex < characters.length && !nameFound)
		{
			//compare the names
			if(name.equals(characters[nameIndex]))			
				nameFound = true;
			else			
				nameIndex++;
		}
		return nameIndex;
	}
	
	/**
	 * Update the statistics for two characters, parameters are the attack's details
	 * @param character1 int representing one character
	 * @param character2 int representing the second character
	 * @param c1Damage damage dealt by character1, taken by character2
	 * @param c2Damage damage dealt by character2, taken by character1
	 * @param c1Loc body part hit by character1 on character2, 0 = head, 1 = chest, 2 = leg
	 * @param c2Loc body part hit by character2 on character1, 0 = head, 1 = chest, 2 = leg
	 * @param c1Health character1's health before the attack
	 * @param c2Health character2's health before the attack
	 * @param c1Crit whether character1 crit, 12 = crit
	 * @param c2Crit whether character2 crit, 12 = crit
	 */
	public void attackUpdate(int character1, int character2, int c1Damage, int c2Damage, int c1Loc, int c2Loc, int c1Health, int c2Health, int c1Crit, int c2Crit)
	{
		
		//first check for the end of the fight, wins losses and draws
		//c1 loses
		if(c1Health <= c2Damage)
		{
			//c2 loses also, draw
			if(c2Health <= c1Damage)
			{
				stats[2][character1]++;
				stats[2][character2]++;
			}
			//c2 wins
			else
			{
				stats[0][character2]++;
				stats[1][character1]++;
			}
		}
		//c1 wins
		else if(c2Health <= c1Damage)
		{
			stats[0][character1]++;
			stats[1][character2]++;
		}
		
		//Next, turns damageDone tempDamageDone damageTaken and tempDamageTaken
		//turns
		stats[3][character1]++;
		stats[3][character2]++;
		
		//damageDone
		stats[4][character1] = stats[4][character1] + c1Damage;
		stats[4][character2] = stats[4][character2] + c2Damage;
		//tempDamageDone
		tempDamageDone[character1] = tempDamageDone[character1] + c1Damage;
		tempDamageDone[character2] = tempDamageDone[character2] + c2Damage;
		
		//damageTaken
		stats[5][character1] = stats[5][character1] + c2Damage;
		stats[5][character2] = stats[5][character2] + c1Damage;
		//tempDamageTaken
		tempDamageTaken[character1] = tempDamageTaken[character1] + c2Damage;
		tempDamageTaken[character2] = tempDamageTaken[character2] + c1Damage;
		
		//Next, hitHead hitChest and hitLegs
		//the location + 6 gives the right stat to increment
		stats[c1Loc + 6][character1]++;
		stats[c2Loc + 6][character2]++;
		
		//character1 critical hit
		if(c1Crit == 12)
			stats[9][character1]++;
			
		//character2 critical hit
		if(c2Crit == 12)
			stats[9][character2]++;
			
	}
	
	public void mostTurns(int character1, int character2, int turns)
	{
		if(turns > stats[10][character1])
			stats[10][character1] = turns;
		if(turns > stats[10][character2])
			stats[10][character2] = turns;
	}
	
	/**
	 * Return all of a character stats as a String to be displayed
	 * @param charInt int representing a character
	 * @return String containing all of a character's stats, formatted
	 */
	public String printChar(int charInt)
	{
		String output = "";
		
		//add first stat to the string
		output = output + "Wins:\t\t"						 + stats[0][charInt] + "\n";
		//repeat for each stat
		output = output + "Losses:\t\t" 					 + stats[1][charInt] + "\n";
		//for now, assume draw is possible
		output = output + "Draws:\t\t"						 + stats[2][charInt] + "\n";
		output = output + "Total Turns:\t\t" 	   			 + stats[3][charInt] + "\n";
		output = output + "Damage Done:\t\t"				 + stats[4][charInt] + "\n";
		output = output + "Damage Taken:\t"					 + stats[5][charInt] + "\n";
		output = output + "Head Hits:\t\t"					 + stats[6][charInt] + "\n";
		output = output + "Body Hits:\t\t"					 + stats[7][charInt] + "\n";
		output = output + "Leg Hits:\t\t"		 			 + stats[8][charInt] + "\n";
		output = output + "Critical Hits:\t\t"				 + stats[9][charInt] + "\n";
		output = output + "Most Turns:\t\t"					 + stats[10][charInt] + "\n";
		
		//add temporary stats
		//output = output + "Tournament Damage Dealt:\t"	 + tempDamageDone[charInt] + "\n";
		//output = output + "Tournament Damage Taken:\t"	 + tempDamageDone[charInt] + "\n";
		
		return output;
	}
	
	/**
	 * Reset the temporary stats when a new tournament starts
	 */
	public void resetTemp()
	{
		for(int charIndex = 0; charIndex < numChars; charIndex++)
		{
			tempDamageDone[charIndex] = 0;
			tempDamageTaken[charIndex] = 0;
		}
	}
	
	/**
	 * Rewrite the statistics file with updated information
	 */
	public void updateFile()
	{
		try
		{
			//create the File and FileWriter
			File file = new File("statistics.txt");
			FileWriter writer = new FileWriter(file);
			//delete the old statistics file
			file.delete();
			//create a new statistics file
			file.createNewFile();
			//write everything to the statistics file
			for(int statIndex = 0; statIndex < numStats; statIndex++)
			{
				for(int charIndex = 0; charIndex < numChars; charIndex++)
				{
					//put the stat into a string
					String value = stats[statIndex][charIndex] + "";
					//write the string to the file
					writer.write(value);
					
					if(charIndex < numChars-1)
						writer.write(' ');
					else
						writer.write('\n');
				}
			}
			//close the FileWriter
			writer.close();
		}
		catch (IOException error)
		{
			error.printStackTrace();
		}
	}
	
	
}
