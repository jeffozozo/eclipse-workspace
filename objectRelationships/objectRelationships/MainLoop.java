package objectRelationships;

public class MainLoop 
{
	public static void main(String args[])
	{
		Company BestBuy;
		
		Person jeff = new Person("Jeff","02/07/1967");
		Persimmon p = new Persimmon();
		Banana b = new Banana();
		Fruit f = new Apple();
		
		
		jeff.eatFruit(b);
		b.peel();
		
		jeff.eatFruit(b);
		
		jeff.eatFruit(p);
		p.cook();
		
		jeff.eatFruit(p);
		jeff.eatFruit(f);
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
