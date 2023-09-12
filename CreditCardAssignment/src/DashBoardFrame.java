
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.event.ChangeListener;

public class DashBoardFrame extends JFrame implements Runnable
{
	private static final long serialVersionUID = 1L;
	private InfoPanel infoPanel = new InfoPanel();
	private ControlPanel controlPanel = new ControlPanel();
	public static final int startThreads = 5;

	public DashBoardFrame()
	{
		setTitle("Transaction Processing");
		setSize(700,300);
		setLocationRelativeTo(null);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);		
		setLayout(new BorderLayout());
		
		add(controlPanel, BorderLayout.PAGE_START);
		add(infoPanel,BorderLayout.CENTER);
	
		
	}
	
	public void setThreadManager(ChangeListener listenerIn )
	{
		controlPanel.setThreadManager(listenerIn);
	}
	public void setQueueFiller(ChangeListener listenerIn )
	{
		controlPanel.setQueueFiller(listenerIn);
	}
	
	public void updateData(DashBoardData dataIn)
	{
		infoPanel.updateData(dataIn);
	}
	
	public void run()
	{
		this.setVisible(true);
	}
	
}
