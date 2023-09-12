import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;
import javax.swing.Timer;

/**
 * Created by Nathan on 3/22/14.
 */
public  class Simulation implements ActionListener
{
    public static int transactionRate = 1000;
    public static LinkedBlockingQueue<Transaction> requestQueue;
    public static LinkedBlockingQueue<Transaction> responseQueue;
    static ArrayList<Bank> banks;
    static ThreadManager threadManager;
    String[] strBanks = new String[]{"Wells Fargo", "Bank of America", "Chase", "Citi"};
    Timer timer;



    public Simulation()
    {
        banks = new ArrayList<Bank>();
        for (int i = 0; i < 4; i++)
        {
            banks.add(new Bank(strBanks[i]));
        }

        timer = new Timer(transactionRate,this);
        requestQueue = new LinkedBlockingQueue<Transaction>();
        responseQueue = new LinkedBlockingQueue<Transaction>();
        threadManager = new ThreadManager(requestQueue, responseQueue, banks);

        timer.start();

    }

    public void actionPerformed(ActionEvent e)
    {
        timer.setDelay(transactionRate);
        //simulate transactions
        Random rand = new Random();
        int randomNum = rand.nextInt((3) + 1);
        String randBank = strBanks[randomNum];

        Random rand1 = new Random();
        int randAccount = rand1.nextInt(Integer.MAX_VALUE) + 1;
        double randAmount = (int) (Math.random() * 10000) / 100.0;
        boolean authorized = false;
        Transaction t = new Transaction(randBank, randAccount, randAmount, authorized);
       // requestQueue.add(t);
        try
        {
            requestQueue.put(t);
        }
        catch (InterruptedException ie)
        {
            ie.printStackTrace();
        }


    }

    public static Bank getBank(String bankIn)
    {
        Bank bankFound = null;
        for (Bank b : banks)
        {
            if (bankIn.equals(b.name))
            {
                bankFound = b;
                return bankFound;
            }
        }

        return bankFound;
    }
}
