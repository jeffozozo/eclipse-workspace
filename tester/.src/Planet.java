import java.awt.Color;
import java.awt.Graphics2D;


public abstract class Planet 
{
	protected String name;
	protected int gravity;
	protected Color color;
	protected LandingZone target;
	protected int xPosition;
	protected int yPosition;
	protected int width;
	protected int height;
	protected DataManager Data;
	
	public Planet(DataManager DataIn, String nameIn)
	{
		Data = DataIn;
		name = nameIn;
		
		target = new LandingZone(Data);
	}
	
	public void draw(Graphics2D g)
	{
		xPosition = 0;
		yPosition = (int)(Data.WindowHeight * .9);
		width = Data.WindowWidth;
		height = (int)(Data.WindowHeight * .1);
		g.setColor(color);
		g.fillRect(xPosition, yPosition, width, height);
		target.draw(g, yPosition);
	}
}
