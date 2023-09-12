import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;


public class DrawingArea extends JPanel implements KeyListener
{

	private static final long serialVersionUID = 1L;
	Ufo ship = new Ufo();
	
	
	
	@Override
	public void paintComponent(Graphics g)
	{
		this.setBackground(Color.cyan);
		ship.draw(g);
		System.out.println("drawing...");
	}



	@Override
	public void keyTyped(KeyEvent e)
	{
		// nothing.
		
	}



	@Override
	public void keyPressed(KeyEvent e)
	{
		int code = e.getKeyCode();
		
		switch(code)
		{
			case  KeyEvent.VK_UP : 
			{
				ship.moveUp(this.getGraphics());
				break;
			}			 
			case  KeyEvent.VK_DOWN :
			{
				ship.moveDown(this.getGraphics());
				break;
			}			   
			case KeyEvent.VK_LEFT :
			{	
				ship.moveLeft(this.getGraphics());
				break;
			}			   
			case KeyEvent.VK_RIGHT :
			{
				ship.moveRight(this.getGraphics());
				break;
			}
		}
		
	}



	@Override
	public void keyReleased(KeyEvent e)
	{
		// TODO Auto-generated method stub
		
	}
	
	
}
