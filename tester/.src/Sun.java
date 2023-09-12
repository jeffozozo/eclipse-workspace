import java.awt.Color;

public class Sun extends Planet 
{
	public Sun(DataManager DataIn)
	{
		super(DataIn, "Sun");
		gravity = 4;
		color = Color.YELLOW;		
	}
}
