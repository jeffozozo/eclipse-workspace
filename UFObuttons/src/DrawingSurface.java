import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class DrawingSurface extends JPanel
{
	private static final long serialVersionUID = 1L;
	
	Ufo myUfo;
		
	
	public DrawingSurface(Ufo ufoIn)
	{
		myUfo = ufoIn;
	}
	
	public void paintComponent(Graphics gContext)
	{
		myUfo.updatePosition(getWidth(), getHeight(), (Graphics2D)gContext);
	}
}
