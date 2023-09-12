import java.awt.Color;
import java.awt.Graphics2D;

public class Moon extends Planet 
{
	public Moon(DataManager DataIn)
	{
		super(DataIn, "Moon");
		gravity = 1;
		color = Color.GRAY;		
	}
}
