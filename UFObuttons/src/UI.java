import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;


public class UI extends JFrame implements Runnable, ActionListener
{
	

	@Override
	public void run()
	{
		Ufo myUfo = new Ufo();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 500);
		setLocationRelativeTo(null);
		setTitle("UFO!");
		
		setLayout(new BorderLayout());
		add(new UIPanel(myUfo), BorderLayout.PAGE_START);		
		add(new DrawingSurface(myUfo),BorderLayout.CENTER);

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		repaint();
	}

}
