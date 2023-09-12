import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;


public class MainFrame extends JFrame implements Runnable
{
	DrawingSurface theDrawingArea = new DrawingSurface();
	
	public MainFrame()
	{	
		setupMenu();

		setTitle("A Frame");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300,300);
		setLocationRelativeTo(null);
		
		add(theDrawingArea);
		
	}
	
	@Override
	public void run()
	{
		setVisible(true);
	}
	
	
	public void setupMenu()
	{
		JMenuBar menuBar = new JMenuBar();
		JMenu gumby = new JMenu("Gumby");
		
		gumby.add(new JMenuItem("pokey"));
		
		JMenu menu = new JMenu("Color");
		menu.setMnemonic('C');
		
		menuBar.add(menu);

		JMenuItem menuItem = new JMenuItem("Black", KeyEvent.VK_K);
		menuItem.addActionListener(new ColorListener(Color.black));
		menu.add(menuItem);
		
		menu.add(gumby);
		
		
		menuItem = new JMenuItem("Red", KeyEvent.VK_R);
		menuItem.addActionListener(new ColorListener(Color.red));
		menu.add(menuItem);

		menuItem = new JMenuItem("Green", KeyEvent.VK_G);
		menuItem.addActionListener(new ColorListener(Color.green));
		menu.add(menuItem);
		
		menuItem = new JMenuItem("Blue", KeyEvent.VK_B);
		menuItem.addActionListener(new ColorListener(Color.blue));
		menu.add(menuItem);
		
		setJMenuBar(menuBar);
		
	}
	
	public class ColorListener implements ActionListener
	{
		Color theColor;
		
		public ColorListener(Color cIn)
		{
			theColor=cIn;
		}
		@Override
		public void actionPerformed(ActionEvent e)
		{
			theDrawingArea.setColor(theColor);
		}
		
	}
	
	

}
