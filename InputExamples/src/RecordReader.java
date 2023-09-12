import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class RecordReader
{
	File inFile = new File("src/employees.txt");
	
	ArrayList<Employee> employees = new ArrayList<Employee>();
	
	public void doExample()
	{
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader(inFile));
			String line;
			
			while( (line = reader.readLine() ) != null )
			{
				Employee e = new Employee();
				
				e.name = line;
				e.age = Integer.valueOf(reader.readLine());
				e.title = reader.readLine();
				e.phone = reader.readLine();
				e.salary = Double.valueOf(reader.readLine());
		
				employees.add(e);
			}
			reader.close();
			
			for(Employee e: employees)
			{
				System.out.println(e);
			}
			
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	

}
