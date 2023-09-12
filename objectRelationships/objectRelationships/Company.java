package objectRelationships;

public class Company 
{
	String name;
	
	Person[] employee_list;
	
	public Company(Person[] employees)
	{
		employee_list = employees;
		
	}
	
	
}
