/**
 * Created by Nathan on 3/22/14.
 */
public class Bank
{
    String name;
    int timesCalled = 1;
    int rand;
    double randTotal = 0.0;

    public Bank(String nameIn)
    {
        name = nameIn;
    }

    public void authorize(Transaction t)
    {
        int authorizedInt = (int)Math.random()*20;
        rand = (int)Math.random()*12 + 1;//between 1 and 12 seconds
        randTotal += rand;
        try
        {
            Thread.sleep(5 * 1000);
            if (authorizedInt != 10) //theoretically, this bank will only authorize 95% of the transactions
                t.authorized = true;
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
