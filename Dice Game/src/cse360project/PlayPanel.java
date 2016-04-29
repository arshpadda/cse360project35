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
	private JPanel creation;
	private JPanel play;	
	
	private GridBagLayout gridBagLayout;
	private CardLayout cardLayout;
	
	private PlayPanel thisPanel;
	
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
	
	//Turn keeps count of number of turns
	private int turn;
	
	//Match keeps track of what number the current match is
	private int match;
	
	//numChars keeps track of the number of characters after its been selected
	int numChars;
	
	//track the selected characters, in the case of a 4 character tournament
	int chosenCharacters[];
	
	//String to track the last winner
	String winner;
	
	//boolean to track if a tournament is being played
	boolean tournamentInProgress;
	
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
	private JLabel lblChar1Image;
	private JLabel lblChar2Image;
	private JLabel lblCriticalHit;
	private JLabel lblDiceValue;
	private JLabel lblDiceValue_1;
	private JButton create;
	private JButton btnAttack;
	private JPanel tournament_1;
	private JLabel tournament[];
	private JLabel numCharactersLabel;
	private JLabel lblImage;
	private JButton playButton;
	private JComboBox<Integer> numCharacters;
	private JCheckBox checkBox[];
	private JLabel lblNewLabel;

	//Initialize the character object here
	//Constructor initializes components and organize them using certain layouts
	public PlayPanel(StatPanel sPanel)
	{
		//numChars set to -1, should be non negative when used layer
		numChars = -1;
		
		//set the turn counter zero 
		turn = 0;
		
		//The winner String is initialized to ""
		winner = "";
		
		//set match to 1, because the first match is starting
		match = 1;
		
		//chosenCharacters is size 4
		chosenCharacters = new int[4];
		
		//tournamentInProgress is false until number of characters is chosen
		tournamentInProgress = false;
		
		//reference to the stat panel
		this.sPanel = sPanel;
		//for now, it needs a reference to itself
		thisPanel = this;
		
		//layout for the play screen
		gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 229, 0, 229, 0, 0};
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
		GridBagLayout gbl_creation = new GridBagLayout();
		gbl_creation.columnWidths = new int[]{12, 25, 22, 0, 11, 7, 0};
		gbl_creation.rowHeights = new int[]{23, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_creation.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_creation.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		creation.setLayout(gbl_creation);
		
		lblImage = new JLabel("Image");
		GridBagConstraints gbc_lblImage = new GridBagConstraints();
		gbc_lblImage.gridwidth = 4;
		gbc_lblImage.insets = new Insets(0, 0, 5, 5);
		gbc_lblImage.gridx = 1;
		gbc_lblImage.gridy = 5;
		creation.add(lblImage, gbc_lblImage);
		
		lblNewLabel = new JLabel("Select 2, 4 or 8 characters");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 4;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 13;
		creation.add(lblNewLabel, gbc_lblNewLabel);
		
		//array of JCheckBox, used to select characters
		checkBox = new JCheckBox[8];
		//initializing each JCheckBox, and adding to the panel
		checkBox[0] = new JCheckBox(Character.heroNames[0]);
		GridBagConstraints gbc_checkBox1 = new GridBagConstraints();
		gbc_checkBox1.anchor = GridBagConstraints.WEST;
		gbc_checkBox1.insets = new Insets(0, 0, 5, 5);
		gbc_checkBox1.gridx = 1;
		gbc_checkBox1.gridy = 14;
		creation.add(checkBox[0], gbc_checkBox1);
		
		checkBox[2] = new JCheckBox(Character.heroNames[2]);
		GridBagConstraints gbc_checkBox3 = new GridBagConstraints();
		gbc_checkBox3.anchor = GridBagConstraints.WEST;
		gbc_checkBox3.insets = new Insets(0, 0, 5, 5);
		gbc_checkBox3.gridx = 2;
		gbc_checkBox3.gridy = 14;
		creation.add(checkBox[2], gbc_checkBox3);
		
		checkBox[4] = new JCheckBox(Character.heroNames[4]);
		GridBagConstraints gbc_checkBox5 = new GridBagConstraints();
		gbc_checkBox5.fill = GridBagConstraints.HORIZONTAL;
		gbc_checkBox5.insets = new Insets(0, 0, 5, 5);
		gbc_checkBox5.gridx = 3;
		gbc_checkBox5.gridy = 14;
		creation.add(checkBox[4], gbc_checkBox5);
		
		checkBox[6] = new JCheckBox(Character.heroNames[6]);
		GridBagConstraints gbc_checkBox7 = new GridBagConstraints();
		gbc_checkBox7.fill = GridBagConstraints.HORIZONTAL;
		gbc_checkBox7.insets = new Insets(0, 0, 5, 5);
		gbc_checkBox7.gridx = 4;
		gbc_checkBox7.gridy = 14;
		creation.add(checkBox[6], gbc_checkBox7);
		
		checkBox[1] = new JCheckBox(Character.heroNames[1]);
		GridBagConstraints gbc_checkBox2 = new GridBagConstraints();
		gbc_checkBox2.anchor = GridBagConstraints.WEST;
		gbc_checkBox2.insets = new Insets(0, 0, 5, 5);
		gbc_checkBox2.gridx = 1;
		gbc_checkBox2.gridy = 15;
		creation.add(checkBox[1], gbc_checkBox2);
		
		checkBox[3] = new JCheckBox(Character.heroNames[3]);
		GridBagConstraints gbc_checkBox4 = new GridBagConstraints();
		gbc_checkBox4.anchor = GridBagConstraints.WEST;
		gbc_checkBox4.insets = new Insets(0, 0, 5, 5);
		gbc_checkBox4.gridx = 2;
		gbc_checkBox4.gridy = 15;
		creation.add(checkBox[3], gbc_checkBox4);
		
		checkBox[5] = new JCheckBox(Character.heroNames[5]);
		GridBagConstraints gbc_checkBox6 = new GridBagConstraints();
		gbc_checkBox6.fill = GridBagConstraints.HORIZONTAL;
		gbc_checkBox6.insets = new Insets(0, 0, 5, 5);
		gbc_checkBox6.gridx = 3;
		gbc_checkBox6.gridy = 15;
		creation.add(checkBox[5], gbc_checkBox6);
		
		checkBox[7] = new JCheckBox(Character.heroNames[7]);
		GridBagConstraints gbc_checkBox8 = new GridBagConstraints();
		gbc_checkBox8.fill = GridBagConstraints.HORIZONTAL;
		gbc_checkBox8.insets = new Insets(0, 0, 5, 5);
		gbc_checkBox8.gridx = 4;
		gbc_checkBox8.gridy = 15;
		creation.add(checkBox[7], gbc_checkBox8);
		
		numCharactersLabel = new JLabel("Number of Players");
		numCharactersLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_numCharactersLabel = new GridBagConstraints();
		gbc_numCharactersLabel.anchor = GridBagConstraints.EAST;
		gbc_numCharactersLabel.insets = new Insets(0, 0, 5, 5);
		gbc_numCharactersLabel.gridx = 1;
		gbc_numCharactersLabel.gridy = 16;
		creation.add(numCharactersLabel, gbc_numCharactersLabel);
		
		numCharacters = new JComboBox<Integer>();
		numCharacters.setModel(new DefaultComboBoxModel<Integer>(new Integer[] {2, 4, 8}));
		GridBagConstraints gbc_numCharacters = new GridBagConstraints();
		gbc_numCharacters.insets = new Insets(0, 0, 5, 5);
		gbc_numCharacters.fill = GridBagConstraints.HORIZONTAL;
		gbc_numCharacters.gridx = 2;
		gbc_numCharacters.gridy = 16;
		creation.add(numCharacters, gbc_numCharacters);
		//button to create a tournament, switches to the next screen
		create = new JButton("Create");
		GridBagConstraints gbc_create = new GridBagConstraints();
		gbc_create.fill = GridBagConstraints.BOTH;
		gbc_create.gridwidth = 2;
		gbc_create.insets = new Insets(0, 0, 5, 5);
		gbc_create.gridx = 3;
		gbc_create.gridy = 16;
		creation.add(create, gbc_create);
		
		//listener for the create button
		create.addActionListener(new ButtonListener());
		
		tournament_1 = new JPanel();
		add(tournament_1, "name_15822071098700");
		GridBagLayout gbl_tournament_1 = new GridBagLayout();
		gbl_tournament_1.columnWidths = new int[]{0, 0, 0, 0, 0, 28, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_tournament_1.rowHeights = new int[]{0, 0, 23, 0, 0, 0, 0, 0, 0, 0};
		gbl_tournament_1.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_tournament_1.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		tournament_1.setLayout(gbl_tournament_1);
		
		tournament = new JLabel[15];
		
		tournament[14] = new JLabel("Champion");
		GridBagConstraints gbc_tournament14 = new GridBagConstraints();
		gbc_tournament14.gridwidth = 3;
		gbc_tournament14.insets = new Insets(0, 0, 5, 5);
		gbc_tournament14.gridx = 7;
		gbc_tournament14.gridy = 2;
		tournament_1.add(tournament[14], gbc_tournament14);
		
		tournament[12] = new JLabel("Finalist");
		GridBagConstraints gbc_tournament12 = new GridBagConstraints();
		gbc_tournament12.gridwidth = 3;
		gbc_tournament12.insets = new Insets(0, 0, 5, 5);
		gbc_tournament12.gridx = 3;
		gbc_tournament12.gridy = 3;
		tournament_1.add(tournament[12], gbc_tournament12);
		
		tournament[13] = new JLabel("Finalist");
		GridBagConstraints gbc_tournament13 = new GridBagConstraints();
		gbc_tournament13.gridwidth = 3;
		gbc_tournament13.insets = new Insets(0, 0, 5, 5);
		gbc_tournament13.gridx = 11;
		gbc_tournament13.gridy = 3;
		tournament_1.add(tournament[13], gbc_tournament13);
		
		tournament[8] = new JLabel("Semifinalist");
		GridBagConstraints gbc_tournament8 = new GridBagConstraints();
		gbc_tournament8.gridwidth = 3;
		gbc_tournament8.insets = new Insets(0, 0, 5, 5);
		gbc_tournament8.gridx = 1;
		gbc_tournament8.gridy = 4;
		tournament_1.add(tournament[8], gbc_tournament8);
		
		tournament[9] = new JLabel("Semifinalist");
		GridBagConstraints gbc_tournament9 = new GridBagConstraints();
		gbc_tournament9.gridwidth = 3;
		gbc_tournament9.insets = new Insets(0, 0, 5, 5);
		gbc_tournament9.gridx = 5;
		gbc_tournament9.gridy = 4;
		tournament_1.add(tournament[9], gbc_tournament9);
		
		tournament[10] = new JLabel("Semifinalist");
		GridBagConstraints gbc_tournament10 = new GridBagConstraints();
		gbc_tournament10.gridwidth = 3;
		gbc_tournament10.insets = new Insets(0, 0, 5, 5);
		gbc_tournament10.gridx = 9;
		gbc_tournament10.gridy = 4;
		tournament_1.add(tournament[10], gbc_tournament10);
		
		tournament[11] = new JLabel("Semifinalist");
		GridBagConstraints gbc_tournament11 = new GridBagConstraints();
		gbc_tournament11.gridwidth = 3;
		gbc_tournament11.insets = new Insets(0, 0, 5, 5);
		gbc_tournament11.gridx = 13;
		gbc_tournament11.gridy = 4;
		tournament_1.add(tournament[11], gbc_tournament11);
		
		tournament[0] = new JLabel("Challenger");
		GridBagConstraints gbc_tournament = new GridBagConstraints();
		gbc_tournament.insets = new Insets(0, 0, 5, 5);
		gbc_tournament.gridx = 1;
		gbc_tournament.gridy = 5;
		tournament_1.add(tournament[0], gbc_tournament);
		
		tournament[1] = new JLabel("Challenger");
		GridBagConstraints gbc_tournament1 = new GridBagConstraints();
		gbc_tournament1.insets = new Insets(0, 0, 5, 5);
		gbc_tournament1.gridx = 3;
		gbc_tournament1.gridy = 5;
		tournament_1.add(tournament[1], gbc_tournament1);
		
		tournament[2] = new JLabel("Challenger");
		GridBagConstraints gbc_tournament2 = new GridBagConstraints();
		gbc_tournament2.insets = new Insets(0, 0, 5, 5);
		gbc_tournament2.gridx = 5;
		gbc_tournament2.gridy = 5;
		tournament_1.add(tournament[2], gbc_tournament2);
		
		tournament[3] = new JLabel("Challenger");
		GridBagConstraints gbc_tournament3 = new GridBagConstraints();
		gbc_tournament3.insets = new Insets(0, 0, 5, 5);
		gbc_tournament3.gridx = 7;
		gbc_tournament3.gridy = 5;
		tournament_1.add(tournament[3], gbc_tournament3);
		
		tournament[4] = new JLabel("Challenger");
		GridBagConstraints gbc_tournament4 = new GridBagConstraints();
		gbc_tournament4.insets = new Insets(0, 0, 5, 5);
		gbc_tournament4.gridx = 9;
		gbc_tournament4.gridy = 5;
		tournament_1.add(tournament[4], gbc_tournament4);
		
		tournament[5] = new JLabel("Challenger");
		GridBagConstraints gbc_tournament5 = new GridBagConstraints();
		gbc_tournament5.insets = new Insets(0, 0, 5, 5);
		gbc_tournament5.gridx = 11;
		gbc_tournament5.gridy = 5;
		tournament_1.add(tournament[5], gbc_tournament5);
		
		tournament[6] = new JLabel("Challenger");
		GridBagConstraints gbc_tournament6 = new GridBagConstraints();
		gbc_tournament6.insets = new Insets(0, 0, 5, 5);
		gbc_tournament6.gridx = 13;
		gbc_tournament6.gridy = 5;
		tournament_1.add(tournament[6], gbc_tournament6);
		
		tournament[7] = new JLabel("Challenger");
		GridBagConstraints gbctournament7 = new GridBagConstraints();
		gbctournament7.insets = new Insets(0, 0, 5, 5);
		gbctournament7.gridx = 15;
		gbctournament7.gridy = 5;
		tournament_1.add(tournament[7], gbctournament7);
		
		playButton = new JButton("Play");
		GridBagConstraints gbc_playButton = new GridBagConstraints();
		gbc_playButton.insets = new Insets(0, 0, 5, 5);
		gbc_playButton.gridx = 8;
		gbc_playButton.gridy = 7;
		tournament_1.add(playButton, gbc_playButton);
		
		//the second card is the play screen
		add(play);
		
		//Initialize the class object  
		char2 = new Character(1);
		char1 = new Character(0);
		
		//Initialize the Jlabel to show the result of the battle
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
		
		lblChar1Image = new JLabel("");
		lblChar1Image.setIcon(char1.heroPic());
		GridBagConstraints gbc_lblChar1Image = new GridBagConstraints();
		gbc_lblChar1Image.insets = new Insets(0, 0, 5, 5);
		gbc_lblChar1Image.gridx = 1;
		gbc_lblChar1Image.gridy = 3;
		play.add(lblChar1Image, gbc_lblChar1Image);
		
		lblChar2Image = new JLabel("");
		lblChar2Image.setIcon(char2.heroPic());
		GridBagConstraints gbc_lblChar2Image = new GridBagConstraints();
		gbc_lblChar2Image.insets = new Insets(0, 0, 5, 5);
		gbc_lblChar2Image.gridx = 3;
		gbc_lblChar2Image.gridy = 3;
		play.add(lblChar2Image, gbc_lblChar2Image);
		
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
		rdbtnWeapon_1.setSelected(true);
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
		rdbtnWeapon_4.setSelected(true);
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
		lblChar1Block = new Label(char1.heroName() + " Shield");
		GridBagConstraints gbc_lblChar1Block = new GridBagConstraints();
		gbc_lblChar1Block.insets = new Insets(0, 0, 5, 5);
		gbc_lblChar1Block.gridx = 1;
		gbc_lblChar1Block.gridy = 10;
		play.add(lblChar1Block, gbc_lblChar1Block);
		
		//Initialize the character2 Block Label
		lblChar2Block = new Label(char2.heroName() + " Shield");
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
		rdbtnTorso.setSelected(true);
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
		rdbtnTorso_1.setSelected(true);
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
		
		//listener for the playButton
		playButton.addActionListener(new ButtonListener());
		
		//listener for the btnAttack
		btnAttack.addActionListener(new ButtonListener());
		
		//Initialize the Dice Object
		die = new Dice();  
	}
	
	/**
	 * Private method to change char1 and char2 to different characters
	 * @param replacementCharacter1 character to replace the first character, should be the integer between 0 and (numChars-1)
	 * @param replacementCharacter2 character to replace the second character, should be the integer between 0 and (numChars-1)
	 */
	private void changeChars(int replacementCharacter1, int replacementCharacter2)
	{
		//create the new character objects
		Character character1 = new Character(replacementCharacter1);
		Character character2 = new Character(replacementCharacter2);
		//replace both character objects
		char1 = character1;
		char2 = character2;
		
		//modify labels and images for both characters
		//char1 first
		//name
		char1Label.setText(char1.heroName());
		//image
		lblChar1Image.setIcon(char1.heroPic());
		//weapons
		rdbtnWeapon.setText(char1.weaponName(1) + " (10 attack, head)");
		rdbtnWeapon_1.setText(char1.weaponName(2) + " (8 attack, torso)");
		rdbtnWeapon_2.setText(char1.weaponName(3) + " (5 attack, legs)");
		//block label
		lblChar1Block.setText(char1.heroName() + " Shield");
		
		//now char2
		//name
		char2Label.setText(char2.heroName());
		//image
		lblChar2Image.setIcon(char2.heroPic());
		//weapons
		rdbtnWeapon_3.setText(char2.weaponName(1) + " (10 attack, head)");
		rdbtnWeapon_4.setText(char2.weaponName(2) + " (8 attack, torso)");
		rdbtnWeapon_5.setText(char2.weaponName(3) + " (5 attack, legs)");
		//block label
		lblChar2Block.setText(char2.heroName() + " Shield");
		
	}
	
	/**
	 * Given a character name, returns the index of the character
	 * @param characterName String to return the index of
	 * @return index of the given string
	 */
	private int stringToInt(String characterName)
	{
		int index = 0;
		int foundIndex = -1;
		//loop until String is matched, then save index in foundIndex
		while(index < Character.heroNames.length)
		{
			if(characterName.equals(Character.heroNames[index]))
				foundIndex = index;
			index++;
		}
		return foundIndex;
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
						char1Attack = char1Attack*2;
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
						char2Attack = char2Attack*2;
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
					sPanel.updateStats(char1.getHeroNum(), char2.getHeroNum(), char1Attack, char2Attack, char1AreaAttacked - 1, char2AreaAttacked - 1, char1Health + char2Attack, char2Health + char1Attack, char1Dice, char2Dice);
					
					//test whether we have a draw or a winner
					if(char1Health <= 0 && char2Health <=0){
						System.out.println("Its a draw");
						winnerLabel.setText("Draw");
					}
					else if(char1Health <= 0 && char2Health > 0){
						System.out.print(char2.heroName() + " Wins");
						winnerLabel.setText(char2.heroName() + " Wins");
						//record winner's name in a variable
						winner = char2.heroName();
						//change the button text to continue
						btnAttack.setText("Continue");
					}
					else if(char1Health >0 && char2Health <=0){
						System.out.print(char1.heroName() + " Wins");
						winnerLabel.setText(char1.heroName() + " Wins");
						//record winner's name in a variable
						winner = char1.heroName();
						//change the button text to continue
						btnAttack.setText("Continue");
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
					
					//Update the most turns statistic
					sPanel.updateMostTurns(char1.getHeroNum(),char2.getHeroNum(),turn);
					
					//Reset the turn variable
					turn = 0;
					
					//reset the health bar if the game is a draw
					if(progressBar_char1.getValue() <= 0 && progressBar_char2.getValue() <= 0)
					{
						//Reset the progress bar
						progressBar_char1.setValue(100);
						progressBar_char2.setValue(100);
					}
					//change to the tournament screen, if there is a tournament and no draw occured
					else if(tournamentInProgress)
					{
						//update tournament screen to reflect last result first
						if(numChars == 4)
						{
							tournament[11 + match].setText(winner);
						}
						else if(numChars == 8)
						{
							tournament[7 + match].setText(winner);
						}
						//increment matches then change to tournament screen
						match++;
						cardLayout.previous(thisPanel);
						
						//reset health to full
						progressBar_char1.setValue(100);
						progressBar_char2.setValue(100);
					}
					//case where it isn't a draw or tournament, 2 player match has ended
					else
					{
						progressBar_char1.setValue(100);
						progressBar_char2.setValue(100);
						cardLayout.first(thisPanel);
					}
					//change the attack button text back to attack, from continue
					btnAttack.setText("Attack");
				}
			}
			//Reached if the create button was pressed, on the creation screen
			else if(source == create)
			{
				//reset temporary stats
				//Set up the tournament screen based on number of players
				numChars = (int)numCharacters.getSelectedItem();
				
				if(numChars != 2)
				{
					tournamentInProgress = true;
					//set up the tournament screen based on the number of characters
					if(numChars == 4)
					{
						//get which characters were selected, as integers
						int selectedIndex = 0;
						//continues until 4 characters are chosen, or all JCheckBoxes checked
						for(int checkIndex = 0; checkIndex < 8 && selectedIndex < 4;checkIndex++)
						{
							if(checkBox[checkIndex].isSelected())
							{
								chosenCharacters[selectedIndex] = checkIndex;
								selectedIndex++;
							}
						}
							
						//make the lowest row invisible
						for(int index = 0; index <= 7; index++)
							tournament[index].setVisible(false);
						//make the next row the names of the characters
						for(int index = 8; index <= 11; index++)
							tournament[index].setText(Character.heroNames[chosenCharacters[index - 8]]);
						
					}
					//reached when 8 character tournament is selected
					else
					{
						//make the lowest row the names of the characters
						for(int index = 0; index <= 7; index++)
						{
							tournament[index].setText(Character.heroNames[index]);
							//make the bottom row visible, if it isn't already
							tournament[index].setVisible(true);
						}
					}
					//after setup is complete, move to the tournament screen
					cardLayout.next(thisPanel);
				}
				//skip tournament screen if only two players
				else
				{
					tournamentInProgress = false;
					int char1Int = 0;
					int char2Int = 0;
					//find which two characters are picked
					while(!checkBox[char1Int].isSelected())
						char1Int++;
					char2Int = char1Int + 1;
					while(!checkBox[char2Int].isSelected())
						char2Int++;
					changeChars(char1Int, char2Int);
					cardLayout.last(thisPanel);
				}
			}
			//Reached if the play button was pressed, on the tournament "screen"
			else if(source == playButton)
			{
				//Decide which match is next, and set up the play screen by changing labels
				int char1Int = 0;
				int char2Int = 0;
				if((match != 4 && numChars == 4) || (match != 8 && numChars == 8))
				{
					if(numChars == 4)
					{
						char1Int = stringToInt(tournament[match * 2 + 6].getText());
						char2Int = stringToInt(tournament[match * 2 + 7].getText());
					}
					else if(numChars == 8)
					{
						char1Int = stringToInt(tournament[match * 2 - 2].getText());
						char2Int = stringToInt(tournament[match * 2 - 1].getText());
					}
					//change characters
					changeChars(char1Int, char2Int);
					//reset health to full
					progressBar_char1.setValue(100);
					progressBar_char2.setValue(100);
					//change to the play screen
					cardLayout.next(thisPanel);
				}
				//case where a tournament ended
				else
				{
					tournament[8].setText("Semifinalist");
					tournament[9].setText("Semifinalist");
					tournament[10].setText("Semifinalist");
					tournament[11].setText("Semifinalist");
					tournament[12].setText("Finalist");
					tournament[13].setText("Finalist");
					tournament[14].setText("Champion");
					match = 1;
					//go back to the create screen
					cardLayout.first(thisPanel);
				}
			}
		}
	} 
}
