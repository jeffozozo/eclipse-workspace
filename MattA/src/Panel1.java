
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;



public class Panel1 extends JPanel implements KeyListener
{
	private static boolean[] keyboardState = new boolean[525];
	private static final long serialVersionUID = 1L;
	
	int x = 1;
	int y = 1;
	
	Image backgroundImg;
	Image surfaceImg;

	Ship s;
	Platform p;
	
	public Panel1()
	{
		
		try
		{
			backgroundImg = ImageIO.read(new File("background.png"));
			backgroundImg = backgroundImg.getScaledInstance(1000, 600, Image.SCALE_SMOOTH);
			
			surfaceImg = ImageIO.read(new File("surface.jpg"));
			surfaceImg = surfaceImg.getScaledInstance(1000, 100, Image.SCALE_SMOOTH);
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
		
		s = new Ship();
		p = new Platform();
		
		this.addKeyListener(this);
		
	}	
	
	
	public void paintComponent(Graphics gContext)
	{
		gContext.drawImage(backgroundImg, 1, 1, null);
		gContext.drawImage(surfaceImg, 1, 600, null);
		s.setKeyState(keyboardState);
		s.updatePosition(getWidth(), getHeight(), (Graphics2D)gContext);
		p.PaintLanding(getWidth(), getHeight(), (Graphics2D)gContext);
		
	}


	public static boolean keyboardKeyState(int key)
    {
        return keyboardState[key];
    }
    
    // Methods of the keyboard listener.
    @Override
    public void keyPressed(KeyEvent e) 
    {
 
        keyboardState[e.getKeyCode()] = true;
    }
    
    @Override
    public void keyReleased(KeyEvent e)
    {
        keyboardState[e.getKeyCode()] = false;
    }


	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}  
	
	
	
	
    
}













