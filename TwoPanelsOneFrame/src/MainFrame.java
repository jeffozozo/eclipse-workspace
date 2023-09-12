import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.border.EtchedBorder;


public class MainFrame extends JFrame implements Runnable
{

	public MainFrame()
	{
		setTitle("A Drawing Program");
		setSize(500,500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		DrawingSurface ds = new DrawingSurface();
		ButtonPanel bp = new ButtonPanel();
		bp.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		
		bp.setPanel(ds);
		
		//add some panels
		setLayout(new BorderLayout());
		add(bp, BorderLayout.PAGE_START);
		add(ds, BorderLayout.CENTER);		
		
		
	}
	
	@Override
	public void run()
	{
		setVisible(true);

	}

}
