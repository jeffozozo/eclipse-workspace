import java.awt.EventQueue;


public class Main
{
	public static void main(String[] args)
	{
		DataManager Data = new DataManager();
		GUI MainWindow = new GUI(Data);
		Thread thread = new Thread(MainWindow);
		thread.start();
	}
}
