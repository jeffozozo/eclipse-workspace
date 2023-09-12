
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Ufo 
{
	Image img;
	int x,y;
	int xMove, yMove;
	int size;
	
	//Constructor
	public Ufo()
	{
		
		x = 1;
		y = 1;
		size = 50;
		xMove = 10;
		yMove = 10;
		
		try
		{			
			img = ImageIO.read(new File("ufo.jpeg"));
			img = img.getScaledInstance(50, 30, Image.SCALE_SMOOTH);			
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public void moveUp()
	{
		y = y - yMove;
	}
	
	public void moveDown()
	{
		y = y + yMove;

		
	}
	
	public void moveLeft()
	{
		x = x - xMove;
		
		if(x < 1)
		{
			x = 1;
		}	

	}
	
	public void moveRight()
	{
		x = x + xMove;
	
		
	}
	
	public void updatePosition(int width, int height, Graphics2D g)
	{
		g.drawImage(img, x, y, null);		
	}


}
