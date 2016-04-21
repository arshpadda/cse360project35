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
	private Character Sup;
	private Character Bat;
	
	//Progress Bar to show the health of the character
	private JProgressBar progressBar_Bat;
	private JProgressBar progressBar_Sup;
	
	//Label to show name of the Character
	private Label label_1;
	private Label label;
	
	//Button to Attack each other when clicked 
	private JButton btnAttack;
	
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
	private Label label_2;
	
	//Radio button to show the area that can be blocked
	private JRadioButton rdbtnHead;
	private JRadioButton rdbtnTorso;
	private JRadioButton rdbtnLeg;
	
	//Label to show the Block Option 
	private Label lblSupBlock;
	
	//Radio button to show the area that can be blocked
	private JRadioButton rdbtnHead_1;
	private JRadioButton rdbtnTorso_1;
	private JRadioButton rdbtnLeg_1;
	
	//Dice value to calculate the critical hit of the character  
	private int batDice;
	private int supDice;
	
	//Dice Object to get the value of Dice 
	private Dice die;
	
	//Label to show the end result of the Match
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblCriticalHit;
	private JLabel lblDiceValue;
	private JLabel lblDiceValue_1;
	private JButton create;
	//Initialize the character object here
	//Constructor initializes components and organize them using certain layouts
	public PlayPanel(StatPanel sPanel)
	{
		//set the turn counter zero 
		turn = 0;
		
		this.sPanel = sPanel;
		thisPanel = this;
		gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 32, 0, 28, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		
		cardLayout = new CardLayout();
		creation = new JPanel();
		play = new JPanel(gridBagLayout);
		
		setLayout(cardLayout);
		add(creation);
		
		create = new JButton("Create");
		creation.add(create);
		add(play);
		
		//Initialize the class object  
		Sup = new Character(1);
		Bat = new Character(0);
		
		//Initialize the Jlabel to show the result of the battle
		lblNewLabel = new JLabel("");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 2;
		play.add(lblNewLabel, gbc_lblNewLabel);
		
		//Initialize the Progress bar of batman
		progressBar_Bat = new JProgressBar();
		GridBagConstraints gbc_progressBar = new GridBagConstraints();
		gbc_progressBar.fill = GridBagConstraints.HORIZONTAL;
		gbc_progressBar.insets = new Insets(0, 0, 5, 5);
		gbc_progressBar.gridx = 1;
		gbc_progressBar.gridy = 2;
		play.add(progressBar_Bat, gbc_progressBar);
		progressBar_Bat.setStringPainted(true);

		
		//Set the health of the Player using the Batman class object
		progressBar_Bat.setValue(Bat.getHealth());
		
		//Initialize the Progress bar of superman
		progressBar_Sup = new JProgressBar();
		GridBagConstraints gbc_progressBar_1 = new GridBagConstraints();
		gbc_progressBar_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_progressBar_1.insets = new Insets(0, 0, 5, 5);
		gbc_progressBar_1.gridx = 3;
		gbc_progressBar_1.gridy = 2;
		play.add(progressBar_Sup, gbc_progressBar_1);
		progressBar_Sup.setStringPainted(true);

		
		//Set the health of the Player
		progressBar_Sup.setValue(Sup.getHealth());
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(Bat.heroPic());
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 3;
		play.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(Sup.heroPic());
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 3;
		gbc_lblNewLabel_2.gridy = 3;
		play.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		//Initialize the Label of Batman
		label = new Label(Bat.heroName());
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 4;
		play.add(label, gbc_label);

		//Initialize the Label of Superman
		label_1 = new Label(Sup.heroName());
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 3;
		gbc_label_1.gridy = 4;
		play.add(label_1, gbc_label_1);
		
		//Initialize the Radiobutton for weapon 1 of batman
		rdbtnWeapon = new JRadioButton(Bat.weaponName(1) + " (10 attack, head)");
		GridBagConstraints gbc_rdbtnWeapon = new GridBagConstraints();
		gbc_rdbtnWeapon.anchor = GridBagConstraints.WEST;
		gbc_rdbtnWeapon.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnWeapon.gridx = 1;
		gbc_rdbtnWeapon.gridy = 6;
		play.add(rdbtnWeapon, gbc_rdbtnWeapon);
		
		//add button to the group of weapon of batman
		buttonGroup1.add(rdbtnWeapon);
		
		//setActionCommand for each JRadioButton
		rdbtnWeapon.setActionCommand("1");
		
		//Initialize the Radiobutton for weapon 1 of superman
		rdbtnWeapon_3 = new JRadioButton(Sup.weaponName(1) + " (10 attack, head)");
		GridBagConstraints gbc_rdbtnWeapon_3 = new GridBagConstraints();
		gbc_rdbtnWeapon_3.anchor = GridBagConstraints.WEST;
		gbc_rdbtnWeapon_3.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnWeapon_3.gridx = 3;
		gbc_rdbtnWeapon_3.gridy = 6;
		play.add(rdbtnWeapon_3, gbc_rdbtnWeapon_3);
		
		//add the button to the group of weapon of superman
		buttonGroup2.add(rdbtnWeapon_3);
		
		//setActionCommand for each of the JRadioButton
		rdbtnWeapon_3.setActionCommand("1");
		
		//Initialize the Radiobutton for weapon 2 of batman
		rdbtnWeapon_1 = new JRadioButton(Bat.weaponName(2) + " (8 attack, torso)");
		GridBagConstraints gbc_rdbtnWeapon_1 = new GridBagConstraints();
		gbc_rdbtnWeapon_1.anchor = GridBagConstraints.WEST;
		gbc_rdbtnWeapon_1.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnWeapon_1.gridx = 1;
		gbc_rdbtnWeapon_1.gridy = 7;
		play.add(rdbtnWeapon_1, gbc_rdbtnWeapon_1);
		
		//add the button to the group of weapon of batman
		buttonGroup1.add(rdbtnWeapon_1);
		
		//setActionCommand for each of the JRadioButton
		rdbtnWeapon_1.setActionCommand("2");
		
		//Initialize the Radiobutton for weapon 2 of superman
		rdbtnWeapon_4 = new JRadioButton(Sup.weaponName(2) + " (8 attack, torso)");
		GridBagConstraints gbc_rdbtnWeapon_4 = new GridBagConstraints();
		gbc_rdbtnWeapon_4.anchor = GridBagConstraints.WEST;
		gbc_rdbtnWeapon_4.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnWeapon_4.gridx = 3;
		gbc_rdbtnWeapon_4.gridy = 7;
		play.add(rdbtnWeapon_4, gbc_rdbtnWeapon_4);
		
		//add the button to the group of weapon of superman
		buttonGroup2.add(rdbtnWeapon_4);
		
		//setActionCommand for each of the JRadioButton
		rdbtnWeapon_4.setActionCommand("2");

		//Initialize the Radiobutton for weapon 3 of batman
		rdbtnWeapon_2 = new JRadioButton(Bat.weaponName(3) + " (6 attack, legs)");
		GridBagConstraints gbc_rdbtnWeapon_2 = new GridBagConstraints();
		gbc_rdbtnWeapon_2.anchor = GridBagConstraints.WEST;
		gbc_rdbtnWeapon_2.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnWeapon_2.gridx = 1;
		gbc_rdbtnWeapon_2.gridy = 8;
		play.add(rdbtnWeapon_2, gbc_rdbtnWeapon_2);

		//add the button to the group of weapon of batman
		buttonGroup1.add(rdbtnWeapon_2);
		
		//setActionCommand for each of the JRadioButton
		rdbtnWeapon_2.setActionCommand("3");
		
		//Initialize the Radiobutton for weapon 3 of superman
		rdbtnWeapon_5 = new JRadioButton(Sup.weaponName(3) + " (6 attack, legs)");
		GridBagConstraints gbc_rdbtnWeapon_5 = new GridBagConstraints();
		gbc_rdbtnWeapon_5.anchor = GridBagConstraints.WEST;
		gbc_rdbtnWeapon_5.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnWeapon_5.gridx = 3;
		gbc_rdbtnWeapon_5.gridy = 8;
		play.add(rdbtnWeapon_5, gbc_rdbtnWeapon_5);

		//add the button to the group of weapon of superman
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
		
		
		//Initialize the Batman Block Label 
		label_2 = new Label("Bat Block");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 1;
		gbc_label_2.gridy = 10;
		play.add(label_2, gbc_label_2);
		
		//Initialize the Superman Block Label
		lblSupBlock = new Label("Sup Block");
		GridBagConstraints gbc_lblSupBlock = new GridBagConstraints();
		gbc_lblSupBlock.insets = new Insets(0, 0, 5, 5);
		gbc_lblSupBlock.gridx = 3;
		gbc_lblSupBlock.gridy = 10;
		play.add(lblSupBlock, gbc_lblSupBlock);
		
		//Initialize the Radiobutton for head block of batman
		rdbtnHead = new JRadioButton("Head");
		GridBagConstraints gbc_rdbtnHead = new GridBagConstraints();
		gbc_rdbtnHead.anchor = GridBagConstraints.WEST;
		gbc_rdbtnHead.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnHead.gridx = 1;
		gbc_rdbtnHead.gridy = 11;
		play.add(rdbtnHead, gbc_rdbtnHead);
		buttonGroup3.add(rdbtnHead);
		rdbtnHead.setActionCommand("1");
		
		//Initialize the Radiobutton for head block of superman
		rdbtnHead_1 = new JRadioButton("Head");
		GridBagConstraints gbc_rdbtnHead_1 = new GridBagConstraints();
		gbc_rdbtnHead_1.anchor = GridBagConstraints.WEST;
		gbc_rdbtnHead_1.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnHead_1.gridx = 3;
		gbc_rdbtnHead_1.gridy = 11;
		play.add(rdbtnHead_1, gbc_rdbtnHead_1);
		buttonGroup4.add(rdbtnHead_1);
		rdbtnHead_1.setActionCommand("1");
		
		//Initialize the Radiobutton for torso block of Batman
		rdbtnTorso = new JRadioButton("Torso");
		GridBagConstraints gbc_rdbtnTorso = new GridBagConstraints();
		gbc_rdbtnTorso.anchor = GridBagConstraints.WEST;
		gbc_rdbtnTorso.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnTorso.gridx = 1;
		gbc_rdbtnTorso.gridy = 12;
		play.add(rdbtnTorso, gbc_rdbtnTorso);
		buttonGroup3.add(rdbtnTorso);
		rdbtnTorso.setActionCommand("2");
				
		//Initialize the Radiobutton for torso block of Superman
		rdbtnTorso_1 = new JRadioButton("Torso");
		GridBagConstraints gbc_rdbtnTorso_1 = new GridBagConstraints();
		gbc_rdbtnTorso_1.anchor = GridBagConstraints.WEST;
		gbc_rdbtnTorso_1.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnTorso_1.gridx = 3;
		gbc_rdbtnTorso_1.gridy = 12;
		play.add(rdbtnTorso_1, gbc_rdbtnTorso_1);
		buttonGroup4.add(rdbtnTorso_1);
		rdbtnTorso_1.setActionCommand("2");
		
		//Initialize the Radiobutton for leg block of batman
		rdbtnLeg = new JRadioButton("Leg");
		GridBagConstraints gbc_rdbtnLeg = new GridBagConstraints();
		gbc_rdbtnLeg.anchor = GridBagConstraints.WEST;
		gbc_rdbtnLeg.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnLeg.gridx = 1;
		gbc_rdbtnLeg.gridy = 13;
		play.add(rdbtnLeg, gbc_rdbtnLeg);
		buttonGroup3.add(rdbtnLeg);
		rdbtnLeg.setActionCommand("3");
		
		//Initialize the Radiobutton for leg block of superman
		rdbtnLeg_1 = new JRadioButton("Leg");
		GridBagConstraints gbc_rdbtnLeg_1 = new GridBagConstraints();
		gbc_rdbtnLeg_1.anchor = GridBagConstraints.WEST;
		gbc_rdbtnLeg_1.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnLeg_1.gridx = 3;
		gbc_rdbtnLeg_1.gridy = 13;
		play.add(rdbtnLeg_1, gbc_rdbtnLeg_1);
		buttonGroup4.add(rdbtnLeg_1);
		rdbtnLeg_1.setActionCommand("3");
				
		//Initialize the Attack button
		btnAttack = new JButton("Attack");
		GridBagConstraints gbc_btnAttack = new GridBagConstraints();
		gbc_btnAttack.insets = new Insets(0, 0, 5, 5);
		gbc_btnAttack.gridx = 2;
		gbc_btnAttack.gridy = 15;
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
			//checks the source of the event is the attack button
			JButton source = (JButton)event.getSource();
			if(source == btnAttack)
			{
				//
				if(progressBar_Bat.getValue() > 0 && progressBar_Sup.getValue() > 0)
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
					
					//Calculate Batman Critical Hit Chance
					batDice = die.getDie1() + die.getDie1();
					lblDiceValue.setText("Dice Value : "+batDice);
					if(batDice > 11){
						batAttack = batAttack + (int)(batAttack*0.2);
					}
					
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
					
					//Calculate Superman Critical Health Chance
					supDice = die.getDie1() + die.getDie1();
					lblDiceValue_1.setText("Dice Value :"+supDice);
					if(supDice > 11){
						supAttack = (supAttack + (int)(supAttack*0.2));
					}
					
					//See if Block is successful for Batman
					if (batAreaAttacked == batAreaDefended){
						supAttack = 0;
					}
					
					//See if Block is successful for Superman 
					if(supAreaAttacked == supAreaDefended){
						batAttack = 0;
					}
					
					//Get the update health after the Attack
					int supHealth = Sup.getHealth() - batAttack;
					int batHealth = Bat.getHealth() - supAttack;
					
					//Update the Health of the Character  
					Sup.updateHealth(supHealth);
					Bat.updateHealth(batHealth);
					
					// if condition to stop the game
					System.out.println("BatHealth : "+batHealth);
					System.out.println("SupHealth : "+supHealth);
	
					//Update the progress bar of the characters 
					progressBar_Bat.setValue(batHealth);
					progressBar_Sup.setValue(supHealth);
					
					//call updateStats to update stats with the latest attack.  Doesn't update most turns.
					sPanel.updateStats(0, 1, batAttack, supAttack, batAreaAttacked - 1, supAreaAttacked - 1, batHealth + supAttack, supHealth + batAttack, batDice, supDice);
					
					//test whether we have a draw or a winner
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
					//Reset the Winner or Draw Label
					lblNewLabel.setText("");
					
					// Reset Winner Image Label
					//lblWinner.setIcon(null);
					
					//Reset Dice Value for both the Player
					lblDiceValue_1.setText("Dice Value : 0");
					lblDiceValue.setText("Dice Value : 0");
					
	
					
					//Update the health of the character 
					Sup.updateHealth(100);
					Bat.updateHealth(100);
					
					//Update the turn panel
					sPanel.updateMostTurns(0,1,turn);
					
					//Reset the progress bar
					progressBar_Bat.setValue(100);
					progressBar_Sup.setValue(100);
					
					//Reset the turn
					turn = 0;
				}
			}
			else if(source == create)
			{
				//Do stuff to set up the other panel
				
				cardLayout.next(thisPanel);
			}
		}
	} 
}
