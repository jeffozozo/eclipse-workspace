package objectRelationships;

public class Banana extends Fruit 
{

	public Banana()
	{
		peeled = false;
		poisonous = false;
	}
	
	@Override
	public void eat() 
	{
		if(!peeled)
			System.out.println("You cannot eat a banana, unless it is peeled.");
		else
			System.out.println("Yum!  Bananas are delicious, and healthy for you.");
		
	}

	@Override
	public void peel() 
	{
		peeled = true;
	}
	

}
