package refDemo;

public class RefDemo
{
	public static void main(String[] args)
	{
		Employee emp = new Employee("Cranston Snort", 12345);
		System.out.println(emp);
		aMethod(emp);
		System.out.println(emp);
		bMethod(emp);
		System.out.println(emp);
	}

	public static void aMethod(Employee e)
	{
		e = new Employee("Fred Flintstone", 10034);
	}
	
	public static void bMethod(Employee e)
	{
		e.setEmpNumber(22222);
		
	}
	
} // class RefDemo



class Employee
{	private	String	name;
	private	int	empNumber;

	public Employee(String name, int empNumber)
	{
		this.name = name;
		this.empNumber = empNumber;
		
		
		
	}
	
	public void setEmpNumber(int num_in)
	{
		this.empNumber = num_in;
	}

	public String toString()
	{
		return name + " " + empNumber;
	}
} // class Employee
