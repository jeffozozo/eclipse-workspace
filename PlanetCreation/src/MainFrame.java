import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class MainFrame extends JFrame implements Runnable
{

	public MainFrame()
	{
		setTitle("Basic Window");
		setSize(300,300);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);
		
		addWindowListener(new WindowCloser());
	}
	
	@Override
	public void run()
	{
		setVisible(true);
	}
	
	public class WindowCloser extends WindowAdapter
	{
		@Override
		public void windowClosing(WindowEvent e)
		{
			int confirmed = JOptionPane.showConfirmDialog(null,"Are you sure you want to exit?",
					"User Confirmation", JOptionPane.YES_NO_OPTION);
			if (confirmed == JOptionPane.YES_OPTION)
				dispose();	
			else
				setVisible(true);	
		}
	}
}
