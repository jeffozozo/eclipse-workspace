import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;


public class Line extends Shape
{

	public Line(Point p1, Point p2, Color cIn)
	{
		start = p1;
		end = p2;
		color = cIn;
	}
	
	@Override
	public void draw(Graphics2D g)
	{
		g.setColor(color);
		g.drawLine(start.x,start.y,end.x,end.y);

	}

}
