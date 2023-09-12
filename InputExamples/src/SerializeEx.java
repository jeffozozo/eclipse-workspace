import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class SerializeEx
{
	Employee e = new Employee();
	
	public void doExample()
	{
		e.name = "Mike TV";
		e.age = 9;
		e.phone = "888-232-5353";
		e.salary = 10.00;
		e.title = "TV Fanatic";
		
		try
		{
			ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Objects.dat"));
			
			System.out.println("Serializing: \n" + e); 
			output.writeObject(e);
			output.close();
			
			
		} catch ( IOException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		
		
	}
	
	
	
	
}
