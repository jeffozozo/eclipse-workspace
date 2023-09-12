import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class MainFrame extends JFrame
{
	ButtonPanel bp = new ButtonPanel();
	
	public MainFrame()
	{
		bp.setLayout(new BoxLayout(bp, BoxLayout.PAGE_AXIS));
		add(bp);
		//bp.setup();
		
		
		setSize(300,250);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}
}
