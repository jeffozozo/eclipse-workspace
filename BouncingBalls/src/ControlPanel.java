import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class ControlPanel extends JPanel implements ChangeListener
{
	JSlider numBalls, ballVelocity;
	MainFrame theFrame;

	public ControlPanel(MainFrame theFrameIn)
	{

		theFrame = theFrameIn;

		numBalls = new JSlider(JSlider.HORIZONTAL,0, 50, 1 );
		numBalls.addChangeListener(this);
		numBalls.setMajorTickSpacing(10);
		numBalls.setMinorTickSpacing(2);
		numBalls.setPaintTicks(true);
		numBalls.setPaintLabels(true);
		add(numBalls);

		ballVelocity = new JSlider(JSlider.HORIZONTAL,0, 150, 1 );
		ballVelocity.addChangeListener(this);
		ballVelocity.setMajorTickSpacing(10);
		ballVelocity.setMinorTickSpacing(2);
		ballVelocity.setPaintTicks(true);
		ballVelocity.setPaintLabels(true);

		add(ballVelocity);

	}

	@Override
	public void stateChanged(ChangeEvent e)
	{
		theFrame.setNumBalls(numBalls.getValue());
		theFrame.setVelocity(ballVelocity.getValue());
	}

}
