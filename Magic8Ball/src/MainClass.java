
public class MainClass
{

	public static void main(String[] args)
	{
		//Magic8BallServer the8Ball = new Magic8BallServer();
		Threaded8BallServer the8Ball = new Threaded8BallServer();
		
		the8Ball.Listen();

	}

}
