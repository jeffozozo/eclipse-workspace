
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Ship
{
		Image img;
		int size;
		double x = 400;
		double y = 200;
		double xMove = 0;
		double yMove = 0;
		double rotation;
		double rotationFactor = .01;
		double thrustPower = .001;
		boolean thrustersOn = false;		
		
		//lander proportions
		int width = 20;		
		Rectangle landerRect;
		
		
		
		public Ship()
		{			
			try
			{			
				img = ImageIO.read(new File("greenShip.jpeg"));
				//img = img.getScaledInstance(50, 30, Image.SCALE_SMOOTH);			
			}
			catch(IOException e)
			{
				System.out.println(e.getMessage());
			}
		}
		
		
		public void updatePosition(boolean aKey, boolean sKey, boolean upKey)
		{		
			
			if(aKey)
			{	
				rotateRight();
			}
			if(sKey)
			{	
				rotateLeft();
			}
			if(upKey)
			{
				thrustersOn = true;
				thrusters();
			}
			if(!upKey)
			{
				thrustersOn = false;
			}	

			//add gravity here
			//yMove += gravity; 
			
			x += xMove; 
			y += yMove;
			
			//create a 'hit test' rectangle here
			//landerRect = new Rectangle((int)Math.round(x-10),(int)Math.round(y),width, height+3);
			
		}
		
		public void rotateLeft()
		{
			rotation += rotationFactor;
		}
		
		public void rotateRight()
		{
			rotation -= rotationFactor;
		}
		
		public void thrusters()
		{
			thrustersOn = true;
			double xChange = (Math.cos(rotation-(Math.PI/2))*thrustPower);
			double yChange = (Math.sin(rotation-(Math.PI/2))*thrustPower);
			
			xMove += xChange;
			yMove += yChange;
			
		}
		
		public void draw(Graphics2D g)
		{
			double xcenter = x;
			double ycenter = y;
			
			AffineTransform tempAT = g.getTransform();
			g.rotate(rotation,xcenter,ycenter);
			
			//ship
			g.drawImage(img, (int)x, (int)y, null);


			//if thrusters are on, draw flames:
			if(thrustersOn)
			{
			}		
			
			//return things the way they were to be polite.
			g.setTransform(tempAT);

			
		}
		

		
}
	
	

