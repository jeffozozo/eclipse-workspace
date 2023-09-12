import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class StringWriterEx
{
	String s = "Now is the time for all good men to come to the aid of their country";
	
	public void doExample()
	{
		try
		{
			FileWriter fout = new FileWriter("out.txt");
			BufferedWriter output = new BufferedWriter(fout);
			
			output.append(s);

			output.close();
			
			
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		
		

	}
}
