import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class ScannerEx
{

	File inFile = new File("src/transaction.log");
	
	public void doExample()
	{
		try
		{
			Scanner reader = new Scanner(new FileReader(inFile));
			
			while(reader.hasNext() )
			{
				
				

			}
			reader.close();
			

			
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	



}
