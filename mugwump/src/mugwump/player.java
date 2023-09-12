package mugwump;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class player 
{
	String name;
	int num_arrows;
	int x_location;
	int y_location;
	
	public void setLocation(int x_in, int y_in)
	{
		x_location = x_in;
		y_location = y_in;
	}
	
	public void move(room room_in) 
	{
		
		
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		directions dir = null;
		
		while(dir==null)
		{
			System.out.print("Which way? ");
			String choice = "";
			
			try 
			{
				choice = bufferedReader.readLine();
				choice = choice.toUpperCase();
			} 
			catch (IOException e) 
			{
	
				e.printStackTrace();
			}
			
			try
			{
				dir = directions.valueOf(choice);
			}
			catch(Exception e)
			{
				System.out.println("Please enter a direction as N, S, E, W.");
			}
		}
		
		switch(dir)
		{
		case N:
			if(room_in.N) 
				y_location -= 1;
			else
				System.out.println("You can't go that way.");
			break;
			
		case S:
			if(room_in.S) 
				y_location += 1;
			else
				System.out.println("You can't go that way.");
			break;
			
		case E:			if(room_in.E) 
				x_location += 1;
			else
				System.out.println("You can't go that way.");
			break;

		case W:
			if(room_in.W) 
				x_location -= 1;
			else
				System.out.println("You can't go that way.");
			break;
			

			
		}//end switch
		
		
	}
	
	public int getXLocation()
	{
		return x_location;
	}
	
	public int getYLocation()
	{
		return y_location;
	}
}
