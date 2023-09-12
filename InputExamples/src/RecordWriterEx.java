import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.channels.FileChannel;


public class RecordWriterEx
{
	
	public void doExample()
	{
		try
		{
			FileWriter fout = new FileWriter("oneemployee.txt");
			PrintWriter output = new PrintWriter(fout);
			
			output.print("Jeff Compas");
			output.print("|");
			output.print("47");
			output.print("|");
			output.print("Director Solution Architecture");
			output.print("|");
			output.print("801-745-6338");
			output.print("|");
			output.print("6.95");
			output.println();
			
			output.close();
		
			
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		
	}

}
