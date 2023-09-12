package mugwump;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class maze 
{
	room[][] room_list;
	 Stack<room> roomStack;	 

	private static final int num_directions = 4;
	int max_x;
	int max_y;
	
	int x_end;
	int y_end;
	boolean player_found;
	
	public maze(int x_size, int y_size )
	{
		max_x = x_size;
		max_y = y_size;
		roomStack = new Stack<room>();
		
		//set the exit for the maze in a random location. Make sure it isn't in the border
		x_end = 1 + (int)(Math.random() * (x_size-1));
		y_end = 1 + (int)(Math.random() * (y_size-1));
		
		room_list = new room[x_size][y_size];
		
		for(int x = 0; x < x_size ; x++ )
		{
			for(int y=0; y< y_size; y++)
			{
				room_list[x][y] = new room(x,y);
				if(x==0 || y==0 || x==x_size-1 || y==y_size-1)
				{
					// mark the room as visited if it is on the edge of the maze
					// this way we have a "border" without having to do a bunch of 
					// specialized testing for edges.
					room_list[x][y].set_visited(true);
				}
			}
		}
		
	}
	
	public void generateMaze(int x, int y)
	{
		Integer dir_list[] = getRandomDirs(x,y);
		
		room_list[x][y].set_visited(true);
		
		for (int i = 0; i < dir_list.length; i++) 
		{
			 
			switch(dir_list[i])
			{
				case 1: //North
				{
					if(room_list[x][y-1].was_visited())
						continue;
					
					room_list[x][y].N = true;
					room_list[x][y-1].S = true;
					//debug
					System.out.println("Room["+x+"]["+y+"]: North " );
					generateMaze(x,y-1);
					break;
				}
				case 2: //South
				{
					if(room_list[x][y+1].was_visited())
						continue;
					
					room_list[x][y].S = true;
					room_list[x][y+1].N = true;	
					System.out.println("Room["+x+"]["+y+"]: South " );
					generateMaze(x,y+1);

					break;	
				}
				case 3: //East
				{
					if(room_list[x+1][y].was_visited())
						continue;
					
					room_list[x][y].E = true;
					room_list[x+1][y].W = true;
					System.out.println("Room["+x+"]["+y+"]: East " );
					generateMaze(x+1,y);
					break;
				}
				case 4: //West
				{
					if(room_list[x-1][y].was_visited())
						continue;
					
					room_list[x][y].W = true;
					room_list[x-1][y].E = true;
					System.out.println("Room["+x+"]["+y+"]: West " );
					generateMaze(x-1,y);
					break;
				}
					
			}//end switch		
		
		}//end for
		
	}//end generateMaze
	
	
	public room getRoom(player player_in)
	{
		return room_list[player_in.getXLocation()][player_in.getYLocation()];
	}
	
	public room getRoom(mugwump muggie_in)
	{
		return room_list[muggie_in.getXLocation()][muggie_in.getYLocation()];
	}
	
	
	public Integer[] getRandomDirs(int x, int y) 
	{
		//directions are N = 1, S = 2, E=3, W=4
	      ArrayList<Integer> randoms = new ArrayList<Integer>();
	      for (int i = 0; i < num_directions; i++)
	           randoms.add(i + 1);

	      Collections.shuffle(randoms);
	 
	     return randoms.toArray(new Integer[num_directions]);
	 }	
	
	public void shortestPath(int player_x, int player_y, int seek_x, int seek_y) 
	{
		if(player_x == seek_x && player_y == seek_y)
		{
			player_found = true;
			return;
		}
		
		roomStack.push(room_list[seek_x][seek_y]);
		
		 
		
		
	}
}