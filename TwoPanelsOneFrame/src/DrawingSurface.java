import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;


public class DrawingSurface extends JPanel
{
	private ArrayList<Shape> shapeList = new ArrayList<Shape>();
	
	
	public void add(Shape sIn)
	{
		shapeList.add(sIn);
	}
	
	public void paintComponent(Graphics g)
	{
		for(Shape s: shapeList)
		{
			s.draw((Graphics2D)g);
		}
		
	}
	
	
	
}
