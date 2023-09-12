
public abstract class Character 
{
	protected String name;
	protected int health;
	
	public Character(String nameIn, int healthIn)
	{
		name = nameIn;
		health= healthIn;
	}
	
	public abstract void attack();
	
}
