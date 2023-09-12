import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class ButtonPanel extends JPanel
{
	JTextField question, ipAddress;
	JButton ask, connect;
	JTextArea answer;
	JLabel qLabel, ipLabel;
	
	Socket the8BallSocket;
	PrintWriter out;
	BufferedReader in;
	
	boolean connected = false;

	public ButtonPanel()
	{
		qLabel = new JLabel("Question:");
		question = new JTextField();
		ipLabel = new JLabel("Host to Connect to:");
		ipAddress = new JTextField();
		
		ask = new JButton ("Ask");
		connect = new JButton("Connect");
		answer = new JTextArea("8 Ball not connected.");
		answer.setLineWrap(true);
		answer.setWrapStyleWord(true);
		answer.setEditable(false);
		
		ask.addActionListener(new AskListener());
		connect.addActionListener(new ConnectListner());		
		
		add(ipLabel);
		add(ipAddress);
		add(connect);
		
		add(qLabel);
		add(question);
		add(ask);
		add(answer);
		
	}
	
	public void setup(String host)
	{
			try
			{
				StringBuffer openingText = new StringBuffer();
				
				the8BallSocket = new Socket(host, 8888);
				out = new PrintWriter(the8BallSocket.getOutputStream(), true);
				in = new BufferedReader(new InputStreamReader(the8BallSocket.getInputStream()));

				answer.setText("The 8 ball is connected.");
				connected = true;

				openingText.append(in.readLine());
				openingText.append(in.readLine());
				openingText.append(in.readLine());
				
				answer.setText(openingText.toString());
				
			} 
			catch (IOException e)
			{
				System.out.println("Tried to connect -- failed." + e.getMessage());
			}

	}



	public class AskListener implements ActionListener
	{
		
		public void actionPerformed(ActionEvent e)
		{
			String text = question.getText();
			
			if(text.compareToIgnoreCase("quit") == 0)
			{
				connected = false;
				answer.setText("8Ball disconnected.");
				try
				{
					the8BallSocket.close();
					return;
					
				} catch (IOException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
			String the8Ballsays = "";
			
			out.println(text);
			out.flush();
			
			try
			{
				the8Ballsays = in.readLine();
			} 
			catch (IOException e1)
			{
				answer.setText("8 Ball disconnected.");
			}
			
			answer.setText("The 8 Ball says: " + the8Ballsays);
			
		}
	
	}
	
	public class ConnectListner implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			if(!connected)
				setup(ipAddress.getText());
		}
		
	}
	
	
}
