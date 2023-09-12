import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class ButtonPanel extends JPanel implements ActionListener
{
	JButton save = new JButton("Save");
	JButton clear = new JButton("Clear");
	
	MainFrame theFrame;

	public ButtonPanel(MainFrame frameIn)
	{
		
		save.addActionListener(this);
		clear.addActionListener(this);
		
		add(save);
		add(clear);
		
		theFrame = frameIn;
		
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		JButton temp = (JButton)e.getSource();
		
		if(temp == save)
		{
			theFrame.saveInfo();	
		}
		else
		{
			theFrame.clear();
		}
		
	}
	
	
}
