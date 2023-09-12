import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class RightKeyListener extends KeyAdapter 
{
	DataManager Data;
	
	public RightKeyListener(DataManager DataIn)
	{
		Data = DataIn;
	}
	
	public void keyPressed(KeyEvent e) 
	{
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			Data.LunarLander.RightwardThrust = true;
	}

	public void keyReleased(KeyEvent e) 
	{
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			Data.LunarLander.RightwardThrust = false;
	}
}
