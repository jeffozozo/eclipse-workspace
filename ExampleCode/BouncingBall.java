import java.awt.Color;
import java.awt.Graphics2D;



// a class that manages the position of randomly colored ball, and draws it.
public class BouncingBall
{
	private int x,y;
	private int xMove, yMove;
	public final static int size = 20; //size of the ball
	private Color c;
	
	
	public BouncingBall()
	{
		x = (int)(Math.random()*200)+10; //starting position
		y = (int)(Math.random()*200)+10; //starting position
		
		xMove = (int)(Math.random()*10)-5; //starting velocity
		yMove = (int)(Math.random()*10)-5; //starting velocity		
		
		//pick a random color
		c = new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
	}
	
	//pass in the height and width of the current window so we can tell where we should bounce
	public void updatePosition(int width, int height, Graphics2D g)
	{
		
		//update the position
		y += yMove;
		x += xMove;
		
		//if the ball moves to the right edge of the window, turn around. 
		if(x > width - size)
		{	
			x = width - size;
			xMove *= -1;
		}
		
		//if the ball moves to the left edge of the window, turn around.
		if(x < 1)
		{
			x = 1;
			xMove *= -1;
		}
			
		//if the ball moves to the bottom of the screen, turn around.
		if(y > height - size )
		{
			y = height - size;
			yMove *= -1;
		}
		
		//if the ball moves to the top of the screen, turn around.
		if(y < 1)
		{
			y = 1;
			yMove *= -1;			
		}
		
		g.setColor(c);
		g.fillOval(x, y, size, size);
	}
	
	
}
