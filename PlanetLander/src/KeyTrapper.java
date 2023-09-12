import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class KeyTrapper implements KeyListener
{
	private DrawingPanel theGamePanel;
	
	public KeyTrapper(DrawingPanel panelIn)
	{
		theGamePanel = panelIn;
	}
	
	@Override
	public void keyTyped(KeyEvent e){}

	@Override
	public void keyPressed(KeyEvent e)
	{
		theGamePanel.setPauseState(false);
		theGamePanel.setKeyState(e.getKeyCode(),true);
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		theGamePanel.setKeyState(e.getKeyCode(),false);
	}

}
