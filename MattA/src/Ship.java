import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.KeyStroke;

public class Ship
{
	
	
	Image img2;
	Image img1;
	int x,y;
	int xMove, yMove;
	int size;
	
	private static boolean[] keyboardState;
	
	public Ship()
	{
		
		x = (int)(Math.random()*900 - 1);
		y = 1;
		size = 50;
		xMove = 1;
		yMove = 1;
		
		
		
		try
		{
			img1 = ImageIO.read(new File("falcon.png"));
			img1 = img1.getScaledInstance(70, 40, Image.SCALE_SMOOTH);	
			
			img2 = ImageIO.read(new File("explosion.png"));
			img2 = img2.getScaledInstance(250, 200, Image.SCALE_SMOOTH);		
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public void updatePosition(int width, int height, Graphics2D g)
	{
		
		if(Ship.keyboardKeyState(KeyEvent.VK_W))
		 {
			 yMove -= 1;
			 g.drawImage(img1, x, y, null);
		 }

		else if(Ship.keyboardKeyState(KeyEvent.VK_A))
		 {
			 x -= 1;
			 g.drawImage(img1, x, y, null);
		 }

		else if(Ship.keyboardKeyState(KeyEvent.VK_D))
		 {
			 x += 1;
			 g.drawImage(img1, x, y, null);
		 }
	       
		else if(y < 570)
			{
				y += 1;
				g.drawImage(img1, x, y, null);		
			}
		
		else if(y >= 570)
			{
				Platform p = new Platform();
				if ((x + 45) == (p.getX() + 25))
				{
					g.drawImage(img1, x, y, null);
				}
				else
				{
					g.drawImage(img1, x, y, null);
					g.drawImage(img2, x - 80, y - 160, null);
				}	
			}
		 
	}
	
	public void shipMoved()
	{
		y -= 1;
	}

	private static boolean keyboardKeyState(int vkW) {
		
		System.out.println("key state: "+ vkW +" is "+ keyboardState[vkW]);
		return keyboardState[vkW];
	}

	public void setKeyState(boolean[] keyStateIn)
	{
		keyboardState = keyStateIn;
	}

}