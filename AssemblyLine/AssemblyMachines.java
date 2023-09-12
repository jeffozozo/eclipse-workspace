import java.util.ArrayList;


public class AssemblyMachines 
{
	private ArrayList<Machine> machineList = new ArrayList<Machine>();
	
	public void addMachine(Machine aMachine)
	{
		machineList.add( aMachine );
	}
	
	public void assemble(Car carIn)
	{
		for(Machine m: machineList)
		{
			m.build(carIn);
		}
	}
	

}


