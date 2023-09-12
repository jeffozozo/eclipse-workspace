import java.util.ArrayList;


public class Simulation 
{
	public static final int carLotSize = 50;
	
	public static void main(String[] args) 
	{
		AssemblyMachines assemblyLine = new AssemblyMachines();
		ArrayList<Car> carLot = new ArrayList<Car>();
		
		for(int i = 0; i<carLotSize;i++)
			carLot.add(new Car(Machine.generateSerialNum()));
		
		//add the machines in order and they will execute in order.
		assemblyLine.addMachine(new ChassisBuilder());
		assemblyLine.addMachine(new BodyBuilder());
		assemblyLine.addMachine(new MotorBuilder());
		
		System.out.println();
		System.out.println("... building "+carLotSize+"cars ...");
		System.out.println();
		
		for(Car car : carLot)
		{
			assemblyLine.assemble(car);
		}
		
		System.out.println();
		System.out.println("... testing "+carLotSize+" cars ...");
		System.out.println();
		
		for(Car car: carLot)
		{
			car.wind((int)Math.round(Math.random()*8));
			car.letGo();
			System.out.println();
			
		}
	}
}
