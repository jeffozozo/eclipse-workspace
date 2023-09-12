import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class GamePanel extends JPanel
{
	protected Lander LunarLander;
	private DataManager Data;
	protected Planet CurrentPlanet;
	
	public GamePanel(DataManager DataIn)
	{
		setOpaque(false);
		setBorder(new LineBorder(Color.black));
		setBackground(Color.black);
		Data = DataIn;
		Data.Game = this;
		LunarLander = new Lander(this, CurrentPlanet, Data);
		Data.LunarLander = LunarLander;
		Data.newGame(0);
	}		
	
	public void paintComponent(Graphics g)
	{
		Data.WindowHeight = getHeight();
		Data.WindowWidth = getWidth();
		CurrentPlanet.draw((Graphics2D)g);
		LunarLander.draw((Graphics2D)g);
	}
}
