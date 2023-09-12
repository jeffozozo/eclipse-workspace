import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class MainFrame extends JFrame implements Runnable, ActionListener
{
	

	@Override
	public void run()
	{
		Ship myShip = new Ship();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 500);
		setLocationRelativeTo(null);
		setTitle("Spaceship!");
		
		DrawingSurface ds = new DrawingSurface();
		
		setLayout(new BorderLayout());	
		add(new DrawingSurface(),BorderLayout.CENTER);

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		repaint();
	}

}
