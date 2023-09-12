
public class BitCoinMiner implements Runnable
{
	BitCoins bitCoins;
	public static final int probability = 10000000;
	
	public BitCoinMiner(BitCoins totalCoinsIn)
	{
		bitCoins = totalCoinsIn;
	}
	@Override
	public void run()
	{
		while(true)
		{
			if((int)(Math.random()*probability) == 1)
			{
				bitCoins.total++;
			}
		}	
	}

}
