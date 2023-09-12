import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;


public class NamePanel extends JPanel
{
	JTextField name,wNum;
	JLabel nameLabel,wLabel;
	
	public NamePanel()
	{
		setBorder(BorderFactory.createTitledBorder("Student Info"));
	
		SpringLayout layout = new SpringLayout();

		nameLabel = new JLabel("Student Name:");
		wLabel = new JLabel("W#:");
        name = new JTextField("",10);
        wNum = new JTextField("",10);
                
        add(nameLabel);
        add(name);
        add(wLabel);
        add(wNum);

		layout.putConstraint(SpringLayout.WEST, name , 1,SpringLayout.EAST, nameLabel ); // name relative to nameLabel
		layout.putConstraint(SpringLayout.NORTH,wLabel, 20 ,SpringLayout.SOUTH, nameLabel ); //wLabel relative to nameLabel	
		layout.putConstraint(SpringLayout.EAST, wNum , 0 ,SpringLayout.EAST, name );	// wNum relative to name	
		layout.putConstraint(SpringLayout.EAST,wLabel , 1,SpringLayout.EAST, nameLabel ); //wLabel relative to nameLabel
		layout.putConstraint(SpringLayout.NORTH,wNum , 3,SpringLayout.SOUTH, name ); // wNum relative to name
		  
		setLayout(layout);
	}
	
	public void save(DataModel info)
	{
		info.studentName = name.getText();
		info.wNum = wNum.getText();
	}
	public void clear()
	{
		name.setText("");
		wNum.setText("");
	}
}
