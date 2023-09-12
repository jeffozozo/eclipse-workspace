import java.awt.Color;
import java.awt.Graphics2D;


public class Pluto extends Planet 
{
	public Pluto(DataManager DataIn)
	{
		super(DataIn, "Pluto");
		gravity = 2;
		color = Color.blue;
	}

}
