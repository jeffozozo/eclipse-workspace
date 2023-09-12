
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
		xMove = 1;
		yMove = 1;
		
		try
		{
			// load the image and then make it a little smaller. note that I say img = img...  I'm overwriting it
			// because of the way getScaledInstance works. It doesn't modify the original (like string.replace)
			// instead it returns a new, scaled copy. 
			
			img = ImageIO.read(new File("ufo.png"));
			img = img.getScaledInstance(50, 30, Image.SCALE_SMOOTH);			
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public void updatePosition(int width, int height, Graphics2D g)
	{
		x += xMove;
		y += yMove;
		
		//randomly change directions
		if(Math.random()*100 < 5)
		{
			xMove = (int)(Math.random()*10-5);
			yMove = (int)(Math.random()*10-5);					
		}
		
		//does this look familiar?
		if(x > width - size)
		{	
			x = width - size;
			xMove *= -1;
		}

		if(x < 1)
		{
			x = 1;
			xMove *= -1;
		}	

		if(y > height - size )
		{
			y = height - size;
			yMove *= -1;
		}

		if(y < 1)
		{
			y = 1;
			yMove *= -1;			
		}
		
		g.drawImage(img, x, y, null);
		
		
	}


}
