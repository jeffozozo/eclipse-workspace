import java.text.DecimalFormat;

import javax.swing.JLabel;
import javax.swing.JPanel;


public class InfoPanel extends JPanel
{
	Stats theStats;
	
	JLabel altitudeLabel = new JLabel("Altitude: ");
	JLabel fuelLabel = new JLabel("Fuel: ");
	JLabel speedLabel = new JLabel("Speed: ");
	JLabel planetLabel = new JLabel("Planet: ");
	JLabel gravityLabel = new JLabel("Gravity: ");
	
	public InfoPanel()
	{	
		add(planetLabel);		
		add(gravityLabel);
		add(altitudeLabel);
		add(fuelLabel);
		add(speedLabel);
	}
	public void setStats(Stats theStatsIn)
	{
			theStats = theStatsIn;
	}
	
	public void updateStats()
	{
		DecimalFormat df = new DecimalFormat("##.##");
		
		altitudeLabel.setText("Altitude: " + df.format(theStats.landerAltitude));
		fuelLabel.setText("Fuel: " + df.format(theStats.fuelRemaining));
		speedLabel.setText("Lander Speed: "+ df.format(theStats.landerSpeed));
		planetLabel.setText("Planet: " + theStats.planetName);
		gravityLabel.setText("Gravity: " + df.format(100 * theStats.currentGravity));
	}
	
}
