import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class ButtonPanel extends JPanel implements ActionListener
{

		JButton rect = new JButton("Rectangle");
		JButton oval = new JButton("Oval");
		JButton line = new JButton("Line");
		
		JRadioButton green = new JRadioButton("Green");
		JRadioButton blue = new JRadioButton("Blue");
		JRadioButton red = new JRadioButton("Red");
		
		ButtonGroup radioButtons = new ButtonGroup();
		
		DrawingSurface theDrawingPanel;
		
		Color currentColor;
		
		public ButtonPanel()
		{
			add(rect);
			add(oval);
			add(line);
			
			rect.addActionListener(this);
			oval.addActionListener(this);
			line.addActionListener(this);
			
			add(green);
			add(blue);
			add(red);
			
			radioButtons.add(green);
			radioButtons.add(blue);
			radioButtons.add(red);

			
			green.addActionListener(new RBListener(Color.green));
			blue.addActionListener(new RBListener(Color.blue));
			red.addActionListener(new RBListener(Color.red));	
			
			red.setSelected(true);
			
			
		}
		
		public void setPanel(DrawingSurface panelIn)
		{
			theDrawingPanel = panelIn;
		}
			
		@Override
		public void actionPerformed(ActionEvent e)
		{
			JButton b = (JButton)e.getSource();
			Point p1 = new Point((int)(Math.random()*theDrawingPanel.getWidth()/2), (int)(Math.random()*theDrawingPanel.getHeight()/2));
			Point p2 = new Point(p1.x + (int)(Math.random()*25), p1.y+(int)(Math.random()*25));

			if(b == rect)
			{
				theDrawingPanel.add(new Rectangle(p1, p2, currentColor));
				theDrawingPanel.repaint();
			}
			else if(b == oval)
			{
				theDrawingPanel.add(new Oval(p1,p2, currentColor));
				theDrawingPanel.repaint();
			}
			else 
			{
				theDrawingPanel.add(new Line(p1,p2, currentColor));
				theDrawingPanel.repaint();
			}
			
		}
	
		
		private class RBListener implements ActionListener
		{
			Color thisColor; 
			public RBListener(Color cIn)
			{
				thisColor = cIn;
			}

			@Override
			public void actionPerformed(ActionEvent e)
			{
				currentColor = thisColor;	
			}
			
		}
	
	
}
