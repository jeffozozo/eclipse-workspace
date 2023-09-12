import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;


public class ColorAction implements ActionListener
{
	private Color bgColor;
	private JPanel thePanel;
	
	public ColorAction(Color cIn, JPanel panelIn)
	{
		bgColor = cIn;
		thePanel = panelIn;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		Color c;
		
		if(bgColor == null)
			c = new Color((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256));
		else 
			c = bgColor;
		
		thePanel.setBackground(c);		
		thePanel.repaint();

	}

}
