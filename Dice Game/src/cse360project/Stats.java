//CSE360

package cse360project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//Stats class for all characters
public class Stats
{
	/*
	stats to be tracked between sessions, 2d int array
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
	
	//stats tracked in one tournament
	private int[] tempDamageDone;
	private int[] tempDamageTaken;
	

	
	/**
	 * Constructor for Stats, reads the statistics file
	 * @param numChars number of characters to read stats  for
	 * @param numStats number of statistics to be read
	 */
	public Stats(int numChars, int numStats)
	{
		//create with the correct size
		stats = new int[numStats][numChars];
		
		//initialize numChars and numStats
		this.numChars = numChars;
		this.numStats = numStats;
		
		//file operations to open the file, inside a try block in case the file is not found
		//needs testing for cases where the file is not found, or format doesn't match expected
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
	 * Update the statistics for two characters, parameters are the attack's details
	 * @param character1 int representing one character
	 * @param character2 int representing the second character
	 * @param c1Damage damage dealt by character1, taken by character2
	 * @param c2Damage damage dealt by character2, taken by character1
	 * @param c1Health character1's health before the attack
	 * @param c2Health character2's health before the attack
	 */
	public void attackUpdate(int character1, int character2, int c1Damage, int c2Damage, int c1Health, int c2Health)
	{
		
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
		output = output + "Wins:"						 + stats[0][charInt] + "\n";
		//repeat for each stat
		output = output + "Losses:" 					 + stats[1][charInt] + "\n";
		//for now, assume draw is possible
		output = output + "Draws:"						 + stats[2][charInt] + "\n";
		output = output + "Total Turns:" 	   			 + stats[3][charInt] + "\n";
		output = output + "Damage Done:"				 + stats[4][charInt] + "\n";
		output = output + "Damage Taken:"				 + stats[5][charInt] + "\n";
		output = output + "Head Hits:"					 + stats[6][charInt] + "\n";
		output = output + "Body Hits:"					 + stats[7][charInt] + "\n";
		output = output + "Leg Hits:"		 			 + stats[8][charInt] + "\n";
		output = output + "Critical Hits:"				 + stats[9][charInt] + "\n";
		output = output + "Most Turns:"					 + stats[10][charInt] + "\n";
		
		//add temporary stats
		output = output + "Tournament Damage Dealt:"	 + tempDamageDone[charInt] + "\n";
		output = output + "Tournament Damage Taken:"	 + tempDamageDone[charInt] + "\n";
		
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