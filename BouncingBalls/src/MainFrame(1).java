import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;


public class MainFrame extends JFrame implements Runnable, ActionListener
{
	DrawingSurface ds = new DrawingSurface();
	ControlPanel cp;
	Timer t;
	int numBalls = 1;
	int ballVelocity = 

	public MainFrame()
	{
		setTitle("Basic Window");
		setSize(300,300);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);
		
		addWindowListener(new WindowCloser());	
		setLayout(new BorderLayout());
		
		cp=new ControlPanel(this);
		t = new Timer(5,this);
		
		ds.addBall();
		add(cp,BorderLayout.PAGE_START);
		add(ds,BorderLayout.CENTER);
		
		t.start();
		
	}
	
	public void setNumBalls(int ballsIn)
	{

		if(ballsIn >= numBalls)
		{	
			addBalls(ballsIn - numBalls);
			numBalls = ballsIn;
		}
		else
		{		
			removeBalls(numBalls - ballsIn);
			numBalls = ballsIn;
		}
		
	}

	public void setVelocity(int velocityIn)
	{

		
	}
	
	public void addBalls(int add)
	{
		for(int i =0; i< add; i++)
		{
			ds.addBall();
		}
	}
	
	public void removeBalls(int remove)
	{
		for(int i=0;i<remove;i++)
		{
			ds.removeBall();
		}
	}
	

	@Override
	public void run()
	{	
		setVisible(true);
	}

	
	public class WindowCloser extends WindowAdapter
	{
		@Override
		public void windowClosing(WindowEvent e)
		{

			int confirmed = JOptionPane.showConfirmDialog(null,"Are you sure you want to exit?",
					"User Confirmation", JOptionPane.YES_NO_OPTION);
			if (confirmed == JOptionPane.YES_OPTION)
			{	

				Runtime.getRuntime().halt(0);
			}
			else
				setVisible(true);	
		}
		
		
		
	}


	@Override
	public void actionPerformed(ActionEvent e)
	{
		repaint();
		try
		{
			Thread.sleep(0);
			
		} catch (InterruptedException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	
	
}
