import javax.swing.JFrame;


public class MainFrame extends JFrame implements Runnable
{

	public MainFrame()
	{
		setTitle("Mouse Testing");
		setSize(300,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		
	}
	
	@Override
	public void run()
	{
		setVisible(true);
	}

}