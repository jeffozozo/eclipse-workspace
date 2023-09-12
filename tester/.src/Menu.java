import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;


public class Menu extends JMenuBar implements ActionListener 
{
	DataManager Data;
	
	private JMenu GameMenu;
	private JMenu SettingsMenu;
	private JMenu AboutMenu;
	
	
	private JMenuItem NewGame;
	private JMenuItem PauseGame;
	private JMenuItem ExitGame;
	private JMenuItem GameSettings;
	private JMenuItem About;
	
	public Menu(DataManager DataIn)
	{
		Data = DataIn;
		
		GameMenu = new JMenu("Game");
		NewGame = new JMenuItem("New Game");
		NewGame.addActionListener(this);
		PauseGame = new JMenuItem("Pause");
		PauseGame.addActionListener(this);
		ExitGame = new JMenuItem("Exit");
		ExitGame.addActionListener(this);
		GameMenu.add(NewGame);
		GameMenu.add(PauseGame);
		GameMenu.add(ExitGame);
		
		SettingsMenu = new JMenu("Settings");
		GameSettings = new JMenuItem("Game Settings");
		GameSettings.addActionListener(this);
		SettingsMenu.add(GameSettings);
		
		AboutMenu = new JMenu("About");
		About = new JMenuItem("About");
		About.addActionListener(this);
		AboutMenu.add(About);
		
		
		PauseGame.addActionListener(this);
		
		add(GameMenu);
		add(SettingsMenu);
		add(AboutMenu);
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == NewGame)
		{
			Data.currentPlanetIndex = 0;
			Data.newGame(0);
		}
		if (e.getSource() == PauseGame)
		{
			if(Data.gamePaused == false)
				Data.gamePaused = true;
			else
				Data.gamePaused = false;
		}
		if (e.getSource() == ExitGame)
		{
			System.exit(0);
		}
		if (e.getSource() == GameSettings)
		{
			
		}
		if (e.getSource() == About)
		{
			JOptionPane.showMessageDialog(null, "This is the Lunar Lander game made by Anthony Rodriguez, and it is probably the worst one in the class.");
		}
	}

}
