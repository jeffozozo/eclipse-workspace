
public class Magic 
{
	//magic is the outer class
	
	private int formula = 123;
	
	public void doSomething()
	{
		innerMagic inside = new innerMagic();
		
		inside.changeFormula();
		
	}
	
	
	
	public class innerMagic
	{
		//I can access the secret formula from in here:
		
		public void changeFormula()
		{
			formula = 321;
			System.out.println("You'll never know the formula");
		}
		
		
	}
	
	
}
