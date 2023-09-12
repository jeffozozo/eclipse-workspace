package gridBagDemo;

import	java.awt.*;
import	java.awt.event.*;

public class GridBagDemo extends Frame implements ActionListener
{	private	TextField		studentNumber;
	private	TextField		passWord;
	private	TextField		logIn;
	private	TextField		PIN;
	private	Choice			classList;
	private	Button			loginButton;
	private	Button			helpButton;
	private	Button			closeButton;
	private	List			Class;
	private	GridBagLayout		GridBagDemoLayout;
	private	GridBagConstraints	constraints;

	@SuppressWarnings("deprecation")
	static public void main(String args[])
	{	GridBagDemo GridBagDemoWindow = new GridBagDemo();
		GridBagDemoWindow.setSize(600,400);
		GridBagDemoWindow.setTitle("GridBagLayout Demo");
		GridBagDemoWindow.show();
	} // main

	public GridBagDemo()
	{	GridBagDemoLayout = new GridBagLayout();
		constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.BOTH;
		setLayout(GridBagDemoLayout);

		addComponent(new Label("Student Number ", Label.RIGHT), 0, 0);
		addComponent(new Label("icarus login ", Label.RIGHT), 0, 2);
		addComponent(new Label("icarus passwd ", Label.RIGHT), 1, 2);
		addComponent(new Label("PIN ", Label.RIGHT), 0, 4);

		studentNumber = new TextField(12);
		studentNumber.setEchoChar('*');
		passWord = new TextField(12);
		passWord.setEchoChar('*');
		logIn = new TextField(12);
		PIN = new TextField(12);
		PIN.setEchoChar('*');
		addComponent(studentNumber, 0, 1);
		addComponent(logIn, 0, 3);
		addComponent(passWord, 1, 3);
		addComponent(PIN, 0, 5);

		Class = new List(4, false);
		Class.add("CS 1130 @8:00");
		Class.add("CS 1130 @9:00");
		Class.add("CS 1220");
		Class.add("CS 3230");
		addComponent(new Label("Class", Label.CENTER), 2, 1);
		addComponent(Class, 3, 1);

		loginButton = new Button("Login");
		loginButton.addActionListener(this);
		addComponent(loginButton, 4, 1);

		helpButton = new Button("Help");
		helpButton.addActionListener(this);
		addComponent(helpButton, 4, 2);

		closeButton = new Button("Close");
		closeButton.addActionListener(this);
		addComponent(closeButton, 4, 3);
	} // GridBagDemo

	public void addComponent(Component c, int y, int x)
	{	constraints.gridx = x;
		constraints.gridy = y;
		GridBagDemoLayout.setConstraints(c, constraints);
		add(c);
	}  // addComponent

	public void actionPerformed(ActionEvent E)
	{	if (E instanceof ActionEvent && E.getSource() == closeButton)
			System.exit(0);
	}
}  // class GridBagDemo
