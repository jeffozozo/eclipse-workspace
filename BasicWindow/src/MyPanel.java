import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;


public class MyPanel extends JPanel
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void paintComponent(Graphics graphicsContext)
	{
		super.paintComponent(graphicsContext);
		drawStuff((Graphics2D)graphicsContext);
		
	}
	
	public void drawStuff(Graphics2D gContext)
	{
		gContext.drawRect(10, 10, 100, 100);
		gContext.drawOval(10,10,100,100);
	}
	
	
	
	
	

}
