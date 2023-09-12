

import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Nathan on 3/25/14.
 */
public class WorkerThread implements Runnable
{
    boolean finished = false;
    ArrayList<WorkerThread> workerList;
    ArrayList<Bank> bankList;
    LinkedBlockingQueue<Transaction> requestQueue;
    LinkedBlockingQueue<Transaction> responseQueue;

    public WorkerThread(ArrayList bankListIn, LinkedBlockingQueue requestQueueIn, LinkedBlockingQueue responseQueueIn)
    {
        /*Thread thread = new Thread(this);
        thread.start();*/
        //ThreadManager.addThread();
        //workerList = workerListIn;
        bankList = bankListIn;
        requestQueue = requestQueueIn;
        responseQueue = responseQueueIn;
    }

    public void run()
    {


        while(!finished)
        {
            Transaction t = null;
            if (requestQueue.size() > 0)
            {
                t = requestQueue.poll(); //get something from the input queue
            }
            else
            {
                return;
            }


            Bank thisBank = Simulation.getBank(t.bankName);//figure out what bank the transaction wants you to call.
            thisBank.authorize(t);
            thisBank.timesCalled++;
            try
            {
                Simulation.responseQueue.put(t); //put the Transaction in the responseQueue.put(t)
               // finished = true;
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }

        }

        ThreadManager.removeThread();
    }

    public void setBanks()
    {

    }

    public void setQueue(LinkedBlockingQueue requestQueueIn)
    {
        requestQueue = requestQueueIn;
    }

}
