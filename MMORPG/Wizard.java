
public class Wizard extends PlayerCharacter implements MagicUser
{

	public Wizard(String nameIn)
	{
		super(nameIn, 15);
	}

	
	@Override
	public void CastSpell(String opponent)
	{
		System.out.println(name + " casts a spell at " + opponent);

	}

	@Override
	public void attack(PlayerCharacter c)
	{
		if(health<0)
		{
			System.out.println(name + " is unconscious and cannot attack.");
			return;
		}
		
		CastSpell(c.getName());	
		c.takeDamage(5);

	}

}
