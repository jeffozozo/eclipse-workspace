import java.awt.EventQueue;

import javax.swing.JFrame;


public class MainFrame extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MyPanel thePanel = new MyPanel();
	
	public MainFrame()
	{
		
        setTitle("A new window");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(350, 350);
        setLocationRelativeTo(null); 
        
        add(thePanel);

        
        
	}

	public static void main(String[] args)
	{
    	Runnable window = new Runnable()
		{
		    @Override
		    public void run() 
		    {
		        MainFrame theWindow = new MainFrame();
		        theWindow.setVisible(true);
		        
		    }
		};
		
		EventQueue.invokeLater(window);
		System.out.println("bu-bye.");
		
	}

}
