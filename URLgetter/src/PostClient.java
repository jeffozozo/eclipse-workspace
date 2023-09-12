import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;




public class PostClient
{

	public static void main(String[] args)
	{
		String message = "";
		
		try
		{
			//String urlParameters = "symbol=UNH";
			String request = "http://www.webservicex.net/stockquote.asmx/GetQuote";
			
			message =
			"<soap:Body> <GetQuote xmlns=\"http://www.webserviceX.NET/\">"+
			"<symbol>UNH</symbol>"+
			"</GetQuote></soap:Body></soap:Envelope>";
			
			
			URL url = new URL(request); 
			
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();           
			connection.setDoOutput(true);
			connection.setDoInput(true);
			
			connection.setInstanceFollowRedirects(false); 
			connection.setRequestMethod("POST"); 
			connection.setRequestProperty("Content-Type", "text/xml"); 
			connection.setRequestProperty("charset", "utf-8");
			connection.setRequestProperty("Content-Length", "" + Integer.toString(message.getBytes().length));
			connection.setUseCaches (false);
	
			DataOutputStream wr = new DataOutputStream(connection.getOutputStream ());
			wr.writeBytes(message);
			wr.flush();
			wr.close();
			
            String str = null;
            
            BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while (null != ((str = input.readLine()))) 
            {

                System.out.println(str);
            }
            input.close ();
			connection.disconnect();
			
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
			
	}

}
