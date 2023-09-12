import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MouseActionLeft extends MouseAdapter 
{
	DataManager Data;
	
	public MouseActionLeft(DataManager DataIn)
	{
		Data = DataIn;
	}
	
	public void mousePressed(MouseEvent e) 
	{
		Data.LunarLander.LeftwardThrust = true;
	}

	public void mouseReleased(MouseEvent e) 
	{
		Data.LunarLander.LeftwardThrust = false;
	}
}
