import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;


public class UIPanel extends JPanel implements ActionListener
{

	private static final long serialVersionUID = 1L;
	Ufo theUfo;
	
	
	public UIPanel(Ufo ufoIn)
	{
		theUfo = ufoIn;
		JButton up = new JButton("up");
		JButton down = new JButton("down");
		JButton left = new JButton("left");
		JButton right = new JButton("right");
		
		up.addActionListener(this);
		up.setName("up");
		
		down.addActionListener(this);
		down.setName("down");
		
		left.addActionListener(this);
		left.setName("left");
		
		right.addActionListener(this);
		right.setName("right");
		
		this.add(up);
		this.add(down);
		this.add(left);
		this.add(right);
		
		this.setBorder(BorderFactory.createEtchedBorder()); 
		
	}
	
	public void setUfo(Ufo uIn)
	{
		theUfo = uIn;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		JButton temp = (JButton) e.getSource();
		
		switch(temp.getName())
		{
		
			case "up": 
			{	
				theUfo.moveUp();
				break;
			}
			
			case "down" :
			{
				theUfo.moveDown();
				break;
			}
			
			case "left" :
			{
				theUfo.moveLeft();
				break;
			}
			
			case "right" :
			{
				theUfo.moveRight();
				break;
			}
				
		}
		
		
		
	}
	
	public class ButtonUFOFlier implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{

			
		}

	}

	
	

}
