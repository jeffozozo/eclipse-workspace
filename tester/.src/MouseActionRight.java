import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MouseActionRight extends MouseAdapter 
{
	DataManager Data;
	
	public MouseActionRight(DataManager DataIn)
	{
		Data = DataIn;
	}
	
	public void mousePressed(MouseEvent e) 
	{
		Data.LunarLander.RightwardThrust = true;
	}

	public void mouseReleased(MouseEvent e) 
	{
		Data.LunarLander.RightwardThrust = false;
	}
}