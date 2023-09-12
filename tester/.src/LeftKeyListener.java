import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class LeftKeyListener extends KeyAdapter 
{
	DataManager Data;
	
	public LeftKeyListener(DataManager DataIn)
	{
		Data = DataIn;
	}
	
	public void keyPressed(KeyEvent e) 
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			Data.LunarLander.LeftwardThrust = true;
	}

	public void keyReleased(KeyEvent e) 
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			Data.LunarLander.LeftwardThrust = false;
	}
}
