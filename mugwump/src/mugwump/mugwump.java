package mugwump;

public class mugwump 
{
	int x_location;
	int y_location;
	
	boolean awake;
	
	public mugwump(int x_in, int y_in)
	{
		x_location = x_in;
		y_location = y_in;
		
		awake = false;
	}
	
	public int getXLocation()
	{
		return x_location;
	}
	
	public int getYLocation()
	{
		return y_location;
	}
	
		
	public void move(player player_in, room room_in)
	{
		if(!awake)
			return;
		
		//move toward the player.
		//get shortest path to player
		String roomList[] = new 
		
		
		if(player_in.getXLocation() < x_location)
			x_move = -1;
		
		switch()
		{
			case 1: 
				if(room_in.N)
					
		}
		
		
	}
	
	public boolean hearPlayer(player player1)
	{
		//if the person just moved and they are two spaces away or less, wake up or chase.
		if( Math.abs(player1.getXLocation() - x_location)  < 3 || 
				Math.abs(player1.getYLocation() - y_location) < 3)
		{
			if(awake)
			{	
				return true;
			}
			else
			{
				awake = true;
				return false; //this way if we return true, we can move. When we first wake up, we don't want to mov
				
			}
			
		}
		
		//if I don't hear the player for two turns, then I stop and go back to sleep.
		
		
		return false;
		
	}//end hearPlayer
	
	

}
	
