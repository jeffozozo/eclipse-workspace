
public class Car 
{
	private Chassis chassis;
	private Motor motor;
	private Body body;
	private int serialNum;
	
	public Car(int serialNumIn)
	{
		serialNum = serialNumIn;
	}
	
	public void setChassis(Chassis chassis) 
	{
		this.chassis = chassis;
	}

	public void setMotor(Motor motor) 
	{
		this.motor = motor;
	}

	public void setBody(Body body) 
	{
		this.body = body;
	}

	public void wind(int inches)
	{
		System.out.println("Winding Motor " + inches + " inches.");
		motor.wind(inches);
	}
	
	public void letGo()
	{
		int distance=0;
		
		if(chassis.rolls())
		{
			distance = motor.drive();
		}
		
		System.out.println(body.getColor() +" " + body.getPartName() + " S/N:" + serialNum + " rolls for " + distance + " inches.");
		
		
	}
	
	
	public String toString()
	{
		String s = "car S/N " + serialNum + ": \n";
		
		s += "chassis: ";
		if(chassis != null)
		{
			s += chassis.getPartName()+ " " + chassis.getSerialNum() + "\n";
		}
		else
		{
			s+= " not built.\n";
		}
			
		s+= "motor: ";
		if(motor != null)
		{
			s += motor.getPartName() + " " + motor.getSerialNum() + "\n";
		}
		else
		{
			s += " not built.\n";
		}
		
		s+= "body: ";
		if(body != null)
		{
			s += body.getPartName() + " " + body.getSerialNum() + "\n";
		}
		else
		{
			s+= " not built.\n";
		}	
		
		return s;
		
	}
}
