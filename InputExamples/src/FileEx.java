import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class FileEx
{
	File inFile = new File("src/gettysburg.txt");
	StringBuffer fileContents = new StringBuffer();
	
	public void doExample()
	{
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader(inFile));
			
			String line;
			while(( line = reader.readLine() ) != null )
			{
				fileContents.append(line + "\n");
			}
			reader.close();
			
			System.out.println("the file contained:"+ fileContents);
			
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
}
