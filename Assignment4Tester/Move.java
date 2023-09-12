import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.Calendar;



public class Move
{	
	private int x=0, y=0; //use to draw oval
		
	//Clock Arms 		
	private int xradius ;//x radius for resizing 
	private int yradius;// Y radius for resizing 
	private int shx,shy; //second Hand x,y
	private int mhx,mhy; //minute hand x,y
	private int hhx,hhy; //Hour hand x,y
	private int xcenter ;//x center of oval
	private int ycenter ;//y center of oval 
	private int degree; // for placement of dots 
	private Font Myfont = new Font("Serif",Font.BOLD, 30);	
	private int [] xdot = new int[60];// x degree for dots
	private int [] ydot = new int[60];// y degree for dots
	
	
	public void moveHand()
	{		
		Calendar calendar= Calendar.getInstance();
		int second = (calendar.get(Calendar.SECOND));
		int minute = (calendar.get(Calendar.MINUTE));
		int hour = (calendar.get(Calendar.HOUR));		
		int sdegree = 270+(second*6);//how many sec times 6 degree for position.		
		int mdegree = 270+(minute*6);//how many min times 6 degree for position.
		int hdegree = 270+(5*(hour*6));//how many hours times 6 degree times 5 for position.
		//(times by five because it was based on 6 degree a sec hours are every 5 five sec or change it 30 degree for every hour)
				
		//Second Hand Math 
		shx=(int)(xradius*Math.cos(sdegree*Math.PI/180));
		shy=(int)(yradius*Math.sin(sdegree*Math.PI/180));			
		shx+=xcenter;
		shy+=ycenter;
				
		//Minute hand Math 
		mhx=(int)((xradius-25)*Math.cos(mdegree*Math.PI/180));
		mhy=(int)((yradius-25)*Math.sin(mdegree*Math.PI/180));
		mhx+=xcenter;
		mhy+=ycenter;
		
		//Hour Hand Math 
		hhx= (int)((xradius-45)*Math.cos(hdegree*Math.PI/180));
		hhy=(int)((yradius-45)*Math.sin(hdegree*Math.PI/180));
		hhx+=xcenter;
		hhy+=ycenter;		
	}
	public void Dots(int xin, int yin, Graphics2D g2In)//DOTs around the edge and the numbers 
	{		
		for (int q=1; q<61;q++)//counting for 60 sec
		{
			degree=(q*6);//6 degrees for every second.360/60 =6
			int dx = (int)(xradius*Math.cos(degree*Math.PI/180));//yeah think on it it will come
			int dy = (int)(yradius*Math.sin(degree*Math.PI/180));
			dy+=ycenter;// adding the center plus the degree change
			dx+=xcenter;			
			g2In.setColor(Color.WHITE);// setting color
			xdot[(q-1)]=dx;// assigning value in array 
			ydot[q-1]=dy;
			g2In.setFont(Myfont);
			if (q==15)// conditions on where to place numbers 
				g2In.drawString("6", (xcenter-5), ydot[q-1]+5);
			else if (q==30)
				g2In.drawString("9",xdot[q-1] , ycenter+10);
			else if (q==45)
				g2In.drawString("12",(xcenter-13), ydot[q-1]+20);
			else if (q==60)
				g2In.drawString("3",xdot[q-1]-10 ,ycenter+10);					
			else				
				g2In.fillOval(xdot[q-1],ydot[q-1],6,6 );// actual dots
					
									
		}				
	}
	
	public void MoveMe(int xin , int yin, Graphics2D g2In)
	{
		xcenter= (xin/2);//finding center for starting point of hands 
		ycenter= (yin/2);		
		xradius=xcenter-15;//this allows the resizing to any shape and hands reach the edge
		yradius=ycenter-15;//this allows the resizing to any shape and hands reach the edge		
		//Draw my Oval
		g2In.setColor(Color.BLACK);		
		g2In.fillOval(x, y,xin,yin);
		Dots(xin,yin,g2In);// draw the dots 				
		g2In.setColor(Color. red);
		moveHand();
		g2In.drawLine(xcenter, ycenter, shx,shy);// second hand draw 
		g2In.setStroke(new BasicStroke(3.5f));
		g2In.setColor(Color.WHITE);
		g2In.drawLine(xcenter, ycenter, mhx, mhy);//minute hand draw 
		g2In.drawLine(xcenter, ycenter, hhx, hhy);// hour hand draw
		
		
	}
	
}
