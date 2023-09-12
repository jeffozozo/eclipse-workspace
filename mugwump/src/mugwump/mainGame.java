package mugwump;

public class mainGame 
{
	public static final int mazeSize_x = 6;
	public static final int mazeSize_y = 6;
	
	public static void main(String[] args) 
	{
		maze game_maze = new maze(mazeSize_x,mazeSize_y);	
		game_maze.generateMaze(2,2);
		
		player player1 = new player();	
		player1.setLocation(2, 2);
		mugwump mugwump1 = new mugwump((int)Math.random()*mazeSize_x + 1, (int)Math.random()*mazeSize_y + 1);
		
		
		//main game loop
		do
		{
			room player_room,mugwump_room;
			
			//player action
			player_room = game_maze.getRoom(player1);
			player_room.printRoomDesc();
			player_room.printPassages();
			player1.move(player_room);
			
			//mugwump action
			mugwump_room = game_maze.getRoom(mugwump1);
			
			mugwump1.hearPlayer(player1);
			mugwump1.move(player1, mugwump_room);
			
			
		}
		while( true );

	}

}
