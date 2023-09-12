
public class Body extends Part
{

	private String color="unpainted";
	
	public Body(String nameIn, int serialNumIn)
	{
		name = nameIn;
		serialNum = serialNumIn;
	}
	
	public void paint(String colorIn)
	{
		color = colorIn;

	}
	
	public String getColor()
	{
		return color;
	}
	

}
