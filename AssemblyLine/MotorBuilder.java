
public class MotorBuilder extends Machine 
{
	public void build(Car carIn) 
	{
		Motor theMotor = new Motor(Machine.generateSerialNum());	
		carIn.setMotor(theMotor);
	}

}
