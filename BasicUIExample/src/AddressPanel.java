import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;


public class AddressPanel extends JPanel
{
	JLabel addr1Label,addr2Label, cityLabel, stateLabel, zipLabel;
	JTextField addr1,addr2,city,state;
	
	DataModel info;
	
	public AddressPanel()
	{
		setBorder(BorderFactory.createTitledBorder("Address"));
		
		SpringLayout layout = new SpringLayout();
	
		addr1Label = new JLabel("Street 1:");
		addr2Label = new JLabel("Street 2:");
		cityLabel = new JLabel("City:");
		stateLabel = new JLabel("State:");
		
	    addr1 = new JTextField("",10);
	    addr2 = new JTextField("",10);
	    city = new JTextField("",10);
	    state = new JTextField("",10);
	    
        add(addr1Label);
        add(addr1);
        add(addr2Label);
        add(addr2);
        add(cityLabel);
        add(city);
        add(stateLabel);
        add(state);

        //align the fields
        
        
        //line up all the labels with the fields
		layout.putConstraint(SpringLayout.WEST, addr1,1, SpringLayout.EAST, addr1Label ); 
		
		//layout.putConstraint(SpringLayout.EAST, addr1Label,1, SpringLayout.WEST, addr1 ); 
		layout.putConstraint(SpringLayout.EAST, addr2Label,1, SpringLayout.WEST, addr2 ); 
		layout.putConstraint(SpringLayout.EAST, cityLabel,1, SpringLayout.WEST, city ); 
		layout.putConstraint(SpringLayout.EAST, stateLabel,1, SpringLayout.WEST, state ); 

		//align all the text fields
		layout.putConstraint(SpringLayout.WEST, addr2 , 1 ,SpringLayout.WEST, addr1 );		
		layout.putConstraint(SpringLayout.WEST,city , 1,SpringLayout.WEST, addr1 ); 
		layout.putConstraint(SpringLayout.WEST,state , 1,SpringLayout.WEST, addr1 ); 	

		//stack the labels
		layout.putConstraint(SpringLayout.NORTH,addr2Label, 18 ,SpringLayout.SOUTH, addr1Label ); 
		layout.putConstraint(SpringLayout.NORTH,cityLabel, 12 ,SpringLayout.SOUTH, addr2Label );  
		layout.putConstraint(SpringLayout.NORTH,stateLabel, 10 ,SpringLayout.SOUTH, cityLabel );
		
		//stack the text fields
		layout.putConstraint(SpringLayout.NORTH,addr2, 0 ,SpringLayout.SOUTH, addr1 );  
		layout.putConstraint(SpringLayout.NORTH,city, 0 ,SpringLayout.SOUTH, addr2 );  
		layout.putConstraint(SpringLayout.NORTH,state, 0 ,SpringLayout.SOUTH, city );  
				  
		setLayout(layout);
	    
	}
	
	public void save(DataModel info)
	{
		info.address1 = addr1.getText();
		info.address2 = addr2.getText();
		info.city = city.getText();
		info.state = state.getText();
	}
	
	public void clear()
	{
		addr1.setText("");
		addr2.setText("");
		city.setText("");
		state.setText("");
	}
	
}
