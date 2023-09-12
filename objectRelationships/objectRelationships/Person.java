package objectRelationships;

public class Person 
{
	String name;
	String birthdate;
	
	Company myCompany;
	int Salary;
	
	public Person(String nameIn, String birthdateIn)
	{
		name = nameIn;
		
		if(dateValidator.validateDate(birthdateIn))
		{
			birthdate = birthdateIn;
		}
		
	}
	
	public void eatFruit(Fruit f)
	{
		f.eat();
	}
	
	
	
}
