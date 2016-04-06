//CSE360

package cse360project;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class PlayPanel extends JPanel
{
	private JButton button1;
	private StatPanel sPanel;
	

	//Constructor initializes components and organize them using certain layouts
	public PlayPanel(StatPanel sPanel)
	{
		this.sPanel = sPanel;
		
		//listener for the button
	    //button1.addActionListener(new ButtonListener());
	}

 
	//ButtonListener is a listener class that listens to
	private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			//checks the source of the event is the button being pressed
			Object source = event.getSource();
			if(source == button1)
			{
				
			}
		}
	} 
}
