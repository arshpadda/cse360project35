//CSE360

package cse360project;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

public class StatPanel extends JPanel
{
	//stats object to contain and update stats
	Stats stats;
	GridBagLayout gridBagLayout;
	
	//selects the character
	JComboBox comboBox;
	JComboBox comboBox_1;
	
	Component rigidArea;
	
	//contains each character's stats
	JTextArea textArea;
	JTextArea textArea_1;
	
	//Constructor initializes each component and arrange them using layouts
	public StatPanel(int numChars, int numStats)
	{
		//
		stats = new Stats(numChars, numStats);
		
		gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		comboBox = new JComboBox();
		comboBox.setBackground(Color.LIGHT_GRAY);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Batman", "Superman"}));
		comboBox.setSelectedIndex(0);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.anchor = GridBagConstraints.SOUTH;
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 0;
		add(comboBox, gbc_comboBox);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBackground(Color.LIGHT_GRAY);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Batman", "Superman"}));
		comboBox_1.setSelectedIndex(1);
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.anchor = GridBagConstraints.SOUTH;
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 5;
		gbc_comboBox_1.gridy = 0;
		add(comboBox_1, gbc_comboBox_1);
		
		rigidArea = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea = new GridBagConstraints();
		gbc_rigidArea.insets = new Insets(0, 0, 5, 5);
		gbc_rigidArea.gridx = 1;
		gbc_rigidArea.gridy = 1;
		add(rigidArea, gbc_rigidArea);
		
		textArea = new JTextArea();
		textArea.setBackground(UIManager.getColor("Button.background"));
		textArea.setEditable(false);
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.gridheight = 2;
		gbc_textArea.insets = new Insets(0, 0, 5, 5);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 1;
		gbc_textArea.gridy = 2;
		add(textArea, gbc_textArea);
		
		textArea_1 = new JTextArea();
		textArea_1.setBackground(UIManager.getColor("Button.background"));
		textArea_1.setEditable(false);
		GridBagConstraints gbc_textArea_1 = new GridBagConstraints();
		gbc_textArea_1.gridheight = 2;
		gbc_textArea_1.insets = new Insets(0, 0, 5, 5);
		gbc_textArea_1.fill = GridBagConstraints.BOTH;
		gbc_textArea_1.gridx = 5;
		gbc_textArea_1.gridy = 2;
		add(textArea_1, gbc_textArea_1);
		
		textArea.setText(stats.printChar(0));
		textArea_1.setText(stats.printChar(1));

		//listeners for the JComboBoxes
		comboBox.addActionListener(new ComboListener());
		comboBox.addActionListener(new ComboListener());
	}	

	
	/**
	 * Update the statistics for two characters, parameters are the attack's details
	 * @param character1 int representing one character
	 * @param character2 int representing the second character
	 * @param c1Damage damage dealt by character1, taken by character2
	 * @param c2Damage damage dealt by character2, taken by character1
	 * @param c1Loc body part hit by character1 on character2
	 * @param c2Loc body part hit by character2 on character1
	 * @param c1Health character1's health before the attack
	 * @param c2Health character2's health before the attack
	 */
	public void updateStats(int character1, int character2, int c1Damage, int c2Damage, int c1Loc, int c2Loc, int c1Health, int c2Health)
	{
		//Directly pass the arguments to stats.attackUpdate()
		stats.attackUpdate(character1, character2, c1Damage, c2Damage, c1Loc, c2Loc, c1Health, c2Health);
	}

	
	private class ComboListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			//checks that submit button caused event
			JComboBox source = (JComboBox)event.getSource();
			if(source == comboBox)
			{
				textArea.setText(stats.printChar(stats.nameToInt((String)source.getSelectedItem())));
			}
			else if (source == comboBox_1)
			{
				textArea_1.setText(stats.printChar(stats.nameToInt((String)source.getSelectedItem())));
			}
			
		}
	}
}
