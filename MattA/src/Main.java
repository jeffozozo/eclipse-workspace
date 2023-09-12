import java.awt.EventQueue;

import javax.swing.Timer;

public class Main
{
	public static Timer t; 
	
	public static void main(String[] args)  
	{
	
		Frame f = new Frame();
		EventQueue.invokeLater(f);
		
		t = new Timer(10, f);
		t.start();
	}

}