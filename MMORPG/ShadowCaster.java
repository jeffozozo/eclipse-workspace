
public class ShadowCaster extends PlayerCharacter implements MagicUser, Thief
{

	public ShadowCaster(String nameIn)
	{
		super(nameIn, 20);

	}

	@Override
	public void MoveSilently()
	{
		System.out.println(name + " is moving silently...");

	}

	@Override
	public void CastSpell(String opponent)
	{
		System.out.println(name +" casts a spell out of the shadows at "+ opponent);
		
	}

	@Override
	public void attack(PlayerCharacter c)
	{
		CastSpell(c.getName());
		System.out.println(c.getName() +" takes 2 points of extra damage from surprise. ");
		c.takeDamage(7);
			
	}

}
