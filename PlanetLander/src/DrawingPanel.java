import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JPanel;


public class DrawingPanel extends JPanel
{
	// the lander
	Lander lander;
	
	//some other stuff
	Stats theStats;
	Settings theSettings;
	Planet currentPlanet;

	//key states for flying the lander
	Boolean aKeyDown = false;
	Boolean sKeyDown = false;
	Boolean upKeyDown = false;
	
	JLabel pausedLabel = new JLabel("PAUSED - press any key to resume.");
	Boolean paused = true;

	
	public DrawingPanel()
	{
		add(pausedLabel);
	}
	
	public void setupGamePanel(GameLoop gameElements)
	{
		theStats = gameElements.getStats();
		theSettings = gameElements.getSettings();
		currentPlanet = gameElements.getPlanet();
		lander = gameElements.getLander();
	}
	
	public void update()
	{
		lander.updatePosition(aKeyDown,sKeyDown,upKeyDown);		
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;		
		lander.draw(g2d);	
		currentPlanet.drawPlanet(g2d);
	}
	public void setKeyState(int code, boolean state)
	{
		switch(code)
		{
			case KeyEvent.VK_UP:
			{
				upKeyDown = state;
				break;
			}
			case KeyEvent.VK_A: 
			case KeyEvent.VK_LEFT:
			{
				aKeyDown = state;
				break;
			}
			case KeyEvent.VK_S:
			case KeyEvent.VK_RIGHT:
			{
				sKeyDown = state;
				break;
			}
		}
		
	}
	
	public void setPauseState(boolean stateIn)
	{
		paused = stateIn;
		pausedLabel.setVisible(stateIn);
	}
	
	public boolean isPaused()
	{
		return paused;
	}
	
	public void restart()
	{
		
	}
	
}
