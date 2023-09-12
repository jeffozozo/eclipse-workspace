import	java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;


public class HelloApplet extends Applet
{
	/*
	<applet code="HelloApplet.class" CodeBase="" width=300 height=400></applet>
	*/
	private static final long serialVersionUID = 1L;

	@Override
	public void init()
	{
		setBackground(Color.cyan);
	}
	
	@Override
	public void paint(Graphics g)
	{
		g.drawString("Hello world, I'm an applet.", 10, 20);		
	}
}
