import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Rectangle;


public class LandingPad
{
	double padRotation;
	int x, y, width;
	int height = 10;
	
	Rectangle intersect;
	
	
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public void setX(int xIn)
	{
		x = xIn;
		intersect = new Rectangle(x,y,width,height);
	}
	
	public void setY(int yIn)
	{
		y = yIn;
		intersect = new Rectangle(x,y,width,height);
	}
	
	
	public int getWidth()
	{
		return width;
	}
	
	public LandingPad(int xIn, int yIn, int widthIn, double padRotationIn)
	{
			padRotation = padRotationIn;
			x = xIn;
			y = yIn;
			width = widthIn;	
			
			intersect = new Rectangle(x,y,width,height);		
	}
	
	public void drawPad(Graphics2D g)
	{
		BasicStroke bs = new BasicStroke(2);
		g.setStroke(bs);
		g.drawRect(x,y,width,height);
	}
	 
	public Rectangle getRect()
	{
		return intersect;
	}

}
