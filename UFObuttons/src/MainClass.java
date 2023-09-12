import java.awt.EventQueue;

import javax.swing.Timer;



public class MainClass
{
	public static Timer t; 
	
	public static void main(String[] args)  
	{

		UI myUI = new UI();
		EventQueue.invokeLater(myUI);
		
		t = new Timer(50, myUI);
		t.start();
	}

}
