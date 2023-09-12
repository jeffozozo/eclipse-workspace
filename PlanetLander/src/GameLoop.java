import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.Timer;



public class GameLoop
{

	//game elements
	Planet thePlanet;
	Stats theStats;
	Settings theSettings;
	Lander theLander;
	
	//easy access to the UI elements
	DrawingPanel theGamePanel;
	InfoPanel theInfoPanel;
	
	//timers
	Timer updateStats;
	Timer animate;
	
	public void setupGameLoop(DrawingPanel theGamePanelIn, InfoPanel theInfoPanelIn)
	{
		theGamePanel = theGamePanelIn;
		theInfoPanel = theInfoPanelIn;
		theSettings = new Settings();
		thePlanet = new Planet("The Moon", 0.0, 0.0001, 0, theSettings);
		theStats = new Stats(theSettings, thePlanet);
		theLander = new Lander(theStats, theSettings, thePlanet);
		theLander.setupLander(this);
		
		theInfoPanel.setStats(theStats);
		theGamePanel.setupGamePanel(this);
		
		updateStats = new Timer(250,new StatUpdater());
		updateStats.start();
		
		animate = new Timer(2,new Animator());
		animate.start();		
	}


	public Planet getPlanet()
	{
		return thePlanet;
	}

	public Stats getStats()
	{
		return theStats;
	}

	public Settings getSettings()
	{
		return theSettings;
	}

	public Lander getLander()
	{
		return theLander;
	}

	
	
	public void goToNextLevel()
	{
		newGame();
	}
	
	public void newGame()
	{
		theGamePanel.setPauseState(true);
		thePlanet.newGame();		
		theLander.newGame();
		theStats.reset();

		theGamePanel.repaint();
		
	}
	
	public void restartLevel()
	{
		theGamePanel.setPauseState(true);
		theLander.newGame();
		theStats.reset();

		theGamePanel.repaint();
	}
	
	public void presentCrashedOptions()
	{
		theGamePanel.setPauseState(true);
		
		JOptionPane.showMessageDialog(null, "You crashed the lander. The lander speed must be less than " + theSettings.crashingSpeed +  
		" in order to land safely. Click OK to try again.", "Crashed!", JOptionPane.WARNING_MESSAGE);
		
		restartLevel();
		
	}
	
	public void presentLandedOptions()
	{
		theGamePanel.setPauseState(true);
	
		JOptionPane.showMessageDialog(null, "You touched down perfectly! Click OK to go to the next level.", "Landed!", JOptionPane.INFORMATION_MESSAGE);
		
		newGame();	
	}

	public class Animator implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(theGamePanel.isPaused())
				return;
			
			theGamePanel.update();
			theGamePanel.repaint();
			
		}		
	}
	
	public class StatUpdater implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			theInfoPanel.updateStats();
		}
	}
	


}
