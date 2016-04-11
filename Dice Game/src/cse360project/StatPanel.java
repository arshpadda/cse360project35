//CSE360

package cse360project;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

public class StatPanel extends JPanel
{
	
	
	//Constructor initializes each component and arrange them using layouts
	public StatPanel(int numChars, int numStats)
	{
		Stats stats = new Stats(numChars, numStats);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JComboBox comboBox = new JComboBox();
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
		
		JComboBox comboBox_1 = new JComboBox();
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
		
		Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea = new GridBagConstraints();
		gbc_rigidArea.insets = new Insets(0, 0, 5, 5);
		gbc_rigidArea.gridx = 1;
		gbc_rigidArea.gridy = 1;
		add(rigidArea, gbc_rigidArea);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(UIManager.getColor("Button.background"));
		textArea.setEditable(false);
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.gridheight = 2;
		gbc_textArea.insets = new Insets(0, 0, 5, 5);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 1;
		gbc_textArea.gridy = 2;
		add(textArea, gbc_textArea);
		
		JTextArea textArea_1 = new JTextArea();
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

		
	}	

	
	public void updateStats()
	{
		
	}

	
	private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			//checks that submit button caused event
			Object source = event.getSource();
			
		}
	}
}
