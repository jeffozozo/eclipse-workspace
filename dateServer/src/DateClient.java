

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class DateClient 
{
    public static void main(String[] args) throws IOException 
    {
        Socket theServer = new Socket("localhost", 8080);   
        BufferedReader input = new BufferedReader(new InputStreamReader(theServer.getInputStream()));
        String answer = input.readLine();
        
        System.out.println("The date is: " + answer);
    }
}