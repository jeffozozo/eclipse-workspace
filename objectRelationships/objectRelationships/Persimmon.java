package objectRelationships;

public class Persimmon extends Fruit 
{

	@Override
	public void eat() 
	{
		if(!cooked)
			System.out.println("Persimmons taste TERRIBLE unless you cook them.");
		else
			System.out.println("Persimmons are not very tasty, even cooked.");
		
		
	}

	@Override
	public void peel() 
	{
		// TODO Auto-generated method stub
		peeled = true;
	}
	
	public void cook()
	{
		cooked = true;
	}

}
