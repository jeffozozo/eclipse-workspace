import java.awt.EventQueue;



public class MainClass
{
	static int startThreads = 1;

	public static void main(String[] args)
	{
		//setup the dashboard
		DashBoardFrame theFrame = new DashBoardFrame();
		EventQueue.invokeLater(theFrame);
		
		Simulation sim = new Simulation(theFrame);
		
		sim.start();
	    
		
	}
	


}
