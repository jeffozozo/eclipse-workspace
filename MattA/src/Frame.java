
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


@SuppressWarnings("serial")
public class Frame extends JFrame implements Runnable, ActionListener
{
	
	int x,y;
	
	Ship s = new Ship();

	public void run()
	{
		MenuSetup();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1000, 700);
		setLocationRelativeTo(null);
		setTitle("MoonLander");
		Panel1 thePanel = new Panel1();
		add(thePanel);
		setVisible(true);
		addKeyListener(thePanel);
		
	}
	
	public void MenuSetup()
	{
		
		JMenu menu = new JMenu("File");
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(menu);
	
		JMenuItem menuItem2 = new JMenuItem("Pause");
		menu.add(menuItem2);
		
		JMenuItem menuItem1 = new JMenuItem("Settings");
		menu.add(menuItem1);
		
		JMenuItem menuItem3 = new JMenuItem("Exit");
		menu.add(menuItem3);
		
		setJMenuBar(menuBar);
		

		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		repaint();
	}

}