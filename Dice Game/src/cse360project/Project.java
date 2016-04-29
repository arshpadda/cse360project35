package cse360project;

/**
 * @author Team35
 * @version April 29, 2016
 */


import javax.swing.*;
import java.util.*;
import java.awt.*;

public class Project extends JApplet
{
	//Project Class constructor 
	public Project() {
	}
	
	private int APPLET_WIDTH = 850;		//Width of the applet opened
	private int APPLET_HEIGHT = 675;	//Height of the applet opened
	private JTabbedPane tPane;			//JTabbedPane Object
	private PlayPanel playPanel;		//Play Panel Object
	private StatPanel statPanel;		//Stat Panel Object
	
	//Applet launches with two tabs
	public void init()
	{
		statPanel = new StatPanel(8, 12);
		playPanel = new PlayPanel(statPanel);
		//create a tabbed pane with two tabs
		tPane = new JTabbedPane();
		tPane.addTab("Play", playPanel);
		tPane.addTab("Stats", statPanel);
		
		getContentPane().add(tPane);
		setSize (APPLET_WIDTH, APPLET_HEIGHT); //set Applet size
	}
	
	//Destroy function when the applet closes
	public void destroy()
	{
		statPanel.writeStats();		//Write the stats before the applet is closed. 
	}
}


