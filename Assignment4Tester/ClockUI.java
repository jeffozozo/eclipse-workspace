import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;


public class  ClockUI extends JFrame implements Runnable, ActionListener
{
	
	private static final long serialVersionUID = 1L;

	public void run()
	{
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(425, 460);
		setTitle("Clock");
		this.setLocationRelativeTo(this);
		add (new ClockSurface());
		setVisible(true);
		
		
		
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		
	}

}
