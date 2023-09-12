import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.BorderLayout;
import java.util.ArrayList;
public class GUI extends JFrame implements Runnable
{
	protected GamePanel Game;
	protected SettingsPanel Settings;
	protected DataManager Data;
	
	public GUI(DataManager DataIn)
	{
		Data = DataIn;
		Settings = new SettingsPanel(Data);
		Game = new GamePanel(Data);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		add(Settings, BorderLayout.NORTH);
		add(Game, BorderLayout.CENTER);
		setSize(500, 500);
		
		Menu GameMenu = new Menu(Data);
		this.setJMenuBar(GameMenu);
		
		setVisible(true);
	}

	@Override
	public void run() 
	{
		while(true)
		{
			while(Data.gameInProgress)
			{
				if(Data.gamePaused == false)
					Game.repaint();
				try 
				{
					Thread.sleep(25);
				} catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
			}
			
			while(Data.gameInProgress == false)
			{
				try 
				{
					Thread.sleep(1);
				} catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
			}
		}
	}
}
