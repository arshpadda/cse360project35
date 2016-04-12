//CSE360

package cse360project;
import javax.swing.*;
import java.util.*;

public class Project extends JApplet
{
	private int APPLET_WIDTH = 850, APPLET_HEIGHT = 450;
	private JTabbedPane tPane;
	private PlayPanel playPanel;
	private StatPanel statPanel;
	
	//Applet launches with two tabs
	public void init()
	{
		statPanel = new StatPanel(2, 11);
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


