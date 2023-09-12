import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class FavColorPanel extends JPanel implements ActionListener
{

	JLabel gLabel,bLabel,rLabel;
	JRadioButton green,blue,red;
	ButtonGroup bg = new ButtonGroup();
	String color;
	
	public FavColorPanel()
	{
		
		green = new JRadioButton("Green");
		blue = new JRadioButton("Blue");
		red = new JRadioButton("Red");
		
		bg.add(green);
		bg.add(blue);
		bg.add(red);
		
		add(green);
		add(blue);
		add(red);
		green.setSelected(true);
			
		setBorder(BorderFactory.createTitledBorder("Address"));	
		GridLayout layout = new GridLayout(3,1);
		
		setLayout(layout);
		
	}
	
	public void save(DataModel info)
	{
		info.color=color;
	}
	
	public void clear()
	{
		bg.clearSelection();
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		JRadioButton rb = (JRadioButton)e.getSource();
		color = rb.getText();
		
	}
	
}
