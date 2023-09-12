import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;


public class DrawingSurface extends JPanel 
{

	final int circleSize = 2; 
	ArrayList<Point> points = new ArrayList<Point>();
	
	public DrawingSurface()
	{
		MouseAction mListener = new MouseAction();
		addMouseListener(mListener);
		addMouseMotionListener(mListener);
	}
	
	
	@Override
	public void paintComponent(Graphics g)
	{
		for(Point p: points)
		{
			g.fillOval(p.x, p.y, circleSize, circleSize);
		}
	}
	
	public class MouseAction extends MouseAdapter
	{
		@Override
		public void mousePressed(MouseEvent e)
		{
			
			points.add(e.getPoint());
			repaint();
		}
		
		@Override
		public void mouseDragged(MouseEvent e)
		{
			points.add(e.getPoint());
			repaint();
		}
		
	}
	
	
}
