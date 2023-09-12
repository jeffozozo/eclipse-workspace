
public class race 
{
	car[] cars;	
	track theTrack;
	public static final int num_cars = 5;
	
	public race()
	{
		cars = new car[num_cars];
		cars[0] = new car("Mustang",1,160.0, 30,0.8);
		cars[1] = new car("Corvette",2,175.0,25,0.7);
		cars[2] = new car("Porche",3,180,28,0.6);
		cars[3] = new car("Ferrari",4,185,32,0.75);
		cars[4] = new car("Camaro",5,123,32,.8);
		
		theTrack = new track();
		
	}
	
	public void simulateRace(int num_laps)
	{
		//laps
		for(int i=0;i<num_laps;i++)
		{
			//cars 
			for(int car=0;car<num_cars;car++)
			{
				//drive each segment in the track for this lap.
				for(int seg=0;seg<track.num_segments;seg++)
				{	
					cars[car].drive(theTrack.getSegment(seg));
				}
			}
			
		}
		
	}
	
	public void printResults()
	{
		for(int i=0;i<num_cars;i++)
		{
			cars[i].printTotalTime();
			
		}
		
	}
	
	public static void main(String[] args)
	{
		race theRace = new race();
		
		theRace.simulateRace(1);
		theRace.printResults();
		
	}
	
}
