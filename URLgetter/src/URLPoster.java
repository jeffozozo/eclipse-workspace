import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;


public class URLPoster
{

	public static void main(String[] args)
	{
		try
		{
			
			/*
			POST /stockquote.asmx/GetQuote HTTP/1.1
			Host: www.webservicex.net
			Content-Type: application/x-www-form-urlencoded
			Content-Length: length
			http://www.webservicex.net/stockquote.asmx/GetQuote
			
			params:
			symbol=string
			*/
			
			URL url = new URL("http://localhost/html_form_send.php");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			
			connection.setDoOutput(true);
			connection.setRequestMethod("POST");
			
			 DataOutputStream output = new DataOutputStream(connection.getOutputStream());
			
			 // Construct the POST data.
	        String content = "first_name='jet'\r\n" +
			 "last_name='li'\r\n" +
	         "email='jet@li.com'\r\n" +
			 "telephone='734-544-5453'\r\n" +
	         "comments='my hand is faster than a bullet.'\r\n\r\n\r\n";

	        // Send the request data.
	        System.out.println("posting: " + content);
            output.writeBytes(content);
            output.flush();
            output.close();
			
            String str = null;
          
            BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while (null != ((str = input.readLine()))) 
            {
            	//String result = URLDecoder.decode(str,"UTF-8");
                System.out.println(str);
            }
            input.close ();

            
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

	}

}
