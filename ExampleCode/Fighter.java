public class Fighter extends Character 
{

	public Fighter(String nameIn, int healthIn)
	{
		super(nameIn,healthIn);
	}
	
	@Override
	public void attack() 
	{
		System.out.println("the Fighter "+name+" swings a sword.");

	}

}
