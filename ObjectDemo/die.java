
public class die 
{
	int numSides;
	
	public die(int sides_in)
	{
		numSides = sides_in;
	}
	
	public int roll()
	{
		return (int) (Math.random() * numSides) + 1; 
				
	}	
}
