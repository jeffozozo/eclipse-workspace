
public class SpellSword extends PlayerCharacter implements Fighter, MagicUser
{

	public SpellSword(String nameIn)
	{
		super(nameIn, 30);
	}

	@Override
	public void CastSpell(String opponent)
	{
		System.out.println(name + " enchants his sword for +2 damage.");

	}

	@Override
	public void PowerAttack()
	{
		System.out.println(name + " invokes Power Attack for +2 damage.");

	}

	@Override
	public void attack(PlayerCharacter c)
	{
		CastSpell(null);
		PowerAttack();
		
		System.out.println(name +" attacks "+c.getName()+" with a sword!");
		c.takeDamage(9);

	}

}
