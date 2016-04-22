package cse360project;

/**
 * @author Team35
 * @version April 15, 2016
 */


import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.util.*;

/**
 * The Play panel is a component of the applet which has the main working user interface of the 
 * game play. The user can see his Health and choose between the different options of Attack and
 * Defend. 
 * @author Team35
 *
 */
public class PlayPanel extends JPanel
{
	//Stat panel object to collect, store and update the stats
	private StatPanel sPanel;
	
	//panels to contain the different components
	JPanel creation;
	JPanel play;	
	
	GridBagLayout gridBagLayout;
	CardLayout cardLayout;
	
	PlayPanel thisPanel;
	
	//Button group has different button to club the radio button together
	private final ButtonGroup buttonGroup1 = new ButtonGroup();
	private final ButtonGroup buttonGroup2 = new ButtonGroup();
	private final ButtonGroup buttonGroup3 = new ButtonGroup();
	private final ButtonGroup buttonGroup4 = new ButtonGroup();
	
	//Images of characters
	private ImageIcon imgBatman = new ImageIcon("Batman1.jpg");
	private ImageIcon imgSuperman = new ImageIcon("Superman.jpg");
	
	//Class Object
	private Character char2;
	private Character char1;
	
	//Progress Bar to show the health of the character
	private JProgressBar progressBar_char1;
	private JProgressBar progressBar_char2;
	
	//Label to show name of the Character
	private Label char2Label;
	private Label char1Label;
	
	//Radio button for different weapon of character
	private JRadioButton rdbtnWeapon;
	private JRadioButton rdbtnWeapon_3;
	private JRadioButton rdbtnWeapon_1;
	private JRadioButton rdbtnWeapon_4;
	private JRadioButton rdbtnWeapon_2;
	private JRadioButton rdbtnWeapon_5;
	
	//Turn to keep count of number of turn
	private int turn;
	
	//Label to show the Block Option
	private Label lblChar1Block;
	
	//Radio button to show the area that can be blocked
	private JRadioButton rdbtnHead;
	private JRadioButton rdbtnTorso;
	private JRadioButton rdbtnLeg;
	
	//Label to show the Block Option 
	private Label lblChar2Block;
	
	//Radio button to show the area that can be blocked
	private JRadioButton rdbtnHead_1;
	private JRadioButton rdbtnTorso_1;
	private JRadioButton rdbtnLeg_1;
	
	//Dice value to calculate the critical hit of the character  
	private int char1Dice;
	private int char2Dice;
	
	//Dice Object to get the value of Dice 
	private Dice die;
	
	//Label to show the end result of the Match
	private JLabel winnerLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblCriticalHit;
	private JLabel lblDiceValue;
	private JLabel lblDiceValue_1;
	private JButton create;
	private JButton btnAttack;
	//Initialize the character object here
	//Constructor initializes components and organize them using certain layouts
	public PlayPanel(StatPanel sPanel)
	{
		//set the turn counter zero 
		turn = 0;
		
		//reference to the stat panel
		this.sPanel = sPanel;
		//for now, it needs a reference to itself
		thisPanel = this;
		
		//layout for the play screen
		gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 229, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 32, 0, 28, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		
		//card layout used to switch between a tournament creation and play screen
		cardLayout = new CardLayout();
		//tournament creation panel
		creation = new JPanel();
		//panel where each match is played
		play = new JPanel(gridBagLayout);
		
		//the overall layout is card layout
		setLayout(cardLayout);
		//the first card is the creation screen
		add(creation);
		//button to create a tournament, switches to the next screen
		create = new JButton("Create");
		creation.add(create);
		//the second card is the play screen
		add(play);
		
		//Initialize the class object  
		char2 = new Character(1);
		char1 = new Character(0);
		
		//Initialize the Jlabel to show the result of the char1tle
		winnerLabel = new JLabel("");
		GridBagConstraints gbc_winnerLabel = new GridBagConstraints();
		gbc_winnerLabel.insets = new Insets(0, 0, 5, 5);
		gbc_winnerLabel.gridx = 2;
		gbc_winnerLabel.gridy = 2;
		play.add(winnerLabel, gbc_winnerLabel);
		
		//Initialize the Progress bar of character1
		progressBar_char1 = new JProgressBar();
		GridBagConstraints gbc_progressBar = new GridBagConstraints();
		gbc_progressBar.fill = GridBagConstraints.HORIZONTAL;
		gbc_progressBar.insets = new Insets(0, 0, 5, 5);
		gbc_progressBar.gridx = 1;
		gbc_progressBar.gridy = 2;
		play.add(progressBar_char1, gbc_progressBar);
		progressBar_char1.setStringPainted(true);

		
		//Set the health of the Player using the character1 class object
		progressBar_char1.setValue(char1.getHealth());
		
		//Initialize the Progress bar of character2
		progressBar_char2 = new JProgressBar();
		GridBagConstraints gbc_progressBar_1 = new GridBagConstraints();
		gbc_progressBar_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_progressBar_1.insets = new Insets(0, 0, 5, 5);
		gbc_progressBar_1.gridx = 3;
		gbc_progressBar_1.gridy = 2;
		play.add(progressBar_char2, gbc_progressBar_1);
		progressBar_char2.setStringPainted(true);

		
		//Set the health of the Player
		progressBar_char2.setValue(char2.getHealth());
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(char1.heroPic());
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 3;
		play.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(char2.heroPic());
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 3;
		gbc_lblNewLabel_2.gridy = 3;
		play.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		//Initialize the Label of character1
		char1Label = new Label(char1.heroName());
		GridBagConstraints gbc_char1Label = new GridBagConstraints();
		gbc_char1Label.insets = new Insets(0, 0, 5, 5);
		gbc_char1Label.gridx = 1;
		gbc_char1Label.gridy = 4;
		play.add(char1Label, gbc_char1Label);

		//Initialize the Label of character2
		char2Label = new Label(char2.heroName());
		GridBagConstraints gbc_char2Label = new GridBagConstraints();
		gbc_char2Label.insets = new Insets(0, 0, 5, 5);
		gbc_char2Label.gridx = 3;
		gbc_char2Label.gridy = 4;
		play.add(char2Label, gbc_char2Label);
		
		//Initialize the Radiobutton for weapon 1 of character1
		rdbtnWeapon = new JRadioButton(char1.weaponName(1) + " (10 attack, head)");
		GridBagConstraints gbc_rdbtnWeapon = new GridBagConstraints();
		gbc_rdbtnWeapon.anchor = GridBagConstraints.WEST;
		gbc_rdbtnWeapon.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnWeapon.gridx = 1;
		gbc_rdbtnWeapon.gridy = 6;
		play.add(rdbtnWeapon, gbc_rdbtnWeapon);
		
		//add button to the group of weapon of character1
		buttonGroup1.add(rdbtnWeapon);
		
		//setActionCommand for each JRadioButton
		rdbtnWeapon.setActionCommand("1");
		
		//Initialize the Radiobutton for weapon 1 of character2
		rdbtnWeapon_3 = new JRadioButton(char2.weaponName(1) + " (10 attack, head)");
		GridBagConstraints gbc_rdbtnWeapon_3 = new GridBagConstraints();
		gbc_rdbtnWeapon_3.anchor = GridBagConstraints.WEST;
		gbc_rdbtnWeapon_3.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnWeapon_3.gridx = 3;
		gbc_rdbtnWeapon_3.gridy = 6;
		play.add(rdbtnWeapon_3, gbc_rdbtnWeapon_3);
		
		//add the button to the group of weapon of character2
		buttonGroup2.add(rdbtnWeapon_3);
		
		//setActionCommand for each of the JRadioButton
		rdbtnWeapon_3.setActionCommand("1");
		
		//Initialize the Radiobutton for weapon 2 of character1
		rdbtnWeapon_1 = new JRadioButton(char1.weaponName(2) + " (8 attack, torso)");
		GridBagConstraints gbc_rdbtnWeapon_1 = new GridBagConstraints();
		gbc_rdbtnWeapon_1.anchor = GridBagConstraints.WEST;
		gbc_rdbtnWeapon_1.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnWeapon_1.gridx = 1;
		gbc_rdbtnWeapon_1.gridy = 7;
		play.add(rdbtnWeapon_1, gbc_rdbtnWeapon_1);
		
		//add the button to the group of weapon of character1
		buttonGroup1.add(rdbtnWeapon_1);
		
		//setActionCommand for each of the JRadioButton
		rdbtnWeapon_1.setActionCommand("2");
		
		//Initialize the Radiobutton for weapon 2 of character2
		rdbtnWeapon_4 = new JRadioButton(char2.weaponName(2) + " (8 attack, torso)");
		GridBagConstraints gbc_rdbtnWeapon_4 = new GridBagConstraints();
		gbc_rdbtnWeapon_4.anchor = GridBagConstraints.WEST;
		gbc_rdbtnWeapon_4.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnWeapon_4.gridx = 3;
		gbc_rdbtnWeapon_4.gridy = 7;
		play.add(rdbtnWeapon_4, gbc_rdbtnWeapon_4);
		
		//add the button to the group of weapon of character2
		buttonGroup2.add(rdbtnWeapon_4);
		
		//setActionCommand for each of the JRadioButton
		rdbtnWeapon_4.setActionCommand("2");

		//Initialize the Radiobutton for weapon 3 of character1
		rdbtnWeapon_2 = new JRadioButton(char1.weaponName(3) + " (6 attack, legs)");
		GridBagConstraints gbc_rdbtnWeapon_2 = new GridBagConstraints();
		gbc_rdbtnWeapon_2.anchor = GridBagConstraints.WEST;
		gbc_rdbtnWeapon_2.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnWeapon_2.gridx = 1;
		gbc_rdbtnWeapon_2.gridy = 8;
		play.add(rdbtnWeapon_2, gbc_rdbtnWeapon_2);

		//add the button to the group of weapon of character1
		buttonGroup1.add(rdbtnWeapon_2);
		
		//setActionCommand for each of the JRadioButton
		rdbtnWeapon_2.setActionCommand("3");
		
		//Initialize the Radiobutton for weapon 3 of character2
		rdbtnWeapon_5 = new JRadioButton(char2.weaponName(3) + " (6 attack, legs)");
		GridBagConstraints gbc_rdbtnWeapon_5 = new GridBagConstraints();
		gbc_rdbtnWeapon_5.anchor = GridBagConstraints.WEST;
		gbc_rdbtnWeapon_5.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnWeapon_5.gridx = 3;
		gbc_rdbtnWeapon_5.gridy = 8;
		play.add(rdbtnWeapon_5, gbc_rdbtnWeapon_5);

		//add the button to the group of weapon of character2
		buttonGroup2.add(rdbtnWeapon_5);
		
		//setActionCommand for each of the JRadioButton
		rdbtnWeapon_5.setActionCommand("3");
		
		lblDiceValue = new JLabel("Dice Value : 0");
		GridBagConstraints gbc_lblDiceValue = new GridBagConstraints();
		gbc_lblDiceValue.insets = new Insets(0, 0, 5, 5);
		gbc_lblDiceValue.gridx = 1;
		gbc_lblDiceValue.gridy = 9;
		play.add(lblDiceValue, gbc_lblDiceValue);
		
		lblDiceValue_1 = new JLabel("Dice Value : 0");
		GridBagConstraints gbc_lblDiceValue_1 = new GridBagConstraints();
		gbc_lblDiceValue_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblDiceValue_1.gridx = 3;
		gbc_lblDiceValue_1.gridy = 9;
		play.add(lblDiceValue_1, gbc_lblDiceValue_1);
		
		
		//Initialize the character1 Block Label 
		lblChar1Block = new Label(char1.heroName() + " Block");
		GridBagConstraints gbc_lblChar1Block = new GridBagConstraints();
		gbc_lblChar1Block.insets = new Insets(0, 0, 5, 5);
		gbc_lblChar1Block.gridx = 1;
		gbc_lblChar1Block.gridy = 10;
		play.add(lblChar1Block, gbc_lblChar1Block);
		
		//Initialize the character2 Block Label
		lblChar2Block = new Label(char2.heroName() + " Block");
		GridBagConstraints gbc_lblChar2Block = new GridBagConstraints();
		gbc_lblChar2Block.insets = new Insets(0, 0, 5, 5);
		gbc_lblChar2Block.gridx = 3;
		gbc_lblChar2Block.gridy = 10;
		play.add(lblChar2Block, gbc_lblChar2Block);
		
		//Initialize the Radiobutton for head block of character1
		rdbtnHead = new JRadioButton("Head");
		GridBagConstraints gbc_rdbtnHead = new GridBagConstraints();
		gbc_rdbtnHead.anchor = GridBagConstraints.WEST;
		gbc_rdbtnHead.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnHead.gridx = 1;
		gbc_rdbtnHead.gridy = 11;
		play.add(rdbtnHead, gbc_rdbtnHead);
		buttonGroup3.add(rdbtnHead);
		rdbtnHead.setActionCommand("1");
		
		//Initialize the Radiobutton for head block of character2
		rdbtnHead_1 = new JRadioButton("Head");
		GridBagConstraints gbc_rdbtnHead_1 = new GridBagConstraints();
		gbc_rdbtnHead_1.anchor = GridBagConstraints.WEST;
		gbc_rdbtnHead_1.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnHead_1.gridx = 3;
		gbc_rdbtnHead_1.gridy = 11;
		play.add(rdbtnHead_1, gbc_rdbtnHead_1);
		buttonGroup4.add(rdbtnHead_1);
		rdbtnHead_1.setActionCommand("1");
		
		//Initialize the Radiobutton for torso block of character1
		rdbtnTorso = new JRadioButton("Torso");
		GridBagConstraints gbc_rdbtnTorso = new GridBagConstraints();
		gbc_rdbtnTorso.anchor = GridBagConstraints.WEST;
		gbc_rdbtnTorso.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnTorso.gridx = 1;
		gbc_rdbtnTorso.gridy = 12;
		play.add(rdbtnTorso, gbc_rdbtnTorso);
		buttonGroup3.add(rdbtnTorso);
		rdbtnTorso.setActionCommand("2");
				
		//Initialize the Radiobutton for torso block of character2
		rdbtnTorso_1 = new JRadioButton("Torso");
		GridBagConstraints gbc_rdbtnTorso_1 = new GridBagConstraints();
		gbc_rdbtnTorso_1.anchor = GridBagConstraints.WEST;
		gbc_rdbtnTorso_1.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnTorso_1.gridx = 3;
		gbc_rdbtnTorso_1.gridy = 12;
		play.add(rdbtnTorso_1, gbc_rdbtnTorso_1);
		buttonGroup4.add(rdbtnTorso_1);
		rdbtnTorso_1.setActionCommand("2");
		
		//Initialize the Radiobutton for leg block of character1
		rdbtnLeg = new JRadioButton("Leg");
		GridBagConstraints gbc_rdbtnLeg = new GridBagConstraints();
		gbc_rdbtnLeg.anchor = GridBagConstraints.WEST;
		gbc_rdbtnLeg.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnLeg.gridx = 1;
		gbc_rdbtnLeg.gridy = 13;
		play.add(rdbtnLeg, gbc_rdbtnLeg);
		buttonGroup3.add(rdbtnLeg);
		rdbtnLeg.setActionCommand("3");
		
		//Initialize the Radiobutton for leg block of character2
		rdbtnLeg_1 = new JRadioButton("Leg");
		GridBagConstraints gbc_rdbtnLeg_1 = new GridBagConstraints();
		gbc_rdbtnLeg_1.anchor = GridBagConstraints.WEST;
		gbc_rdbtnLeg_1.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnLeg_1.gridx = 3;
		gbc_rdbtnLeg_1.gridy = 13;
		play.add(rdbtnLeg_1, gbc_rdbtnLeg_1);
		buttonGroup4.add(rdbtnLeg_1);
		rdbtnLeg_1.setActionCommand("3");
		
		btnAttack = new JButton("Attack");
		GridBagConstraints gbc_btnAttack = new GridBagConstraints();
		gbc_btnAttack.insets = new Insets(0, 0, 5, 5);
		gbc_btnAttack.gridx = 2;
		gbc_btnAttack.gridy = 14;
		play.add(btnAttack, gbc_btnAttack);
		
		//listener for the attack button
		btnAttack.addActionListener(new ButtonListener());
		
		//listener for the create button
		create.addActionListener(new ButtonListener());
		
		//Initialize the Dice Object
		die = new Dice();  
	}
 
	//ButtonListener is a listener class that listens to the attack button
	//Implement the class object of the two character here
	private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			//checks the source of the event, could be the create or attack button
			JButton source = (JButton)event.getSource();
			if(source == btnAttack)
			{
				//check the health of both characters, the match is either over or continuing
				if(progressBar_char1.getValue() > 0 && progressBar_char2.getValue() > 0)
				{
					//increment turn counter
					turn++;
					
					//getActionCommand to get a string for the weapon, parseInt to convert to int
					int character1Weapon = Integer.parseInt(buttonGroup1.getSelection().getActionCommand());
					int character2Weapon = Integer.parseInt(buttonGroup2.getSelection().getActionCommand());
					//Get the area attacked by the Dice
					int char1AreaAttacked = character2Weapon;
					int char2AreaAttacked = character1Weapon;
	
					int char1AreaDefended = Integer.parseInt(buttonGroup3.getSelection().getActionCommand());
					int char2AreaDefended = Integer.parseInt(buttonGroup4.getSelection().getActionCommand());
					int char1Attack;
					int char2Attack;
					
					//Get character1 Weapon Choice
					if (character1Weapon == 1){
						char1Attack = char1.getWeapon1();
					}
					else if (character1Weapon == 2){
						char1Attack = char1.getWeapon2();
					}
					else{
						char1Attack = char1.getWeapon3();
					}
					
					//Calculate character1 Critical Hit Chance
					char1Dice = die.getDie1() + die.getDie1();
					lblDiceValue.setText("Dice Value : "+char1Dice);
					if(char1Dice > 11){
						char1Attack = char1Attack + (int)(char1Attack*0.2);
					}
					
					//Get character2 Weapon Choice
					if (character2Weapon == 1){
						char2Attack = char2.getWeapon1();
					}
					else if (character2Weapon == 2){
						char2Attack = char2.getWeapon2();
					}
					else{
						char2Attack = char2.getWeapon3();
					}
					
					//Calculate character2 Critical Health Chance
					char2Dice = die.getDie1() + die.getDie1();
					lblDiceValue_1.setText("Dice Value :"+char2Dice);
					if(char2Dice > 11){
						char2Attack = (char2Attack + (int)(char2Attack*0.2));
					}
					
					//See if Block is successful for character1
					if (char1AreaAttacked == char1AreaDefended){
						char2Attack = 0;
					}
					
					//See if Block is successful for character2 
					if(char2AreaAttacked == char2AreaDefended){
						char1Attack = 0;
					}
					
					//Get the update health after the Attack
					int char2Health = char2.getHealth() - char1Attack;
					int char1Health = char1.getHealth() - char2Attack;
					
					//Update the Health of the Character  
					char2.updateHealth(char2Health);
					char1.updateHealth(char1Health);
					
					// if condition to stop the game
					System.out.println("char1Health : "+char1Health);
					System.out.println("char2Health : "+char2Health);
	
					//Update the progress bar of the characters 
					progressBar_char1.setValue(char1Health);
					progressBar_char2.setValue(char2Health);
					
					//call updateStats to update stats with the latest attack.  Doesn't update most turns.
					sPanel.updateStats(0, 1, char1Attack, char2Attack, char1AreaAttacked - 1, char2AreaAttacked - 1, char1Health + char2Attack, char2Health + char1Attack, char1Dice, char2Dice);
					
					//test whether we have a draw or a winner
					if(char1Health <= 0 && char2Health <=0){
						System.out.println("Its a draw");
						winnerLabel.setText("Draw");
					}
					else if(char1Health <= 0 && char2Health > 0){
						System.out.print(char2.heroName() + " Wins");
						winnerLabel.setText(char2.heroName() + " Wins");
					}
					else if(char1Health >0 && char2Health <=0){
						System.out.print(char1.heroName() + " Wins");
						winnerLabel.setText(char1.heroName() + " Wins");
					}
					
				}
				//Reached when reset occurs, at least one character is below or at 0 health
				else
				{
					//Reset the Winner or Draw Label
					winnerLabel.setText("");
					
					// Reset Winner Image Label
					//lblWinner.setIcon(null);
					
					//Reset Dice Value for both the Player
					lblDiceValue_1.setText("Dice Value : 0");
					lblDiceValue.setText("Dice Value : 0");
					
	
					
					//Update the health of the character 
					char2.updateHealth(100);
					char1.updateHealth(100);
					
					//Update the turn panel
					sPanel.updateMostTurns(0,1,turn);
					
					//Reset the progress bar
					progressBar_char1.setValue(100);
					progressBar_char2.setValue(100);
					
					//Reset the turn
					turn = 0;
				}
			}
			//Reached if the create button was pressed
			else if(source == create)
			{
				//Do stuff to set up the play screen
				//change images, labels, etc
				
				cardLayout.next(thisPanel);
			}
		}
	} 
}
