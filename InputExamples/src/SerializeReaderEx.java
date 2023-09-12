import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


public class SerializeReaderEx
{
	Employee e;
	
	public void doExample()
	{
		try
		{
			ObjectInputStream input = new ObjectInputStream(new FileInputStream("Objects.dat"));
			
			e = (Employee)input.readObject();
			System.out.println("the guy made it!: \n"+ e);
			
		}
		catch (IOException | ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
