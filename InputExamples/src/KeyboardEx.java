import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class KeyboardEx
{
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	public void doExample()
	{
		
		String line = "";
		while(line.compareTo("quit") != 0)
		{
			try
			{
				line = reader.readLine();
			} 
			catch (IOException e)
			{
				e.printStackTrace();
			}
			
			System.out.println("you typed: "+line);
			
		}
	}
}
