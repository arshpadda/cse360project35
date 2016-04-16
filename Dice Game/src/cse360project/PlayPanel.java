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
	
	private int batAttackDice;
	
	private Dice die;
	private JLabel lblNewLabel;
	//Initialize the character object here
	//Constructor initializes components and organize them using certain layouts
	public PlayPanel(StatPanel sPanel)
	{
		turn = 0;
		
		this.sPanel = sPanel;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 32, 28, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		Sup = new Superman();
		Bat = new Batman();
		
		lblNewLabel = new JLabel("");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 2;
		add(lblNewLabel, gbc_lblNewLabel);
		
				
		progressBar_Bat = new JProgressBar();
		GridBagConstraints gbc_progressBar = new GridBagConstraints();
		gbc_progressBar.fill = GridBagConstraints.HORIZONTAL;
		gbc_progressBar.insets = new Insets(0, 0, 5, 5);
		gbc_progressBar.gridx = 1;
		gbc_progressBar.gridy = 2;
		add(progressBar_Bat, gbc_progressBar);
		//Will change according to the health of the Player 
		progressBar_Bat.setValue(Bat.getHealth());
		
		progressBar_Sup = new JProgressBar();
		GridBagConstraints gbc_progressBar_1 = new GridBagConstraints();
		gbc_progressBar_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_progressBar_1.insets = new Insets(0, 0, 5, 5);
		gbc_progressBar_1.gridx = 3;
		gbc_progressBar_1.gridy = 2;
		add(progressBar_Sup, gbc_progressBar_1);
		//Will change according to the health of the Player
		progressBar_Sup.setValue(Sup.getHealth());
		
		label = new Label("Batman");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 3;
		add(label, gbc_label);
		
		label_1 = new Label("Superman");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 3;
		gbc_label_1.gridy = 3;
		add(label_1, gbc_label_1);
		
		rdbtnWeapon = new JRadioButton("Weapon 1 (10 attack, head)");
		GridBagConstraints gbc_rdbtnWeapon = new GridBagConstraints();
		gbc_rdbtnWeapon.anchor = GridBagConstraints.WEST;
		gbc_rdbtnWeapon.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnWeapon.gridx = 1;
		gbc_rdbtnWeapon.gridy = 4;
		add(rdbtnWeapon, gbc_rdbtnWeapon);
		
		buttonGroup1.add(rdbtnWeapon);
		
		//setActionCommand for each JRadioButton
		rdbtnWeapon.setActionCommand("1");
		
		rdbtnWeapon_3 = new JRadioButton("Weapon 1 (10 attack, head)");
		GridBagConstraints gbc_rdbtnWeapon_3 = new GridBagConstraints();
		gbc_rdbtnWeapon_3.anchor = GridBagConstraints.WEST;
		gbc_rdbtnWeapon_3.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnWeapon_3.gridx = 3;
		gbc_rdbtnWeapon_3.gridy = 4;
		add(rdbtnWeapon_3, gbc_rdbtnWeapon_3);
		
		buttonGroup2.add(rdbtnWeapon_3);
		
		rdbtnWeapon_3.setActionCommand("1");
		
		rdbtnWeapon_1 = new JRadioButton("Weapon 2 (8 attack, torso)");
		GridBagConstraints gbc_rdbtnWeapon_1 = new GridBagConstraints();
		gbc_rdbtnWeapon_1.anchor = GridBagConstraints.WEST;
		gbc_rdbtnWeapon_1.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnWeapon_1.gridx = 1;
		gbc_rdbtnWeapon_1.gridy = 5;
		add(rdbtnWeapon_1, gbc_rdbtnWeapon_1);
		buttonGroup1.add(rdbtnWeapon_1);
		rdbtnWeapon_1.setActionCommand("2");
		
		rdbtnWeapon_4 = new JRadioButton("Weapon 2 (8 attack, torso)");
		GridBagConstraints gbc_rdbtnWeapon_4 = new GridBagConstraints();
		gbc_rdbtnWeapon_4.anchor = GridBagConstraints.WEST;
		gbc_rdbtnWeapon_4.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnWeapon_4.gridx = 3;
		gbc_rdbtnWeapon_4.gridy = 5;
		add(rdbtnWeapon_4, gbc_rdbtnWeapon_4);
		buttonGroup2.add(rdbtnWeapon_4);
		rdbtnWeapon_4.setActionCommand("2");
		
		rdbtnWeapon_2 = new JRadioButton("Weapon 3 (6 attack, legs)");
		GridBagConstraints gbc_rdbtnWeapon_2 = new GridBagConstraints();
		gbc_rdbtnWeapon_2.anchor = GridBagConstraints.WEST;
		gbc_rdbtnWeapon_2.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnWeapon_2.gridx = 1;
		gbc_rdbtnWeapon_2.gridy = 6;
		add(rdbtnWeapon_2, gbc_rdbtnWeapon_2);
		buttonGroup1.add(rdbtnWeapon_2);
		rdbtnWeapon_2.setActionCommand("3");
		
		rdbtnWeapon_5 = new JRadioButton("Weapon 3 (6 attack, legs)");
		GridBagConstraints gbc_rdbtnWeapon_5 = new GridBagConstraints();
		gbc_rdbtnWeapon_5.anchor = GridBagConstraints.WEST;
		gbc_rdbtnWeapon_5.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnWeapon_5.gridx = 3;
		gbc_rdbtnWeapon_5.gridy = 6;
		add(rdbtnWeapon_5, gbc_rdbtnWeapon_5);
		buttonGroup2.add(rdbtnWeapon_5);
		rdbtnWeapon_5.setActionCommand("3");
		
		label_2 = new Label("Bat Block");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 1;
		gbc_label_2.gridy = 8;
		add(label_2, gbc_label_2);
		
		lblSupBlock = new Label("Sup Block");
		GridBagConstraints gbc_lblSupBlock = new GridBagConstraints();
		gbc_lblSupBlock.insets = new Insets(0, 0, 5, 5);
		gbc_lblSupBlock.gridx = 3;
		gbc_lblSupBlock.gridy = 8;
		add(lblSupBlock, gbc_lblSupBlock);
		
		rdbtnHead = new JRadioButton("Head");
		GridBagConstraints gbc_rdbtnHead = new GridBagConstraints();
		gbc_rdbtnHead.anchor = GridBagConstraints.WEST;
		gbc_rdbtnHead.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnHead.gridx = 1;
		gbc_rdbtnHead.gridy = 9;
		add(rdbtnHead, gbc_rdbtnHead);
		buttonGroup3.add(rdbtnHead);
		rdbtnHead.setActionCommand("1");
		
		rdbtnHead_1 = new JRadioButton("Head");
		GridBagConstraints gbc_rdbtnHead_1 = new GridBagConstraints();
		gbc_rdbtnHead_1.anchor = GridBagConstraints.WEST;
		gbc_rdbtnHead_1.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnHead_1.gridx = 3;
		gbc_rdbtnHead_1.gridy = 9;
		add(rdbtnHead_1, gbc_rdbtnHead_1);
		buttonGroup4.add(rdbtnHead_1);
		rdbtnHead_1.setActionCommand("1");
		
		rdbtnTorso = new JRadioButton("Torso");
		GridBagConstraints gbc_rdbtnTorso = new GridBagConstraints();
		gbc_rdbtnTorso.anchor = GridBagConstraints.WEST;
		gbc_rdbtnTorso.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnTorso.gridx = 1;
		gbc_rdbtnTorso.gridy = 10;
		add(rdbtnTorso, gbc_rdbtnTorso);
		buttonGroup3.add(rdbtnTorso);
		rdbtnTorso.setActionCommand("2");
				
		rdbtnTorso_1 = new JRadioButton("Torso");
		GridBagConstraints gbc_rdbtnTorso_1 = new GridBagConstraints();
		gbc_rdbtnTorso_1.anchor = GridBagConstraints.WEST;
		gbc_rdbtnTorso_1.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnTorso_1.gridx = 3;
		gbc_rdbtnTorso_1.gridy = 10;
		add(rdbtnTorso_1, gbc_rdbtnTorso_1);
		buttonGroup4.add(rdbtnTorso_1);
		rdbtnTorso_1.setActionCommand("2");
		
		rdbtnLeg = new JRadioButton("Leg");
		GridBagConstraints gbc_rdbtnLeg = new GridBagConstraints();
		gbc_rdbtnLeg.anchor = GridBagConstraints.WEST;
		gbc_rdbtnLeg.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnLeg.gridx = 1;
		gbc_rdbtnLeg.gridy = 11;
		add(rdbtnLeg, gbc_rdbtnLeg);
		buttonGroup3.add(rdbtnLeg);
		rdbtnLeg.setActionCommand("3");
		
		rdbtnLeg_1 = new JRadioButton("Leg");
		GridBagConstraints gbc_rdbtnLeg_1 = new GridBagConstraints();
		gbc_rdbtnLeg_1.anchor = GridBagConstraints.WEST;
		gbc_rdbtnLeg_1.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnLeg_1.gridx = 3;
		gbc_rdbtnLeg_1.gridy = 11;
		add(rdbtnLeg_1, gbc_rdbtnLeg_1);
		buttonGroup4.add(rdbtnLeg_1);
		rdbtnLeg_1.setActionCommand("3");
				
		btnAttack = new JButton("Attack");
		GridBagConstraints gbc_btnAttack = new GridBagConstraints();
		gbc_btnAttack.insets = new Insets(0, 0, 5, 5);
		gbc_btnAttack.gridx = 2;
		gbc_btnAttack.gridy = 13;
		add(btnAttack, gbc_btnAttack);
				
						
		//listener for the button
		btnAttack.addActionListener(new ButtonListener());
		
		die = new Dice();  
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
				//Get the area attacked by the Dice
				int batAreaAttacked = supermanWeapon;
				int supAreaAttacked = batmanWeapon;

				int batAreaDefended = Integer.parseInt(buttonGroup3.getSelection().getActionCommand());
				int supAreaDefended = Integer.parseInt(buttonGroup4.getSelection().getActionCommand());
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
				
				batDice = die.getDie1() + die.getDie1();
				
				if(batDice > 11){
					batAttack = batAttack + (int)(batAttack*0.2);
				}
				
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
				supDice = die.getDie1() + die.getDie1();
				System.out.println(supDice);
				if(supDice > 11){
					supAttack = (supAttack + (int)(supAttack*0.2));
				}
				
				if (batAreaAttacked == batAreaDefended){
					supAttack = 0;
				}
				if(supAreaAttacked == supAreaDefended){
					batAttack = 0;
				}
				int supHealth = Sup.getHealth() - batAttack;
				int batHealth = Bat.getHealth() - supAttack;
				
				//use if condition to check health and declare a winner if any. 
				Sup.updateHealth(supHealth);
				Bat.updateHealth(batHealth);
				
				// if condition to stop the game
				System.out.println("BatHealth : "+batHealth);
				System.out.println("SupHealth : "+supHealth);

				progressBar_Bat.setValue(batHealth);
				progressBar_Sup.setValue(supHealth);
				
				//call updateStats to update stats with the latest attack.  Doesn't update most turns.
				sPanel.updateStats(0, 1, batAttack, supAttack, batAreaAttacked - 1, supAreaAttacked - 1, batHealth + supAttack, supHealth + batAttack, batDice, supDice);
				
				if(batHealth <= 0 && supHealth <=0){
					System.out.println("Its a draw");
					lblNewLabel.setText("Draw");
				}
				else if(batHealth <= 0 && supHealth > 0){
					System.out.print("Superman Wins");
					lblNewLabel.setText("Superman Wins");
				}
				else if(batHealth >0 && supHealth <=0){
					System.out.print("Batman Wins");
					lblNewLabel.setText("Batman Wins");
				}
				
			}
			//Reached when reset occurs
			else
			{
				lblNewLabel.setText("");
				Sup.updateHealth(100);
				Bat.updateHealth(100);
				sPanel.updateMostTurns(0,1,turn);
				progressBar_Bat.setValue(100);
				progressBar_Sup.setValue(100);
				turn = 0;
			}
		}
	} 
}
