import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;



public class MenuHelper
{
	GameLoop gameElements;
	DrawingPanel theGamePanel;
	Settings theSettings;
	
	JMenu game = new JMenu("Game");
	JMenu settings = new JMenu("Settings");
	JMenu help = new JMenu("Help");
	
	JMenuItem instructions = new JMenuItem("Instructions");
	JMenuItem about = new JMenuItem("About");	
	JMenuItem newGame = new JMenuItem("New Game");
	JMenuItem restartLevel = new JMenuItem("Restart Level");
	JCheckBoxMenuItem pauseGame = new JCheckBoxMenuItem("Pause");
	JMenuItem exitGame = new JMenuItem("Exit Game");
	JMenuItem gameSettings = new JMenuItem("Game Settings");
	
	public void setupMenu(JMenuBar theBar, DrawingPanel theGamePanelIn, GameLoop gameElementsIn)
	{
		theGamePanel = theGamePanelIn;		
		gameElements = gameElementsIn;
		theSettings = gameElements.getSettings();
		
		MenuHandler handler = new MenuHandler();
		
		game.add(newGame);
		game.add(restartLevel);
		game.add(pauseGame);
		game.add(exitGame);
		
		settings.add(gameSettings);
		help.add(instructions);
		help.add(about);
		
		theBar.add(game);
		theBar.add(settings);
		theBar.add(help);
		
		newGame.addActionListener(handler);
		restartLevel.addActionListener(handler);
		pauseGame.addActionListener(handler);
		exitGame.addActionListener(handler);
		
		gameSettings.addActionListener(handler);
		about.addActionListener(handler);
		instructions.addActionListener(handler);
		
		
	}
	
	public class MenuHandler implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			theGamePanel.setPauseState(true);
			
			JMenuItem choice = (JMenuItem) e.getSource();
			
			if(choice == newGame)
			{
				newGame();
			}

			if(choice == restartLevel)
			{
				restartLevel();
			}
			
			if(choice == pauseGame)
			{
				theGamePanel.setPauseState(pauseGame.getState());
			}
			
			if(choice == exitGame )
			{
				exitGame();
			}
			
			if(choice == gameSettings)
			{
				openGameSettings();
			}
			
			if(choice == about)
			{
				openAbout();
			}
			
			if(choice == instructions)
			{
				openInstructions();
			}
			
		}
		
		private void openInstructions()
		{
			JOptionPane.showMessageDialog(null, "Planet Lander is a simulated flight game where you\n " +
												"try to pilot your lander onto a landing pad without\n " +
												"crashing. You must avoid hitting anything, and the\n " +
												"lander can't be moving faster than 1 meter/sec when it\n " +
												"touches down.  There will be various planets for you\n " +
												"to try to land on. You can use the arrows as controls:\n " +
												"    ^ up arrow key fires thrusters\n"+
												"   <- left arrow key rotates to the left\n"+
												"   -> right arrow key rotates to the right\n"+
												"\n"+
												"You can also use the 'a' and 's' keys to rotate as well as\n "+
												"the control buttons at the top of the screen. Good luck!",
												"Planet Lander Instructions", JOptionPane.INFORMATION_MESSAGE);				
		}

		private void openAbout()
		{
			
			JOptionPane.showMessageDialog(null, "Planet Lander was written by Jeff Compas\n CS 3230 at Weber State University," +
			"\n Spring Semester 2014", "About Planet Lander", JOptionPane.INFORMATION_MESSAGE);
		}

		private void openGameSettings()
		{
			SettingsWindow sw = new SettingsWindow(theSettings);
			sw.setVisible(true);
			
		}

		private void exitGame()
		{
			theGamePanel.setPauseState(true);
			int confirmed = JOptionPane.showConfirmDialog(null,"Are you sure you want to exit the game?",
					"User Confirmation", JOptionPane.YES_NO_OPTION);
			if (confirmed == JOptionPane.YES_OPTION)
				Runtime.getRuntime().halt(0);
			else
				theGamePanel.setPauseState(false);
			
		}
		
		private void newGame()
		{
			int confirmed = JOptionPane.showConfirmDialog(null,"Are you sure you want to restart the game?",
					"User Confirmation", JOptionPane.YES_NO_OPTION);
			if (confirmed == JOptionPane.YES_OPTION)
			{
				pauseGame.setState(true);
				gameElements.newGame();
				
			}
		}
		
		private void restartLevel()
		{
			int confirmed = JOptionPane.showConfirmDialog(null,"Are you sure you want to restart the level?",
					"User Confirmation", JOptionPane.YES_NO_OPTION);
			if (confirmed == JOptionPane.YES_OPTION)
			{
				pauseGame.setState(true);
				gameElements.restartLevel();
				
			}
		}
		
			
	} //end of the handler class

}
