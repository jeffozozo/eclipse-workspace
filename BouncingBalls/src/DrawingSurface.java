import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;


public class DrawingSurface extends JPanel
{
	
	ArrayList<BouncingBall> ballList = new ArrayList<BouncingBall>();
	
	public void addBall()
	{
		ballList.add(new BouncingBall());
	}
	
	public void removeBall()
	{
		if(ballList.size() == 0)
			return;
		
		ballList.remove(ballList.size()-1);
	}
	
	
	@Override 
	public void paintComponent(Graphics g)
	{
		for(BouncingBall b : ballList)
		{
			b.updatePosition(getWidth(), getHeight(), (Graphics2D)g);
		}
	}
}
