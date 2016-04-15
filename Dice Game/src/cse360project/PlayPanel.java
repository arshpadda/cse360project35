package cse360project;

/**
 * @author Team35
 * @version April 15, 2016
 */


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;


public class PlayPanel extends JPanel
{
	private JButton button1;
	private StatPanel sPanel;
	private final ButtonGroup buttonGroup1 = new ButtonGroup();
	private final ButtonGroup buttonGroup2 = new ButtonGroup();
	//Class Object
	private Superman Sup;
	private Batman Bat;
	
	private JProgressBar progressBar;
	private JProgressBar progressBar_1;
	
	private Label label_1;
	private Label label;
	
	private JButton btnAttack;
	
	private JRadioButton rdbtnWeapon;
	private JRadioButton rdbtnWeapon_3;
	private JRadioButton rdbtnWeapon_1;
	private JRadioButton rdbtnWeapon_4;
	private JRadioButton rdbtnWeapon_2;
	private JRadioButton rdbtnWeapon_5;
	//Initialize the character object here
	//Constructor initializes components and organize them using certain layouts
	public PlayPanel(StatPanel sPanel)
	{
		this.sPanel = sPanel;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		Sup = new Superman();
		Bat = new Batman();
		
		progressBar = new JProgressBar();
		GridBagConstraints gbc_progressBar = new GridBagConstraints();
		gbc_progressBar.insets = new Insets(0, 0, 5, 5);
		gbc_progressBar.gridx = 0;
		gbc_progressBar.gridy = 1;
		add(progressBar, gbc_progressBar);
		//Will change according to the health of the Player 
		progressBar.setValue(Bat.getHealth());
		
		progressBar_1 = new JProgressBar();
		GridBagConstraints gbc_progressBar_1 = new GridBagConstraints();
		gbc_progressBar_1.insets = new Insets(0, 0, 5, 0);
		gbc_progressBar_1.gridx = 7;
		gbc_progressBar_1.gridy = 1;
		add(progressBar_1, gbc_progressBar_1);
		//Will change according to the health of the Player
		progressBar_1.setValue(Sup.getHealth());
		
		label = new Label("Batman");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 2;
		add(label, gbc_label);
		
		label_1 = new Label("Superman");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 0);
		gbc_label_1.gridx = 7;
		gbc_label_1.gridy = 2;
		add(label_1, gbc_label_1);
		
		rdbtnWeapon = new JRadioButton("BatWeapon1");
		GridBagConstraints gbc_rdbtnWeapon = new GridBagConstraints();
		gbc_rdbtnWeapon.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnWeapon.gridx = 0;
		gbc_rdbtnWeapon.gridy = 3;
		add(rdbtnWeapon, gbc_rdbtnWeapon);
		
		rdbtnWeapon_3 = new JRadioButton("SupWeapon1");
		GridBagConstraints gbc_rdbtnWeapon_3 = new GridBagConstraints();
		gbc_rdbtnWeapon_3.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnWeapon_3.gridx = 7;
		gbc_rdbtnWeapon_3.gridy = 3;
		add(rdbtnWeapon_3, gbc_rdbtnWeapon_3);
		
		rdbtnWeapon_1 = new JRadioButton("BatWeapon2");
		GridBagConstraints gbc_rdbtnWeapon_1 = new GridBagConstraints();
		gbc_rdbtnWeapon_1.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnWeapon_1.gridx = 0;
		gbc_rdbtnWeapon_1.gridy = 4;
		add(rdbtnWeapon_1, gbc_rdbtnWeapon_1);
		
		rdbtnWeapon_4 = new JRadioButton("SupWeapon2");
		GridBagConstraints gbc_rdbtnWeapon_4 = new GridBagConstraints();
		gbc_rdbtnWeapon_4.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnWeapon_4.gridx = 7;
		gbc_rdbtnWeapon_4.gridy = 4;
		add(rdbtnWeapon_4, gbc_rdbtnWeapon_4);
		
		rdbtnWeapon_2 = new JRadioButton("BatWeapon3");
		GridBagConstraints gbc_rdbtnWeapon_2 = new GridBagConstraints();
		gbc_rdbtnWeapon_2.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnWeapon_2.gridx = 0;
		gbc_rdbtnWeapon_2.gridy = 5;
		add(rdbtnWeapon_2, gbc_rdbtnWeapon_2);
		
		rdbtnWeapon_5 = new JRadioButton("SupWeapon3");
		GridBagConstraints gbc_rdbtnWeapon_5 = new GridBagConstraints();
		gbc_rdbtnWeapon_5.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnWeapon_5.gridx = 7;
		gbc_rdbtnWeapon_5.gridy = 5;
		add(rdbtnWeapon_5, gbc_rdbtnWeapon_5);
		
		btnAttack = new JButton("Attack");
		GridBagConstraints gbc_btnAttack = new GridBagConstraints();
		gbc_btnAttack.insets = new Insets(0, 0, 0, 5);
		gbc_btnAttack.gridx = 4;
		gbc_btnAttack.gridy = 8;
		add(btnAttack, gbc_btnAttack);
		
		buttonGroup1.add(rdbtnWeapon);
		buttonGroup1.add(rdbtnWeapon_1);
		buttonGroup1.add(rdbtnWeapon_2);
		
		buttonGroup2.add(rdbtnWeapon_3);
		buttonGroup2.add(rdbtnWeapon_4);
		buttonGroup2.add(rdbtnWeapon_5);
		
		//setActionCommand for each JRadioButton
		rdbtnWeapon.setActionCommand("1");
		rdbtnWeapon_1.setActionCommand("2");
		rdbtnWeapon_2.setActionCommand("3");
		
		rdbtnWeapon_3.setActionCommand("1");
		rdbtnWeapon_4.setActionCommand("2");
		rdbtnWeapon_5.setActionCommand("3");

		
		//listener for the button
	    btnAttack.addActionListener(new ButtonListener());
	}

 
	//ButtonListener is a listener class that listens to the attack button
	//Implement the class object of the two character here
	private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			//checks the source of the event is the button being pressed
			Object source = event.getSource();
			if(source == btnAttack)
			{
				//String selectedRadioButtonText = getSelectedRadioButton(buttonGroup1).getText();
				
				//getActionCommand to get a string for the weapon, parseInt to convert to int
				int batmanWeapon = Integer.parseInt(buttonGroup1.getSelection().getActionCommand());
				int supermanWeapon = Integer.parseInt(buttonGroup2.getSelection().getActionCommand());
				
				
			}
		}
	} 
}
