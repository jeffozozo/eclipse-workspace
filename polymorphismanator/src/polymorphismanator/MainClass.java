package polymorphismanator;

import java.util.ArrayList;

public class MainClass
{

	public static void main(String[] args)
	{
		ArrayList<Ball> ballList = new ArrayList<Ball>();
		
		ballList.add(new BasketBall());
		ballList.add(new Football());
		ballList.add(new BasketBall());
		ballList.add(new Football());
		ballList.add(new BasketBall());
		ballList.add(new WhiffleBall());

		for(Ball b: ballList )
		{
			b.bounce();
		}
		

	}

}
