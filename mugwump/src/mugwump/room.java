package mugwump;

public class room 
{
	int x_location;
	int y_location;
	
	public boolean N,S,E,W; //paths
	
	private boolean visited; //for maze generation
	
	public room(int x, int y)
	{
		visited = false;
		N = false;
		S = false;
		E = false;
		W = false;
		
		x_location = x;
		y_location = y;
	}
	
	public boolean was_visited()
	{
		return visited;
	}
	
	public void set_visited(boolean visited_in)
	{
		visited = visited_in;
	}
	
	public void printPassages()
	{
		String message = "The passages out of this room are: ";
		
		if(N)
			message += " N";
		
		if(S)
			message += " S";
		
		if(E)
			message += " E";
		
		if(W)
			message += " W";
			
		System.out.println(message);
		
	}
	
	public void printRoomDesc()
	{
		System.out.println("This room is at "+ x_location +"," + y_location + ".");
	}
	
	public directions[] getPossiblePaths()
	{
		directions possibleDirs[] = new directions[4];
		if(N)
			possibleDirs[0]=directions.N;
		
		if(S)
			possibleDirs[1]=directions.S;		
		
		if(E)
			possibleDirs[2]=directions.E;
		
		if(W)
			possibleDirs[3]=directions.W;
			
		return possibleDirs;
	}
	
}
