import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MouseActionUp extends MouseAdapter 
{
	DataManager Data;
	
	public MouseActionUp(DataManager DataIn)
	{
		Data = DataIn;
	}
	
	public void mousePressed(MouseEvent e) 
	{
		Data.LunarLander.UpwardThrust = true;
	}

	public void mouseReleased(MouseEvent e) 
	{
		Data.LunarLander.UpwardThrust = false;
	}
}
