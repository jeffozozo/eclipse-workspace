
public class Mage extends Character 
{

	public Mage(String nameIn, int healthIn)
	{
		super(nameIn,healthIn);
	}
	
	@Override
	public void attack() 
	{
		System.out.println("the Mage "+name+" casts a spell.");

	}

}
