import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Nathan on 4/8/14.
 */
public class Main
{
    public static void main(String[] args)
    {
        Server server = new Server();
        server.listen();

    }
}
