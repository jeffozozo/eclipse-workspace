import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;


public class DrawingSurface extends JPanel
{

	ArrayList<ListOfPoints> bunchOfArrays = new ArrayList<ListOfPoints>();
	
	ListOfPoints pointList;
	
	Color drawingColor;
	
	public DrawingSurface()
	{
		MouseEvents mListener = new MouseEvents();
		addMouseListener(mListener);
		addMouseMotionListener(mListener);
		drawingColor = Color.black;
	}
	
	public void setColor(Color cIn)
	{
		drawingColor = cIn;
	}
	
	@Override
	public void paintComponent(Graphics g)
	{

		for(ListOfPoints L: bunchOfArrays )
		{	
			g.setColor(L.getColor());
			for(int i = 0; i<L.getSize() - 1 ; i++)
			{
				Point p = L.get(i);
				Point p1 = L.get(i+1);
				g.drawLine(p.x,p.y, p1.x,p1.y);
			}
		}	
	}
	
	public class MouseEvents extends MouseAdapter
	{
		@Override
		public void mouseDragged(MouseEvent e)
		{
			pointList.addPoint(e.getPoint());
			repaint();
		}
		
		@Override
		public void mousePressed(MouseEvent e)
		{
			pointList = new ListOfPoints(drawingColor);
			bunchOfArrays.add(pointList);
			pointList.addPoint(e.getPoint());
			repaint();
		}

		
	}
	
	
}
