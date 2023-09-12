import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;


public class SocketTest
{

	public static void main(String[] args)
	{
		try
		{
			Socket s = new Socket("localhost",8888);
			try
			{
				InputStreamReader inStream = new InputStreamReader(s.getInputStream());
				BufferedReader in = new BufferedReader(inStream);
				String text;
				
				while((text = in.readLine()) != null)
				{
					System.out.println(text);
				}	
				
			}
			finally
			{
				s.close();
			}
			
			
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}

	}

}
