import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;


public abstract class Shape
{
	protected Point start,end;
	protected Color color;
	public abstract void draw(Graphics2D g);
}
