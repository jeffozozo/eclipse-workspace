import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Nathan on 4/8/14.
 */
public class Server
{
    String[] answers;
    boolean done;

    public Server()
    {
        answers = new String[]{"It is certain","It is decidedly so","Without a doubt","Yes definitely",
                "You may rely on it","As I see it, yes","Most likely","Outlook good","Yes","Signs point to yes",
                "Reply hazy try again","Ask again later","Better not tell you now","Cannot predict now",
                "Concentrate and ask again","Don't count on it","My reply is no","My sources say no","Outlook not so good",
                "Very doubtful"};

        done = false;
    }

    public void listen()
    {
        while (!done)
        {
            try
            {
                ServerSocket s = new ServerSocket(8888);
                Socket incoming = s.accept();
                try
                {
                    InputStream inStream = incoming.getInputStream();
                    OutputStream outStream = incoming.getOutputStream();

                    Scanner in = new Scanner(inStream);
                    PrintWriter out = new PrintWriter(outStream, true);

                    out.println("Welcome to the Magic 8 Ball Server!  Please ask me a question.");
                    out.println("Enter DISCONNECT to disconnect or type EXIT to exit.");
                    System.out.println("Client connected. ");
                    
                    boolean inDone = false;
                    while(!inDone && in.hasNextLine())
                    {
                        String line = in.nextLine();
                        if (line.trim().equalsIgnoreCase("DISCONNECT"))
                        {
                            inDone = true;
                        }
                        else if (line.trim().equalsIgnoreCase("EXIT"))
                        {
                            inDone = true;
                            done = true;
                        }
                        else
                        {
                            out.println("Your question: \"" + line + "\"");
                            Random rand = new Random();
                            int randomNum = rand.nextInt(20);
                            out.println("Answer: " + answers[randomNum]);
                            System.out.println("Your question: \"" + line + "\"");
                            System.out.println("Answer: " + answers[randomNum]);

                        }
                    }
                }
                finally
                {
                    incoming.close(); //when the user types "disconnect", this will automatically get called
                                        //because the internal while loop will be broken
                    System.out.println("Client disconnected. ");
                }
            }
            catch (IOException e)
            {
                //e.printStackTrace();

            }
        }
    }
}
