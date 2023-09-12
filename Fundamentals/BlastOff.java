import java.util.concurrent.TimeUnit;


public class BlastOff 
{
	

	public void launch()
	{
		for(int clear=0; clear < 100; clear++)
			System.out.println();

		System.out.println("  +");
		System.out.println(" / \\");
		System.out.println("|   |");
		System.out.println("|   |");
		System.out.println("|   |");
		System.out.println("|___|");
		System.out.println(" \\ /");
		System.out.println(" / \\" );
		
		
		for(int i=0;i<20;i++)
		{
			System.out.println();
			try 
			{
				TimeUnit.MILLISECONDS.sleep(250);
			} 
			catch (InterruptedException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}	
}
