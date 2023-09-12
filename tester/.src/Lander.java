import java.awt.Color;
import java.awt.Graphics2D;

//I never could figure out a way to make my lander look more like a real lander...
public class Lander 
{
	protected final int XINITIAL = 200;
	protected final int YINITIAL = 100;
	private int xVelocity;
	private int yVelocity;
	private int xPosition;
	private int yPosition;
	private int OnePercentofWidth;
	private int OnePercentofHeight;	
	private int height;
	private int width;
	
	Planet CurrentPlanet;
	DataManager Data;
	
	public boolean UpwardThrust;
	public boolean LeftwardThrust;
	public boolean RightwardThrust;
	int thrustPower = 4;
	
	protected int fuel;
	
	public Lander(GamePanel GameIn, Planet CurrentPlanetIn, DataManager DataIn)
	{
		xPosition = XINITIAL;
		yPosition = YINITIAL;
		xVelocity = 0;
		yVelocity = 0;		
		setCurrentPlanet(CurrentPlanetIn);
		Data = DataIn;
		fuel = 100;
	}
	
	
	public void setCurrentPlanet(Planet CurrentPlanetIn)
	{
		CurrentPlanet = CurrentPlanetIn;
	}
	
	public void reset()
	{
		xPosition = XINITIAL;
		yPosition = YINITIAL;
		xVelocity = 0;
		yVelocity = 0;
		UpwardThrust = false;
		LeftwardThrust = false;
		RightwardThrust = false;
		fuel = 100;
	}
	
	//Most of the game happens here
	public void draw(Graphics2D g)
	{		
		OnePercentofWidth = (int)(Data.WindowWidth * .01); 	//used to allow the graphics to scale with the size of the window
		OnePercentofHeight = (int)(Data.WindowHeight * .01);
		
		height =  6 * OnePercentofHeight;
		width = 3 * OnePercentofWidth;
		
		if (fuel > 0)
		{
			if (UpwardThrust)
			{
				yVelocity += thrustPower;
				fuel--;
				g.setColor(Color.RED);
				g.fillOval(xPosition, yPosition + OnePercentofHeight, width, height * 2);
			}
			if (LeftwardThrust)
			{
				xVelocity -= thrustPower;
				fuel--;
				g.setColor(Color.RED);
				g.fillOval(xPosition, yPosition + OnePercentofHeight, height, width);
			}
			if (RightwardThrust)
			{
				xVelocity += thrustPower;
				fuel--;
				g.setColor(Color.RED);
				g.fillOval(xPosition - OnePercentofWidth * 4, yPosition + OnePercentofHeight, height, width);				
			}
		}
		
		yVelocity -= CurrentPlanet.gravity;
		xPosition += xVelocity * OnePercentofWidth / 100;
		yPosition -= yVelocity * OnePercentofHeight / 25;
		
		g.setColor(Color.BLACK);
		g.fillOval(xPosition, yPosition, width, height);
		Data.yVelocity = yVelocity;
		
		if (yPosition > CurrentPlanet.yPosition)
		{
			if (yVelocity > -20 && xPosition > CurrentPlanet.target.xPosition && xPosition < CurrentPlanet.target.xPosition + CurrentPlanet.target.width)
			{
				Data.win();
			}
			else
				Data.lose();
		}
	}
}
