public class Sleeper implements Runnable
{
    public void run()
    {

        String importantInfo[] = {
            "Mares eat oats",
            "Does eat oats",
            "Little lambs eat ivy",
            "A kid will eat ivy too"
        };

        for (int i = 0;
             i < importantInfo.length;
             i++) {
            //Pause for 4 seconds
        	try
        	{
            Thread.sleep(1000);
            //Print a message
            System.out.println(importantInfo[i]);
        	}
        	catch(InterruptedException e)
        	{
        		System.out.println("my sleep was interrupted.");
        	}
        }
    }
}