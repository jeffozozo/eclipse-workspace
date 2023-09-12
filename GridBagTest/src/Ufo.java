
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
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
	

	public void moveUp(Graphics g)
	{

		
		y -= 1;
		
		if(x < 1)
			y=1;
		
		g.drawImage(img, x, y, null);
				
	}

	public void moveDown(Graphics g)
	{
		Rectangle r = new Rectangle();	
		 g.getClipBounds(r);
		
		y += 1;
		if(y > r.height )
			y=r.height;
		
		g.drawImage(img, x, y, null);
				
	}

	public void moveLeft(Graphics g)
	{
		x -= 1;
		
		if(x< 1)
			x=1;
		
		g.drawImage(img, x, y, null);
				
	}

	public void moveRight(Graphics g)
	{
		Rectangle r = new Rectangle();	
		g.getClipBounds(r);
		
		x += 1;
		
		if(x> r.width)
			x=1;
		
		g.drawImage(img, x, y, null);
				
	}
	
	public void draw(Graphics g)
	{
		g.drawImage(img, x,y,null);
	}


}
