import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.KeyStroke;

import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.border.LineBorder;

public class SettingsPanel extends JPanel implements Runnable
{
	private GUI MainWindow;
	private DataManager Data;
	private Thread thread = new Thread(this);
	private JButton Left = new JButton("Left");
	private JButton Up = new JButton("Up");
	private JButton Right = new JButton("Right");
	private JProgressBar FuelMeter = new JProgressBar();
	private JLabel PlanetName = new JLabel();
	private String planetName;
	
	public SettingsPanel(DataManager DataIn)
	{
		setOpaque(true);
		Data = DataIn;
		Data.Settings = this;
		setBorder(new LineBorder(Color.blue));
		planetName = "Moon";
		
		MouseActionUp UpMouse = new MouseActionUp(Data);
		MouseActionLeft LeftMouse = new MouseActionLeft(Data);
		MouseActionRight RightMouse = new MouseActionRight(Data);	
		
		UpKeyListener UpKey = new UpKeyListener(Data);
		LeftKeyListener LeftKey = new LeftKeyListener(Data);
		RightKeyListener RightKey = new RightKeyListener(Data);
				
		Left.addMouseListener(LeftMouse);
		Up.addMouseListener(UpMouse);
		Right.addMouseListener(RightMouse);
		
		Left.addKeyListener(UpKey);		//I don't care which button has focus, make the arrow keys work!!!!!!!
		Left.addKeyListener(LeftKey);
		Left.addKeyListener(RightKey);
		Right.addKeyListener(UpKey);
		Right.addKeyListener(LeftKey);
		Right.addKeyListener(RightKey);
		Up.addKeyListener(UpKey);
		Up.addKeyListener(LeftKey);
		Up.addKeyListener(RightKey);
			
		add(Left);
		add(Up);
		add(Right);
		add(FuelMeter);
		add(PlanetName);		
		
		thread.start();
	}
	
	//Sets the name of the planet for the label displaying the planet name
	public void setPlanetName(String planetNameIn)
	{
		planetName = planetNameIn;
		PlanetName.setText(planetName);
	}
	
	@Override
	public void run() 
	{
		PlanetName.setText(planetName);
		while(true)
		{
			FuelMeter.setValue(Data.LunarLander.fuel);
		}
	}
}
