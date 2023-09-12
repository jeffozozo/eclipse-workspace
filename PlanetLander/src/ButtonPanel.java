import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;


public class ButtonPanel extends JPanel
{
	JButton up;
	JButton rotLeft;
	JButton rotRight;
	DrawingPanel theGamePanel;
	InfoPanel theInfoPanel;
	
	
	public ButtonPanel(DrawingPanel gamePanelIn, InfoPanel infoPanelIn)
	{
		theGamePanel = gamePanelIn;
		theInfoPanel = infoPanelIn;
			
		rotLeft = new JButton("<");
		up = new JButton("^");
		rotRight = new JButton(">");
		
		ButtonListener bl = new ButtonListener();
		KeyTrapper kt = new KeyTrapper(theGamePanel);
		
		up.addMouseListener(bl);
		up.addKeyListener(kt);
		
		rotLeft.addMouseListener(bl);
		rotLeft.addKeyListener(kt);
				
		rotRight.addMouseListener(bl);
		rotRight.addKeyListener(kt);
		
		setLayout(new BorderLayout()); 
		
		JPanel buttons = new JPanel();
		
		buttons.add(rotLeft);		
		buttons.add(up);
		buttons.add(rotRight);
		
		add(buttons,BorderLayout.PAGE_START);
		add(theInfoPanel,BorderLayout.CENTER);
		
		setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
		
	}
	
	public void setGamePanel(DrawingPanel dpIn)
	{
		theGamePanel = dpIn;
	}

	public class ButtonListener extends MouseAdapter
	{	
		
		@Override
		public void mousePressed(MouseEvent e)
		{
			JButton button = (JButton)e.getSource();
			int code = 0;
			
			if(button == up)
			{
				code = KeyEvent.VK_UP;
			}
			if(button == rotLeft)
			{
				code = KeyEvent.VK_LEFT;
			}
			if(button == rotRight)
			{
				code = KeyEvent.VK_RIGHT;
			}
		
			theGamePanel.setKeyState(code, true);
		
		}
		public void mouseReleased(MouseEvent e)
		{
			JButton button = (JButton)e.getSource();
			int code = 0;
			
			if(button == up)
			{
				code = KeyEvent.VK_UP;
			}
			if(button == rotLeft)
			{
				code = KeyEvent.VK_LEFT;
			}
			if(button == rotRight)
			{
				code = KeyEvent.VK_RIGHT;
			}
		
			theGamePanel.setKeyState(code, false);
		}
			
	}
	
}
