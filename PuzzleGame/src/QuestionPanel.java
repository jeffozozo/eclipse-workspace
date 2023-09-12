import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class QuestionPanel extends JPanel
{
	private static final long serialVersionUID = 1L;
	
	DataModel info;
	
	JLabel question = new JLabel("Question goes here.");
	JTextField answer = new JTextField("",10);
	//add components to collect the answer
	
	public QuestionPanel(DataModel dmIn)
	{
		info = dmIn;
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(question);
		add(answer);	
	}
	
	public void updateModel()
	{
		question.setText(info.getCurrentQuestion());
		info.userAnswer = answer.getText();
	}
	
	public void newQuestion()
	{
		question.setText(info.getRandomQuestion());
	}
}
