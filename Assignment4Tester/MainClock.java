import java.awt.EventQueue;
import javax.swing.Timer;



public class MainClock {
	public static Timer t;
	
	public static void main(String[] args) {
		ClockUI NClock = new ClockUI();
		EventQueue.invokeLater(NClock);
		t=new Timer(100,NClock);// updates 10 time a sec 
		t.start();

	}

}
