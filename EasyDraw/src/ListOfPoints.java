import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;


public class ListOfPoints
{
	Color theColor;
	ArrayList<Point> pointList;
	
	public ListOfPoints(Color cIn)
	{
		theColor=cIn;
		pointList = new ArrayList<Point>();
	}
	
	public void addPoint(Point pIn)
	{
		pointList.add(pIn);
	}
	
	public void addArray(ArrayList<Point> pointListIn)
	{
		pointList = pointListIn;
	}
	public Color getColor()
	{
		return theColor;
	}
	
	public int getSize()
	{
		return pointList.size();
	}
	
	public Point get(int index)
	{
		return pointList.get(index);
	}
	
	
}
