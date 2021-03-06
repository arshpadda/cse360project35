package cse360project;

/**
 * @author Team35
 * @version April 29, 2016
 */

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

import java.util.*;
/**
 * Panel is a tab on the applet that shows the information of the Stats.
 * @author Team35
 *
 */
public class StatPanel extends JPanel
{
	//stats object to contain and update stats.
	private Stats stats;
	private GridBagLayout gridBagLayout;
	
	//selects the character
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	
	private Component rigidArea;
	
	//contains each character's stats
	private JTextArea textArea;
	private JTextArea textArea_1;
	
	//unused button
	//private JButton button;
	
	//Constructor initializes each component and arrange them using layouts
	public StatPanel(int numChars, int numStats)
	{
		//stats object containing the stats information to be displayed
		stats = new Stats(numChars, numStats);
		
		//girdBagLayout is the layout used for the panel
		gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 0.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		//set the layout for the StatPanel
		setLayout(gridBagLayout);
		
		//left comboBox, contains hero choices for stats to be displayed
		comboBox = new JComboBox();
		comboBox.setBackground(Color.LIGHT_GRAY);
		comboBox.setModel(new DefaultComboBoxModel(Character.heroNames));
		comboBox.setSelectedIndex(0);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.anchor = GridBagConstraints.SOUTH;
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 1;
		add(comboBox, gbc_comboBox);
		
		//listeners for the left JComboBox
		comboBox.addActionListener(new ComboListener());
		
		//right JComboBox, same function as the left
		comboBox_1 = new JComboBox();
		comboBox_1.setBackground(Color.LIGHT_GRAY);
		comboBox_1.setModel(new DefaultComboBoxModel(Character.heroNames));
		comboBox_1.setSelectedIndex(1);
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.anchor = GridBagConstraints.SOUTH;
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 6;
		gbc_comboBox_1.gridy = 1;
		add(comboBox_1, gbc_comboBox_1);
		comboBox_1.addActionListener(new ComboListener());
		
		//rigidArea just to create some space
		rigidArea = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea = new GridBagConstraints();
		gbc_rigidArea.insets = new Insets(0, 0, 5, 5);
		gbc_rigidArea.gridx = 2;
		gbc_rigidArea.gridy = 2;
		add(rigidArea, gbc_rigidArea);
		
		//left text area, contains information about the hero chosen by the left JComboBox
		textArea = new JTextArea();
		textArea.setBackground(UIManager.getColor("Button.background"));
		textArea.setEditable(false);
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.gridheight = 2;
		gbc_textArea.insets = new Insets(0, 0, 5, 5);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 2;
		gbc_textArea.gridy = 3;
		add(textArea, gbc_textArea);
		
		//set the text to the default, information about batman
		textArea.setText(stats.printChar(0));
		
		/*
		 * Button not used currently
		button = new JButton("Test");
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 5;
		gbc_button.gridy = 4;
		add(button, gbc_button);
		*/
		
		//right text area, same function as the left text area
		textArea_1 = new JTextArea();
		textArea_1.setBackground(UIManager.getColor("Button.background"));
		textArea_1.setEditable(false);
		GridBagConstraints gbc_textArea_1 = new GridBagConstraints();
		gbc_textArea_1.gridheight = 2;
		gbc_textArea_1.insets = new Insets(0, 0, 5, 5);
		gbc_textArea_1.fill = GridBagConstraints.BOTH;
		gbc_textArea_1.gridx = 6;
		gbc_textArea_1.gridy = 3;
		add(textArea_1, gbc_textArea_1);
		//set the text to the default, information about superman
		textArea_1.setText(stats.printChar(1));
		
		//listener for button
		//button.addActionListener(new ButtonListener());
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
	public void updateStats(int character1, int character2, int c1Damage, int c2Damage, int c1Loc, int c2Loc, int c1Health, int c2Health, int c1Crit, int c2Crit)
	{
		//Directly pass the arguments to stats.attackUpdate()
		stats.attackUpdate(character1, character2, c1Damage, c2Damage, c1Loc, c2Loc, c1Health, c2Health, c1Crit, c2Crit);
		
		//change the displayed stats
		updateDisplay();
	}
	
	/**
	 * Called when a new tournament starts, resets temporary stats
	 */
	public void resetTemp()
	{
		//call method on the stats object
		stats.resetTemp();
	}
	
	/**
	 * Call at the end of each match, with total turns and the int for each character
	 * @param character1 integer representing first character
	 * @param character2 integer representing second character
	 * @param turns total turns taken in this match
	 */
	public void updateMostTurns(int character1, int character2, int turns)
	{
		//pass arguments to the stats class
		stats.mostTurns(character1, character2, turns);
		
		//change the displayed stats
		updateDisplay();
	}
	
	/**
	 * Call internally to update both text areas
	 */
	private void updateDisplay()
	{
		//refresh the information in the text areas with calls from the stats object
		textArea.setText(stats.printChar(stats.nameToInt((String)comboBox.getSelectedItem())));
		textArea_1.setText(stats.printChar(stats.nameToInt((String)comboBox_1.getSelectedItem())));
	}
	
	
	/**
	 * Update the statisitics.txt
	 */
	public void writeStats()
	{
		//call the stats class's method
		stats.updateFile();
	}
	
	
	private class ComboListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			//checks which comboBox caused the event
			JComboBox source = (JComboBox)event.getSource();
			if(source == comboBox)
			{
				textArea.setText(stats.printChar(stats.nameToInt((String)source.getSelectedItem())));
			}
			else if(source == comboBox_1)
			{
				textArea_1.setText(stats.printChar(stats.nameToInt((String)source.getSelectedItem())));
			}
			
		}
	}
	
	/*In case a button is used here ever
	 * private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			//checks that submit button caused event
			JButton source = (JButton)event.getSource();
			if(source == button)
			{
			}	
		}
	}
	*/
}
