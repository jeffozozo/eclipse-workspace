import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class Platform
{
	Image img1;
	int x,y;
	
	public Platform()
	{
		
		x = (int)(Math.random()*900 - 1);
		y = 595;
		
		try
		{
			img1 = ImageIO.read(new File("landing_area.png"));
			img1 = img1.getScaledInstance(120, 30, Image.SCALE_SMOOTH);			
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public void PaintLanding(int width, int height, Graphics2D g)
	{
		g.drawImage(img1, x, y, null);	 
	}
	public int getX()
	{
		return x;
	}


}
