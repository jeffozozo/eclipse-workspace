
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;


public class ClockSurface extends JPanel
{
	
	private static final long serialVersionUID = 1L;
	Move Nmove = new Move();
	
	
	public void paintComponent( Graphics g)
	{
		Graphics2D g2 = (Graphics2D)g;				
		Nmove.MoveMe(getWidth(), getHeight(), g2);		
		
	}	

}
