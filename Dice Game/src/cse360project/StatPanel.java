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
		//initializes components
		
		Stats stats = new Stats(numChars, numStats);
		
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
