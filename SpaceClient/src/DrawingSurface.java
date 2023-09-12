import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class DrawingSurface extends JPanel
{
	private static final long serialVersionUID = 1L;
	
	Ship theShip;	
	
	//key states for flying the ship
	Boolean aKeyDown = false;
	Boolean sKeyDown = false;
	Boolean upKeyDown = false;
		
	
	public DrawingSurface(Ship shipIn)
	{
		theShip = shipIn;
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
	
	public void paintComponent(Graphics gContext)
	{
		theShip.updatePosition(getWidth(), getHeight(), (Graphics2D)gContext);
		theShip.draw((Graphics2D)gContext);
	}
}
