import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;



public class ButtonPanel extends JPanel 
{

	//create the buttons
	public JButton yellow = new JButton("Yellow");
	public JButton blue = new JButton("Blue");
	public JButton green = new JButton("Green");
	public JButton random = new JButton("Random");
	
	public ButtonPanel()
	{
		//add the ActionListeners to the Buttons
		
		yellow.addActionListener(new ColorAction(Color.yellow,this));
		blue.addActionListener(new ColorAction(Color.blue,this));
		green.addActionListener(new ColorAction(Color.green,this));
		random.addActionListener(new ColorAction(null,this));

		//add the buttons to the panel
		add(yellow);
		add(green);
		add(blue);
		add(random);
		
	}
}
