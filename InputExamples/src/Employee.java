import java.io.Serializable;


public class Employee implements Serializable
{

	private static final long serialVersionUID = -249618428136559409L;
	
	String name;
	int age;
	String title;
	String phone;
	double salary;

	
	public String toString()
	{
		String s = "name: "+ name + "\n" +
				   "title: " + title + "\n" +
				   "age: " + age + "\n"+
				   "phone: " + phone + "\n"+
				   "salary: " + salary + "\n\n";
				
		return s;
	}
	

}
