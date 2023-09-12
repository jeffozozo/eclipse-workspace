public class Thief extends Character 
{

	public Thief(String nameIn, int healthIn)
	{
		super(nameIn,healthIn);
	}
	
	@Override
	public void attack() 
	{
		System.out.println("the Thief "+name+" steals the weapon.");

	}

}