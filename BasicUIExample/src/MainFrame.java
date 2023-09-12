import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class MainFrame extends JFrame implements Runnable
{
	private static final long serialVersionUID = 1L;
	
	NamePanel namePanel = new NamePanel();
	AddressPanel addrPanel = new AddressPanel();
	FavColorPanel favPanel = new FavColorPanel();
	ButtonPanel buttonPanel = new ButtonPanel(this);
	
	DataModel studentInfo = new DataModel();
	
	public MainFrame()
	{	
        setTitle("A new window");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(550, 350);
        setLocationRelativeTo(null); 
        
        setLayout(new GridLayout(2,2));
        
        add(namePanel); 
        add(addrPanel);
        add(favPanel);
        add(buttonPanel);

        
	}

	public static void main(String[] args)
	{
		MainFrame mf = new MainFrame();
		EventQueue.invokeLater(mf);
	}

	@Override
	public void run()
	{
        MainFrame theWindow = new MainFrame();
        theWindow.setVisible(true);
		
	}
	public void saveInfo()
	{
		namePanel.save(studentInfo);
		addrPanel.save(studentInfo);
		favPanel.save(studentInfo);
		
		System.out.println("The student: \n" + studentInfo);
		
	}
	
	public void clear()
	{
		namePanel.clear();
		addrPanel.clear();
		favPanel.clear();
		studentInfo.clear();
	}


}
