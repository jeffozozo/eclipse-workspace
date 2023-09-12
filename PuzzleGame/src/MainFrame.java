import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MainFrame extends JFrame implements Runnable
{

	private static final long serialVersionUID = 1L;
	
	DataModel info = new DataModel();
	
	ButtonPanel bp = new ButtonPanel(this,info);
	QuestionPanel qp = new QuestionPanel(info);
	
	public MainFrame()
	{	
        setTitle("Quiz Game Lab");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        info.getRandomQuestion();
        qp.updateModel();   
        
        setLayout(new GridLayout(1,2));
        add(qp);
        add(bp);
        
        setSize(350, 100);
        setLocationRelativeTo(null);  



	}
	
	public void updateModel()
	{
		qp.updateModel();
	}

	@Override
	public void run()
	{
        MainFrame theWindow = new MainFrame();
        theWindow.setVisible(true);
		
	}
	

}
