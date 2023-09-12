
public class Student 
{
	String name;
	String ID;
	
	public Student(String nameIn, String IDIn)
	{
		ID = IDIn;
		name = nameIn;
	}
	
	public void printStudent()
	{
		System.out.println("Student Name: "+name);
		System.out.println("Student ID: "+ID);
		
	}
	
	
}
