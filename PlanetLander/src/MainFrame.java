import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.Timer;


public class MainFrame extends JFrame implements Runnable
{
	//Panels
	DrawingPanel theGamePanel;
	ButtonPanel theButtonPanel;
	InfoPanel theInfoPanel;

	//handles the main game functions	
	GameLoop gameElements;

	//menu items
	JMenuBar theBar = new JMenuBar();
	MenuHelper menuHelper = new MenuHelper();
	
	//set things up
	public MainFrame()
	{
		setTitle("Planet Lander");
		setSize(800,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setResizable(false);
		
		addWindowListener(new WindowCloser());
		
		gameElements = new GameLoop();	
		theInfoPanel = new InfoPanel();
		theGamePanel = new DrawingPanel();
		theButtonPanel = new ButtonPanel(theGamePanel,theInfoPanel);
		addKeyListener(new KeyTrapper(theGamePanel));	
		
		setLayout(new BorderLayout());
		
		add(theButtonPanel,BorderLayout.PAGE_START);
		add(theGamePanel,BorderLayout.CENTER);
		
		theButtonPanel.setGamePanel(theGamePanel);
		
		//do I really need a circular reference here?
		gameElements.setupGameLoop(theGamePanel, theInfoPanel);
		theGamePanel.setupGamePanel(gameElements);

		menuHelper.setupMenu(theBar,theGamePanel,gameElements);
		this.setJMenuBar(theBar);
		
	}	
	

	@Override
	public void run()
	{
		this.setVisible(true);
	}
	
	
	public class WindowCloser extends WindowAdapter
	{
		@Override
		public void windowClosing(WindowEvent e)
		{

			int confirmed = JOptionPane.showConfirmDialog(null,"Are you sure you want to exit the game?",
					"User Confirmation", JOptionPane.YES_NO_OPTION);
			if (confirmed == JOptionPane.YES_OPTION)
				Runtime.getRuntime().halt(0);	
			else
				setVisible(true);	
		}
	}

	
	

}
