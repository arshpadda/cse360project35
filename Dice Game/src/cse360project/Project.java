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
	public Project() {
	}
	private int APPLET_WIDTH = 850, APPLET_HEIGHT = 675;
	private JTabbedPane tPane;
	private PlayPanel playPanel;
	private StatPanel statPanel;
	
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
	
	public void destroy()
	{
		statPanel.writeStats();
	}
}


