
public abstract class PlayerCharacter
{
	int health;
	String name;
	
	
	public PlayerCharacter(String nameIn, int healthIn)
	{
		name = nameIn;
		health = healthIn;
	}
	public String getName()
	{
		return name;
	}
	
	public abstract void attack(PlayerCharacter c);
	
	public void takeDamage(int hitPoints)
	{
		
		System.out.println(name + " takes " + hitPoints + " points of damage.");
		health -= hitPoints;
		
		if(health<0)
			System.out.println(name + " is unconscious");
	}
	
}
