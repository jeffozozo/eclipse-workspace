import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;


public class Planet
{
	private String name;
	private double Xgravity;
	private double Ygravity;
	
	//landscape
	private int maxPoints = 30;
	private int yVariance = 160;
	private int xVariance = 30;
	
	int[] xPoly;
	int[] yPoly;
	int numPoints;
	
	LandingPad theLandingPad;
	Settings theSettings;
	Polygon planetSurface;

	double padRotation;

	
	public Planet(String nameIn, double XgravityIn, double YgravityIn, double rotationIn, Settings settingsIn)
	{
		name = nameIn;
		Xgravity = XgravityIn;
		Ygravity = YgravityIn;
		padRotation = rotationIn;
		
		theSettings = settingsIn;
		
		theLandingPad = new LandingPad(100,600,theSettings.landingPadWidth,padRotation);
		generateRandomLandscape();		
	}
	
	public void newGame()
	{
		generateRandomLandscape();
		
	}
	
	
	public String getName()
	{
		return name;
	}

	public double getYGravity()
	{
		return Ygravity;
	}	
	
	public double getXGravity()
	{
		return Xgravity;
	}
	
	public void drawPlanet(Graphics2D g2d)
	{
		theLandingPad.drawPad(g2d);		
		g2d.drawPolyline(xPoly,yPoly,numPoints);
	}
	
	public LandingPad getLandingPad()
	{
		return theLandingPad;
	}
	
	public void generateRandomLandscape()
	{		
		numPoints = (int)(Math.random()*maxPoints)+10;
		xVariance = 800/numPoints;
		int xPrev = 0;
		
		xPoly = new int[numPoints+2];
        yPoly = new int[numPoints+2];
        
        //index in the Poly array where we want to insert the landing pad
        int xPad = (int)(Math.random()*numPoints-5)+1;   
        
        xPoly[0] = -1;
        yPoly[0] = 550;
        for(int i=1; i<numPoints;i++)
        {   
        	//make the x's relative to each other.
        	xPrev = xPoly[i-1];
        	xPoly[i] = xPrev + (int)(Math.random()*xVariance)+10;
        	
        	//make the y's relative to 500.
        	yPoly[i] = 300+((int)(Math.random()*yVariance)+10);

        	if(i == xPad)
        	{
        		theLandingPad.setX(xPoly[i]);
        		theLandingPad.setY(yPoly[i]-10);//landing pad surface needs to be ABOVE the landscape or else we crash.
        		
        		//set the spot where the pad is.
        		xPoly[i+1] = xPoly[i] + theLandingPad.getWidth();
        		yPoly[i+1] = yPoly[i];
        		
        		i++;// skip the next item.
        	}
        	
        }//end for

        //ensure the last x is off the edge of the screen to make the bottom edge of the polygon be lower than landingpad.
        xPoly[numPoints-1] = 801;
        yPoly[numPoints-1] = 900;
        
        planetSurface = new Polygon(xPoly,yPoly,numPoints);
        
	}
	
	public boolean hitPlanet(Rectangle lander)
	{
		return planetSurface.intersects(lander);	
	}
	
}
