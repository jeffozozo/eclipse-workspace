import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class SettingsWindow extends JFrame implements ActionListener
{
	Settings gameSettings;
	
	JLabel initXLabel = new JLabel( "Initial X Velocity");
	JLabel initYLabel = new JLabel( "Initial Y Velocity");
	JLabel crashLabel = new JLabel( "Crashing Velocity");
	JLabel initFuelLabel = new JLabel( "Initial Fuel Amount");
	JLabel fuelUsedLabel = new JLabel("Fuel Used per thrust");
	JLabel LandingSpotLabel = new JLabel("Width of Landing Pad");
	
	JTextField initX ;
	JTextField initY;
	JTextField crash;
	JTextField initFuel;
	JTextField fuelUsed;
	JTextField landingWidth;
	
	JButton save = new JButton("Save");
	JButton cancel = new JButton("Cancel");	
	
	public SettingsWindow(Settings gameSettingsIn)
	{
		gameSettings = gameSettingsIn;
		
		initX = new JTextField(Double.toString(gameSettings.xInit));
		initY = new JTextField(Double.toString(gameSettings.yInit));
		crash = new JTextField(Double.toString(gameSettings.crashingSpeed));
		initFuel = new JTextField(Double.toString(gameSettings.initFuel));
		fuelUsed = new JTextField(Double.toString(gameSettings.fuelPerThruster));
		landingWidth = new JTextField(Integer.toString(gameSettings.landingPadWidth));		
		
		setTitle("Settings");
		setSize(175,350);
		setLocationRelativeTo(null);
		setResizable(false);
		
		JPanel theUIPanel = new JPanel();
		
		theUIPanel.setLayout(new BoxLayout(theUIPanel, BoxLayout.Y_AXIS));
		
		theUIPanel.add(initXLabel);
		theUIPanel.add(initX);
		
		theUIPanel.add(initYLabel);
		theUIPanel.add(initY);
		
		theUIPanel.add(crashLabel);
		theUIPanel.add(crash);
		
		theUIPanel.add(initFuelLabel);
		theUIPanel.add(initFuel);
		
		theUIPanel.add(fuelUsedLabel);
		theUIPanel.add(fuelUsed);
		
		theUIPanel.add(LandingSpotLabel);
		theUIPanel.add(landingWidth);
		
		
		theUIPanel.add(save);
		theUIPanel.add(cancel);
		
		save.addActionListener(this);
		cancel.addActionListener(this);
		
		
		add(theUIPanel);
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		JButton button = (JButton)e.getSource();
		
		if(button == cancel)
		{
			this.dispose();
		}
		else
		{
			gameSettings.xInit = Double.valueOf(initX.getText());
			gameSettings.yInit = Double.valueOf(initY.getText());
			gameSettings.crashingSpeed = Double.valueOf(crash.getText());
			gameSettings.initFuel = Double.valueOf(initFuel.getText());
			gameSettings.fuelPerThruster = Double.valueOf(fuelUsed.getText());
			gameSettings.landingPadWidth = Integer.valueOf(landingWidth.getText());
			
			this.dispose();	
		}
		
		
	}
	
	
}
