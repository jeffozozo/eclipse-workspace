import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Stroke;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JPanel;

class Surface extends JPanel 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2726321068251189725L;
	private static final int secondHandSize = 125;
	private static final int minuteHandSize = 125;
	private static final int hourHandSize = 80;
	private static final double radiansPerSecond = 2*Math.PI/60;

	private static final double radiansPer5Min = 2*Math.PI/12;

	private int centerW,centerH;
	private int w,h;

	
    @Override
    public void paintComponent(Graphics g) 
    {

        super.paintComponent(g);
        doDrawing(g);
    }
 
	
	
    private void doDrawing(Graphics g) 
    {

        Graphics2D g2d = (Graphics2D) g;
       
        setupDimensions();
        drawFace(g2d);
        drawHands(g2d);
       
    }


    private void drawFace(Graphics2D g2D)
    {

        
        g2D.setColor(Color.blue);
        g2D.drawOval(40,20,280,270);
        
        drawDots(g2D);
    	
    }
    
    
    private void drawDots(Graphics2D g2D)
    {
     		
    		double length = secondHandSize;
      		
      		for(int hour = 12; hour > 0; hour--)
      		{
      			double theta = (hour * radiansPer5Min) - Math.PI/2;
      			
      	        double xChange = length * Math.cos(theta);
      	        double yChange = length * Math.sin(theta);
      			
      	        g2D.drawString(Integer.toString(hour),(int)(centerW+xChange),(int)(centerH+yChange));
      	    }	
    }
    
 
    
    private void drawHands(Graphics2D g2D)
    {
    	Stroke temp = g2D.getStroke();
    	Stroke hands = new BasicStroke(3,BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND);
    	Stroke secondHand = new BasicStroke(2,BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND);
    	g2D.setStroke(hands);
    	g2D.setColor(Color.black); 	

    	int offset = 8;
    	
    	SimpleDateFormat df = new SimpleDateFormat("hh:mm:ss");
    	String now = df.format(new Date());
    	String parts[] = now.split(":");
    	
    	int hour= Integer.valueOf(parts[0]);
    	int min = Integer.valueOf(parts[1]);
    	int sec = Integer.valueOf(parts[2]);
    	
    	
    	double secTheta = (sec * radiansPerSecond) - (Math.PI/2);
    	double minTheta = (min * radiansPerSecond) - (Math.PI/2);
    	double hourTheta = (hour * radiansPer5Min) + ((min/60.0)*radiansPer5Min) - (Math.PI/2);
    	
    	//Minute Hand
        double length = minuteHandSize;
        double xChange = length * Math.cos(minTheta);
        double yChange = length * Math.sin(minTheta);
        
    	g2D.drawLine(centerW+offset, centerH,(int)(centerW+xChange)+offset, (int)(centerH+yChange));
    	
    	//Hour Hand
        length = hourHandSize;
        xChange = length * Math.cos(hourTheta);
        yChange = length * Math.sin(hourTheta);
        
    	g2D.drawLine(centerW+offset, centerH,(int)(centerW+xChange)+offset, (int)(centerH+yChange));
    	
    	//second Hand
        length = secondHandSize;
        xChange = length * Math.cos(secTheta);
        yChange = length * Math.sin(secTheta);
        
        g2D.setStroke(secondHand);
        g2D.setColor(Color.red);
        g2D.drawLine(centerW+offset, centerH, (int)(centerW+xChange)+offset, (int)(centerH+yChange) );
    	
    	g2D.setStroke(temp);
    }
    
    
    private void setupDimensions()
    {	
        Dimension size = getSize();
        Insets insets = getInsets();

        w = size.width - insets.left - insets.right;
        h = size.height - insets.top - insets.bottom;
        
        centerW = (w/2);
        centerH = (h/2);
    }
    
    
}
