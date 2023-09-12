import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;


import javax.swing.JPanel;


public class MyPanel extends JPanel
{

	private static final long serialVersionUID = 1L;
	
	public void paintComponent(Graphics graphicsContext)
	{
		super.paintComponent(graphicsContext);
		drawStuff(graphicsContext);	
	}
	
	public void drawStuff(Graphics gContext)
	{
		 Graphics2D g2D = (Graphics2D) gContext;
		
		 g2D.setStroke(new BasicStroke(3));
		 g2D.setColor(Color.BLUE);
		 
		 for(int count=0;count<100;count++)
		 {
			 int x = (int) (Math.random() * this.getWidth());
			 int y = (int) (Math.random() * this.getHeight());

			 g2D.drawLine(x,y,x,y);
			 
		 }
		 
		
	}
	
	
	
	
	

}
