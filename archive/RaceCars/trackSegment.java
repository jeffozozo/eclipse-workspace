
public class trackSegment 
{
	double length;
	trackStyle style;
	
	//length_in is in miles. track_style is either curve or straight
	public trackSegment(double length_in, trackStyle style_in)
	{
		length = length_in;
		style = style_in;
	}
	
	public trackStyle getStyle()
	{
		return style;
	}
	
	public double getLength()
	{
		return length;
	}
	
	public String toString()
	{
		
		if(style == trackStyle.curve)
			return "curve";
		else
			return "straight";
	}
}
