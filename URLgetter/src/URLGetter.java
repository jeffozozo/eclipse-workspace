import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


public class URLGetter
{

	public static void main(String[] args)
	{
		URL url;
		try
		{
			url = new URL("http://slashdot.org");

			URLConnection connection = url.openConnection();
			
			connection.setDoOutput(true);
			
			BufferedReader in = new BufferedReader( new InputStreamReader(connection.getInputStream()));
			String decodedString;
			
			while ((decodedString = in.readLine()) != null) 
			{
				System.out.println(decodedString);		
			}
				
			in.close();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		


	}
	
	
	
	

}
