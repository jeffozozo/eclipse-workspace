import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Threaded8BallServer
{
	boolean finished = false;
	ServerSocket serverSocket;
	
	int portNumber = 8888;
	
	
	private String[] answers = {"It is certain",
						"It is decidedly so",
						"Without a doubt",
						"Yes definitely",
						"You may rely on it",
						"As I see it, yes",
						"Most likely",
						"Outlook good",
						"Yes",
						"Signs point to yes",
						"Reply hazy try again",
						"Ask again later",
						"Better not tell you now",
						"Cannot predict now",
						"Concentrate and ask again",
						"Don't count on it",
						"My reply is no",
						"My sources say no",
						"Outlook not so good",
						"Very doubtful"};
	
	
	public Threaded8BallServer()
	{
		try
		{
			serverSocket = new ServerSocket(portNumber);
			
		} catch (IOException e)
		{
			System.out.println("Exception when trying to listen on port " + portNumber +" message: " + e.getMessage());
		}
	}
	
	private String ask()
	{
		return answers[(int)(Math.random()*answers.length)];
	}
	

	public void Listen()
	{
		Socket clientSocket;
		
        try 
        {
            while(!finished)
            {
                clientSocket = serverSocket.accept();                        
                System.out.println("Received a connection from: " + clientSocket.getInetAddress());
                Thread t = new Thread(new ConnectionHandler(clientSocket));
                t.start();
            }	
        } 
        catch (IOException e) 
        {
            System.out.println("Exception caught when trying to listen on port "
                + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
            System.exit(1);
        }
	}
	    
	
	public class ConnectionHandler implements Runnable
	{
		Socket client;
		
		PrintWriter out;
		BufferedReader in;

		
		public ConnectionHandler(Socket clientIn)
		{
			client = clientIn;
		}
		
		private void setupSockets(Socket client)
		{
	    	System.out.println("Magic 8 Ball Server listening on 8888.");   
	    	
	        try
			{
				out = new PrintWriter(client.getOutputStream(), true);
				in = new BufferedReader(new InputStreamReader(client.getInputStream()));

			} catch (IOException e)
			{
				System.out.println("Issues getting the in and out: " + e.getMessage());
				return;
			}                   
	        
	        out.println();
	        out.println("*** Magic 8 Ball ***");
	        out.println("Ask a yes/no question and the magic 8 ball will answer.");
	        out.flush();		
		}
		
		public void run()
		{
			String inputLine = new String();
			setupSockets(client);
			
			while(true)
			{
				try
				{
		          	if ((inputLine = in.readLine()) != null) 
		        	{
		        		if(inputLine.compareToIgnoreCase("quit") == 0)
		        		{
		        			System.out.println("client requests disconnect. Closing socket.");
		        			client.close();	
		        			return;
		        		}
		        		else
		        		{
		        			String answer = ask();
		        			System.out.println("question: " + inputLine+ " answer: "+answer);
		        			out.println(answer);
		        			out.flush();
		        		}
		        		
		        	}
		        	else
		        	{
		        		System.out.println("client disconnected. ");
		        		client.close();
		        		return;
		        		
		        	}
				}
				catch(IOException e)
				{
					System.out.println("Exception in the connection handler "+ e.getMessage());
					return;
				}
			}	
		}
	} 




			
}