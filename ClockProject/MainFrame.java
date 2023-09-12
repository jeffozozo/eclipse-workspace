
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.Timer;

public class MainFrame extends JFrame 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5100860548368089493L;
	public static final int windowSize = 350;
	
	private static Timer timer;
	
    public MainFrame() 
    {
    	
        setTitle("Clock");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       // setResizable(false);

        add(new Surface());

        setSize(350, 350);
        setLocationRelativeTo(null); //centers new window in middle of screen
        
        timer = new Timer(1000, new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                repaint();
            }
        }
        );

    }
    
    public static void main(String[] args) 
    {
    	Runnable window = new Runnable()
		{
		    @Override
		    public void run() 
		    {
		        MainFrame ps = new MainFrame();
		        ps.setVisible(true);
		        timer.start();
		        
		    }
		};
		
		EventQueue.invokeLater(window);
    }
}