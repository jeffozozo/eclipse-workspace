

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;



public class DateServ {

    public static void main(String[] args) throws IOException 
    {
        ServerSocket listener = new ServerSocket(8080);
        
        while(true) 
        {
            Socket theClient = listener.accept();           
            try 
            {
            	PrintWriter out = new PrintWriter(theClient.getOutputStream(), true);
                out.println(new Date().toString());
            } 
            finally 
            {
                theClient.close();
            }
               
        }
    }

}
