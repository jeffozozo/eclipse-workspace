package missileSimulator;

public class missileFlightTable 
{
	private double moveDelta[];
	
	public missileFlightTable()
	{
		moveDelta = new double[20];
		
		moveDelta[0] = .001;
		moveDelta[1] = .002;
		moveDelta[2] = .005;			
		moveDelta[3] = .01;
		moveDelta[4] = .025;
		moveDelta[5] = .05;
		moveDelta[6] = .1;
		moveDelta[7] = .2;
		moveDelta[8] = .5;
		moveDelta[9] = 1;
		moveDelta[10] = 2;
		moveDelta[11] = 3;			
		moveDelta[12] = 4;
		moveDelta[13] = 5;
		moveDelta[14] = 6;
		moveDelta[15] = 7;
		moveDelta[16] = 8;
		moveDelta[17] = 9;
		moveDelta[18] = 10;
		moveDelta[19] = 15;
	}
	
	public double getMoveFactor(double altitude)
	{
		int alt = (int)(altitude/2000) ;
		
		if(alt > 19)
			alt = 19;
		
		if(alt < 0)
			alt = 0;
		
		return moveDelta[alt];
	}
	
}
