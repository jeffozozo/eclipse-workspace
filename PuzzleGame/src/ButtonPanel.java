import java.awt.Color;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;


public class ButtonPanel extends JPanel
{	
	private static final long serialVersionUID = 1L;
	
	JButton submit = new JButton("Answer");
	JButton quit = new JButton("Quit");
	MainFrame theFrame;
	
	DataModel info;
	
	public ButtonPanel(MainFrame frameIn, DataModel dmIn)
	{
		theFrame = frameIn;
		info = dmIn;

		setLayout(new BoxLayout(this,BoxLayout.LINE_AXIS));
		setBorder(new LineBorder(Color.black));
		
		add(submit);
		add(quit);
		quit.addActionListener(new quitter());
		submit.addActionListener(new AnswerAction());
		
	}
	public class quitter implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			theFrame.dispose();		
		}

	}
	
	public class AnswerAction implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			theFrame.updateModel();
			if(info.checkAnswer())
			{
				JOptionPane.showMessageDialog(theFrame, "Right!" );
				info.getRandomQuestion();
				theFrame.updateModel();
			}
			else
			{
				JOptionPane.showMessageDialog(theFrame, "Wrong. Try again." );
			}	
			
		}
		
	}
	


}
