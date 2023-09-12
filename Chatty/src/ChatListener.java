import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class ChatListener implements Runnable
{

	  private ServerSocket serverSocket;
	  private int port;
	  

      Socket clientSocket;     
      PrintWriter out;                   
      BufferedReader in;
	  
	  public ChatListener(int portIn)
	  {
		  port = portIn;
	  }
	  
	  
	public void run()
	{
		boolean connected = false;
		while(!connected)
		{
		    try 
		    {
		        serverSocket = new ServerSocket(port);
		        clientSocket = serverSocket.accept();     
		        out = new PrintWriter(clientSocket.getOutputStream(), true);                   
		        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

		        connected = true;
		        
		    }
		    catch(IOException e)
		    {
		    	System.out.println("Error opening the listener socket: " + e.getMessage());
		    }
		}//end while

		
        String inputLine;     
        while(true)
        {
	        try
			{
				while ((inputLine = in.readLine()) != null) 
				{
					System.out.println(inputLine);
				}
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
		
	}

}