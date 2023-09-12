import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;

public class Lander
{
	//lander location and movement variables
	double x = 400;
	double y = 200;
	double gravity = .0001;
	double xMove = 0;
	double yMove = 0;
	double rotation;
	double rotationFactor = .01;
	double thrustPower = .001;
	boolean thrustersOn = false;
	
	//necessary stuff
	Stats theStats;
	Settings theSettings;
	Planet thePlanet;
	GameLoop gameElements;
	
	//lander proportions
	int width = 20;
	int height = 15; //includes engines
	
	int engineHeight = 5;
	int engineWidth = 7;
	int engineOffset = 5;
	
	int flameWidth = 3;
	int flameHeight = 8;
	
	Rectangle landerRect;
	
	
	Color shipColor = Color.DARK_GRAY;
	
	
	public Lander(Stats theStatsIn, Settings theSettingsIn, Planet thePlanetIn)
	{
		theStats = theStatsIn;
		theSettings = theSettingsIn;
		thePlanet = thePlanetIn;
		
		gravity = thePlanet.getYGravity();	
		
		xMove = theSettings.xInit;
		yMove = theSettings.yInit;
	}
	
	public void setupLander(GameLoop gameElementsIn)
	{
		gameElements = gameElementsIn;
	}
	
	
	//assumes the planet has been reset first
	public void newGame()
	{
		x = 400;
		y = 200;
		gravity = thePlanet.getYGravity();
		rotation = 0;
		
		xMove = theSettings.xInit;
		yMove = theSettings.yInit;
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
		
		yMove += gravity; 
		
		x += xMove; 
		y += yMove;
		
		theStats.landerSpeed = 80*(Math.abs(xMove) + Math.abs(yMove));
		theStats.landerAltitude = -1 * (y+height - thePlanet.getLandingPad().getY());
				
		landerRect = new Rectangle((int)Math.round(x-10),(int)Math.round(y),width, height+3);
		
		checkLand();
		checkCrash();
	}

	private void checkLand()
	{
		
		LandingPad landing = thePlanet.getLandingPad();
		
		if( landerRect.intersects(landing.getRect()) )
		{
			if(theStats.landerSpeed < theSettings.crashingSpeed && Math.cos(rotation) > 0.91 )
			{
				landed();
			}
			else
			{
				crashed();
			}
		}
	}
	
	private void checkCrash()
	{
		if(thePlanet.hitPlanet(landerRect))
			crashed();
	}
	
	private void crashed()
	{
		//the lander crashed.

		xMove = 0;
		yMove = 0;
		gravity = 0;
	
		gameElements.presentCrashedOptions();
	
	}
	
	private void landed()
	{
		//the lander landed.
		xMove = 0;
		yMove = 0;
		gravity = 0;

		gameElements.presentLandedOptions();
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
		
		theStats.fuelRemaining -= theSettings.fuelPerThruster;
		
		xMove += xChange;
		yMove += yChange;
		
	}
	
	public void draw(Graphics2D g)
	{
		double xcenter = x;
		double ycenter = y+height/2;
		
		Color temp = g.getColor();
		BasicStroke tempStroke = (BasicStroke) g.getStroke();
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		BasicStroke stroke = new BasicStroke(2,BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER);
		g.setStroke(stroke);
		g.setColor(shipColor);
		
		AffineTransform tempAT = g.getTransform();
		g.rotate(rotation,xcenter,ycenter);
		
		//ship
		drawTriangle(x,y,height-engineHeight,width,g);

		//engines
		drawTriangle(x-engineOffset,y+height-engineHeight,engineHeight, engineWidth, g);
		drawTriangle(x+engineOffset,y+height-engineHeight,engineHeight, engineWidth, g);
		
		//if thrusters are on, draw flames:
		if(thrustersOn)
		{
			g.drawLine((int)(x-engineOffset-flameWidth),(int)(y+height), (int)(x-engineOffset),(int)(y+height+flameHeight));
			g.drawLine((int)(x-engineOffset),(int)(y+height+flameHeight),(int)(x-engineOffset+flameWidth),(int)(y+height));

			g.drawLine((int)(x+engineOffset-3),(int)(y+height), (int)(x+engineOffset),(int)(y+height+8));
			g.drawLine((int)(x+engineOffset),(int)(y+height+8),(int)(x+engineOffset+3),(int)(y+height+1));	
		}	
		
		//return things the way they were to be polite.
		g.setTransform(tempAT);
		g.setColor(temp);
		g.setStroke(tempStroke);
		
	}
	
	private void drawTriangle(double xIn, double yIn, double hIn, double wIn, Graphics2D g)
	{
		int x = (int)Math.round(xIn);
		int y = (int)Math.round(yIn);
		int w = (int)Math.round(wIn);
		int h = (int)Math.round(hIn);
		
		g.drawLine(x,y,x-w/2,y+h);
		g.drawLine(x-w/2, y+h,x+w/2, y+h);
		g.drawLine(x+w/2,y+h,x,y);
	}
	
}
