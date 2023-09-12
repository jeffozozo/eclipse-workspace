import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeListener;


public class ControlPanel extends JPanel
{

	private static final long serialVersionUID = 1L;

	JSpinner numWorkers;
	JSlider addRate;
	JLabel numWorkersLabel = new JLabel("Number of Worker Threads:");	
	JLabel rateLabel = new JLabel("Add new requests/sec:");
	JLabel spacer = new JLabel("    ");

	public ControlPanel()
	{

		numWorkers = new JSpinner();	
		numWorkers.setModel(new SpinnerNumberModel(5, 1, 100, 1));
		numWorkers.setName("numWorkers");
		
		add(numWorkersLabel);
		add(numWorkers);
		add(spacer);
		
		addRate = new JSlider(1,10,1);
		addRate.setMinorTickSpacing(1);
		addRate.setPaintTicks(true);
		addRate.setPaintLabels(true);
		addRate.setLabelTable(addRate.createStandardLabels(1));
		addRate.setName("addRate");
		
		add(rateLabel);
		add(addRate);
		
	}
	
	public void setThreadManager(ChangeListener listenerIn)
	{
		numWorkers.addChangeListener(listenerIn);	
	}
	
	public void setQueueFiller(ChangeListener listenerIn)
	{
		addRate.addChangeListener(listenerIn);
	}
	
}
