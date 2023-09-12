
public class MainGame
{

	public static void main(String[] args)
	{
		Wizard b = new Wizard("Balzar");
		Wizard q = new Wizard("Quixo");
		ShadowCaster s = new ShadowCaster("Shalinda the silent huntress");	
		SpellSword g = new SpellSword("Gazonk");
		
		s.MoveSilently();
		b.attack(q);
		s.attack(b);
		g.attack(s);
		
		

	}

}
