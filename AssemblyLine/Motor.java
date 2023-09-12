
public class Motor extends Part
{
	public static final int springMax = 5;
	private int spring=0;
	
	public Motor(int serialNumIn)
	{
		name = "X1J";
		serialNum = serialNumIn;
	}
	
	public void wind(int inches)
	{

		//if the spring is wound too far, emit ticking sound.
		for(int i=springMax;i<inches;i++)
		{
			System.out.println("Tick!");
		}
		
		if(inches > springMax)
		{
			spring = springMax;
		}
		else
		{
			spring = inches;
		}
		
	}
	
	public int drive()
	{
		int result = spring* 10;
		spring = 0;
		
		return result;
	}
	
}
