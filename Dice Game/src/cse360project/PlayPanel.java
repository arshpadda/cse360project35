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
	private final ButtonGroup buttonGroup3 = new ButtonGroup();
	private final ButtonGroup buttonGroup4 = new ButtonGroup();
	
	//Class Object
	private Superman Sup;
	private Batman Bat;
	
	private JProgressBar progressBar_Bat;
	private JProgressBar progressBar_Sup;
	
	private Label label_1;
	private Label label;
	
	private JButton btnAttack;
	
	private JRadioButton rdbtnWeapon;
	private JRadioButton rdbtnWeapon_3;
	private JRadioButton rdbtnWeapon_1;
	private JRadioButton rdbtnWeapon_4;
	private JRadioButton rdbtnWeapon_2;
	private JRadioButton rdbtnWeapon_5;
	
	private int turn;
	private Label label_2;
	private JRadioButton rdbtnHead;
	private JRadioButton rdbtnTorso;
	private JRadioButton rdbtnLeg;
	
	private Label lblSupBlock;
	private JRadioButton rdbtnHead_1;
	private JRadioButton rdbtnTorso_1;
	private JRadioButton rdbtnLeg_1;
	
	private int batDice;
	private int supDice;
	
	private Dice die;
	//Initialize the character object here
	//Constructor initializes components and organize them using certain layouts
	public PlayPanel(StatPanel sPanel)
	{
		turn = 0;
		
		this.sPanel = sPanel;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		Sup = new Superman();
		Bat = new Batman();
		
				
		progressBar_Bat = new JProgressBar();
		GridBagConstraints gbc_progressBar = new GridBagConstraints();
		gbc_progressBar.insets = new Insets(0, 0, 5, 5);
		gbc_progressBar.gridx = 0;
		gbc_progressBar.gridy = 3;
		add(progressBar_Bat, gbc_progressBar);
		//Will change according to the health of the Player 
		progressBar_Bat.setValue(Bat.getHealth());
		
		progressBar_Sup = new JProgressBar();
		GridBagConstraints gbc_progressBar_1 = new GridBagConstraints();
		gbc_progressBar_1.insets = new Insets(0, 0, 5, 0);
		gbc_progressBar_1.gridx = 7;
		gbc_progressBar_1.gridy = 3;
		add(progressBar_Sup, gbc_progressBar_1);
		//Will change according to the health of the Player
		progressBar_Sup.setValue(Sup.getHealth());
		
		label = new Label("Batman");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 4;
		add(label, gbc_label);
		
		label_1 = new Label("Superman");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 0);
		gbc_label_1.gridx = 7;
		gbc_label_1.gridy = 4;
		add(label_1, gbc_label_1);
		
		rdbtnWeapon = new JRadioButton("BatWeapon1");
		GridBagConstraints gbc_rdbtnWeapon = new GridBagConstraints();
		gbc_rdbtnWeapon.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnWeapon.gridx = 0;
		gbc_rdbtnWeapon.gridy = 5;
		add(rdbtnWeapon, gbc_rdbtnWeapon);
		
		buttonGroup1.add(rdbtnWeapon);
		
		//setActionCommand for each JRadioButton
		rdbtnWeapon.setActionCommand("1");
		
		rdbtnWeapon_3 = new JRadioButton("SupWeapon1");
		GridBagConstraints gbc_rdbtnWeapon_3 = new GridBagConstraints();
		gbc_rdbtnWeapon_3.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnWeapon_3.gridx = 7;
		gbc_rdbtnWeapon_3.gridy = 5;
		add(rdbtnWeapon_3, gbc_rdbtnWeapon_3);
		
		buttonGroup2.add(rdbtnWeapon_3);
		
		rdbtnWeapon_3.setActionCommand("1");
		
		rdbtnWeapon_1 = new JRadioButton("BatWeapon2");
		GridBagConstraints gbc_rdbtnWeapon_1 = new GridBagConstraints();
		gbc_rdbtnWeapon_1.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnWeapon_1.gridx = 0;
		gbc_rdbtnWeapon_1.gridy = 6;
		add(rdbtnWeapon_1, gbc_rdbtnWeapon_1);
		buttonGroup1.add(rdbtnWeapon_1);
		rdbtnWeapon_1.setActionCommand("2");
		
		rdbtnWeapon_4 = new JRadioButton("SupWeapon2");
		GridBagConstraints gbc_rdbtnWeapon_4 = new GridBagConstraints();
		gbc_rdbtnWeapon_4.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnWeapon_4.gridx = 7;
		gbc_rdbtnWeapon_4.gridy = 6;
		add(rdbtnWeapon_4, gbc_rdbtnWeapon_4);
		buttonGroup2.add(rdbtnWeapon_4);
		rdbtnWeapon_4.setActionCommand("2");
		
		rdbtnWeapon_2 = new JRadioButton("BatWeapon3");
		GridBagConstraints gbc_rdbtnWeapon_2 = new GridBagConstraints();
		gbc_rdbtnWeapon_2.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnWeapon_2.gridx = 0;
		gbc_rdbtnWeapon_2.gridy = 7;
		add(rdbtnWeapon_2, gbc_rdbtnWeapon_2);
		buttonGroup1.add(rdbtnWeapon_2);
		rdbtnWeapon_2.setActionCommand("3");
		
		rdbtnWeapon_5 = new JRadioButton("SupWeapon3");
		GridBagConstraints gbc_rdbtnWeapon_5 = new GridBagConstraints();
		gbc_rdbtnWeapon_5.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnWeapon_5.gridx = 7;
		gbc_rdbtnWeapon_5.gridy = 7;
		add(rdbtnWeapon_5, gbc_rdbtnWeapon_5);
		buttonGroup2.add(rdbtnWeapon_5);
		rdbtnWeapon_5.setActionCommand("3");
		
		label_2 = new Label("Bat Block");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 0;
		gbc_label_2.gridy = 9;
		add(label_2, gbc_label_2);
		
		lblSupBlock = new Label("Sup Block");
		GridBagConstraints gbc_lblSupBlock = new GridBagConstraints();
		gbc_lblSupBlock.insets = new Insets(0, 0, 5, 0);
		gbc_lblSupBlock.gridx = 7;
		gbc_lblSupBlock.gridy = 9;
		add(lblSupBlock, gbc_lblSupBlock);
		
		rdbtnHead = new JRadioButton("Head");
		GridBagConstraints gbc_rdbtnHead = new GridBagConstraints();
		gbc_rdbtnHead.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnHead.gridx = 0;
		gbc_rdbtnHead.gridy = 10;
		add(rdbtnHead, gbc_rdbtnHead);
		buttonGroup3.add(rdbtnHead);
		rdbtnHead.setActionCommand("1");
		
		rdbtnHead_1 = new JRadioButton("Head");
		GridBagConstraints gbc_rdbtnHead_1 = new GridBagConstraints();
		gbc_rdbtnHead_1.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnHead_1.gridx = 7;
		gbc_rdbtnHead_1.gridy = 10;
		add(rdbtnHead_1, gbc_rdbtnHead_1);
		buttonGroup4.add(rdbtnHead_1);
		rdbtnHead_1.setActionCommand("1");
		
		rdbtnTorso = new JRadioButton("Torso");
		GridBagConstraints gbc_rdbtnTorso = new GridBagConstraints();
		gbc_rdbtnTorso.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnTorso.gridx = 0;
		gbc_rdbtnTorso.gridy = 11;
		add(rdbtnTorso, gbc_rdbtnTorso);
		buttonGroup3.add(rdbtnTorso);
		rdbtnTorso.setActionCommand("2");
		
		rdbtnTorso_1 = new JRadioButton("Torso");
		GridBagConstraints gbc_rdbtnTorso_1 = new GridBagConstraints();
		gbc_rdbtnTorso_1.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnTorso_1.gridx = 7;
		gbc_rdbtnTorso_1.gridy = 11;
		add(rdbtnTorso_1, gbc_rdbtnTorso_1);
		buttonGroup4.add(rdbtnTorso_1);
		rdbtnTorso_1.setActionCommand("2");

		rdbtnLeg = new JRadioButton("Leg");
		GridBagConstraints gbc_rdbtnLeg = new GridBagConstraints();
		gbc_rdbtnLeg.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnLeg.gridx = 0;
		gbc_rdbtnLeg.gridy = 12;
		add(rdbtnLeg, gbc_rdbtnLeg);
		buttonGroup3.add(rdbtnLeg);
		rdbtnLeg.setActionCommand("3");
		
		rdbtnLeg_1 = new JRadioButton("Leg");
		GridBagConstraints gbc_rdbtnLeg_1 = new GridBagConstraints();
		gbc_rdbtnLeg_1.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnLeg_1.gridx = 7;
		gbc_rdbtnLeg_1.gridy = 12;
		add(rdbtnLeg_1, gbc_rdbtnLeg_1);
		buttonGroup4.add(rdbtnLeg_1);
		rdbtnLeg_1.setActionCommand("3");

		btnAttack = new JButton("Attack");
		GridBagConstraints gbc_btnAttack = new GridBagConstraints();
		gbc_btnAttack.insets = new Insets(0, 0, 0, 5);
		gbc_btnAttack.gridx = 4;
		gbc_btnAttack.gridy = 14;
		add(btnAttack, gbc_btnAttack);
		
		die = new Dice();  

		
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
			if(source == btnAttack && progressBar_Bat.getValue() > 0 && progressBar_Sup.getValue() > 0)
			{
				//String selectedRadioButtonText = getSelectedRadioButton(buttonGroup1).getText();
				//increment turn counter
				turn++;
				
				//getActionCommand to get a string for the weapon, parseInt to convert to int
				int batmanWeapon = Integer.parseInt(buttonGroup1.getSelection().getActionCommand());
				int supermanWeapon = Integer.parseInt(buttonGroup2.getSelection().getActionCommand());
				//Call the Dice to have a body part attack
				
				int batAttack;
				int supAttack;
				
				//Get Batman Weapon Choice 
				if (batmanWeapon == 1){
					batAttack = Bat.getWeapon1();
				}
				else if (batmanWeapon == 2){
					batAttack = Bat.getWeapon2();
				}
				else{
					batAttack = Bat.getWeapon3();
				}
				
				batDice = die.getDie1();
				System.out.println(batDice);
				//Get Superman Weapon Choice
				if (supermanWeapon == 1){
					supAttack = Sup.getWeapon1();
				}
				else if (supermanWeapon == 2){
					supAttack = Sup.getWeapon2();
				}
				else{
					supAttack = Sup.getWeapon3();
				}
				
				supDice = die.getDie1();
				System.out.println(supDice + "\n");
				
				int supHealth = Sup.getHealth() - batAttack;
				int batHealth = Bat.getHealth() - supAttack;
				
				//use if condition to check health and declare a winner if any. 
				Sup.updateHealth(supHealth);
				Bat.updateHealth(batHealth);
				
				progressBar_Bat.setValue(batHealth);
				progressBar_Sup.setValue(supHealth);
				
				//call sPanel.updateStats() around here
				
				
				if(batHealth <= 0 || supHealth <= 0)
				{
					Sup.updateHealth(100);
					Bat.updateHealth(100);
					sPanel.updateMostTurns(0,1,turn);
				}
			
			}
			else
			{
				progressBar_Bat.setValue(100);
				progressBar_Sup.setValue(100);
			}
		}
	} 
}
