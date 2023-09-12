import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


public class ChatSender implements Runnable
{
	
	String hostName = "localhost";
	int port;
	Socket echoSocket;
	PrintWriter out;
	BufferedReader in;
	BufferedReader stdIn;
	String name;
	
	public ChatSender(String nameIn, int portIn)
	{
		port = portIn;
		name = nameIn;
	}
	
	public void run()
	{
		boolean connected = false;
		while(!connected)
		{	
			try
			{
				echoSocket = new Socket(hostName, port);
				out = new PrintWriter(echoSocket.getOutputStream(), true);
				in = new BufferedReader( new InputStreamReader(echoSocket.getInputStream()));
				stdIn = new BufferedReader( new InputStreamReader(System.in)); 
				
				connected = true;
				
			    out.println("Connected to: "+name);
			    out.flush();

			} 
			catch (UnknownHostException e) 
			{
		     System.err.println("Don't know about host " + hostName);
		     System.exit(1);
			} 
			catch (IOException e) 
			{
		     System.err.println("Trying to connect to " + hostName+":"+ port);
			}

		}//end while 

		
		while(true)
		{
			String userInput;
			try
			{
				while ((userInput = stdIn.readLine()) != null) 
				 {
				     out.println(name+": "+userInput);
				     out.flush();
				 }
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
	}
}
