import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class House 
{
	ArrayList<ControllableObject> objectList;
	Logger log;
	
	public House(String fileName)
	{
		
		String line;
		String[] splitLine;
		objectList = new ArrayList<ControllableObject>();
		
		System.out.println("loading the house");
		//read in the house description file
		try
		{
			Scanner fileReader = new Scanner(new File(fileName));
		
			while(fileReader.hasNext())
			{
				line = fileReader.nextLine();
				splitLine = line.split(",");
				if(splitLine[1].equals("sensor"))
				{
					Sensor s = new Sensor(splitLine[0]);
					objectList.add(s);
					
				}
				else if(splitLine[1].equals("switch"))
				{
					Switch sw = new Switch(splitLine[0]);
					objectList.add(sw);
				}
			}
		}
		catch( FileNotFoundException e)
		{
			System.out.println("Error Loading House... Could not open the file "+ fileName);
		}
		
		

	}

	
	public ControllableObject findObj(String nameIn)
	{
		for(ControllableObject obj : objectList)
		{
			if(obj.getName() == nameIn)
				return obj;
		}
		
		return null;
	}
	
	public boolean insertObj(ControllableObject objIn)
	{
		//make sure the name is unique
		if(findObj(objIn.getName()) != null)
			return false;
		
		objectList.add(objIn);
		
		return true;
		
	}
	
	public String toString()
	{
		return objectList.toString();
		
	}
	
}
