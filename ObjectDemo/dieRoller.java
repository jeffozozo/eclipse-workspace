
public class dieRoller

{

	public static void main(String args[])
	{
		die d1 = new die(6);
		die d2 = new die(6);
		
		for(int i = 0; i< 100;i++)
		{
			System.out.println(d1.roll() + d2.roll());
			
		}
		
	}
}
