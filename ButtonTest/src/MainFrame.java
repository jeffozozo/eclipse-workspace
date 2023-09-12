import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class MainFrame extends JFrame implements Runnable
{
	private static final long serialVersionUID = 1L;
	
	JPanel gumbyPanel;
	
	public MainFrame()
	{
		setTitle("Button Lab");
		setSize(300,200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		gumbyPanel = new ButtonPanel();	
		add(gumbyPanel);
		
	}

	@Override
	public void run()
	{
		setVisible(true);	
	}
	


	
	
	
}
