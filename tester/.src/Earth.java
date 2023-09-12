import java.awt.Color;

public class Earth extends Planet 
{
	public Earth(DataManager DataIn)
	{
		super(DataIn, "Earth");
		gravity = 3;
		color = Color.GREEN;		
	}
}
