import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class UpKeyListener extends KeyAdapter 
{
	DataManager Data;
	
	public UpKeyListener(DataManager DataIn)
	{
		Data = DataIn;
	}
	
	public void keyPressed(KeyEvent e) 
	{
		if (e.getKeyCode() == KeyEvent.VK_UP)
			Data.LunarLander.UpwardThrust = true;
	}

	public void keyReleased(KeyEvent e) 
	{
		if (e.getKeyCode() == KeyEvent.VK_UP)
			Data.LunarLander.UpwardThrust = false;
	}
}
