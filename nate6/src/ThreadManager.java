
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Nathan on 3/25/14.
 */
public class ThreadManager
{
    static ArrayList<WorkerThread> workerList;
    ArrayList<Bank> bankList;
    LinkedBlockingQueue requestQueue;
    LinkedBlockingQueue responseQueue;

    public ThreadManager(LinkedBlockingQueue requestQueueIn, LinkedBlockingQueue responseQueueIn, ArrayList<Bank> banksIn)
    {
        workerList = new ArrayList<WorkerThread>();
        requestQueue = requestQueueIn;
        responseQueue = responseQueueIn;
        bankList = banksIn;

    }

    public void addThread()
    {
        WorkerThread wt = new WorkerThread(bankList, requestQueue, responseQueue);
        //wt.setBanks(bankList);
        //wt.setQueues(request Queue, );

        workerList.add(wt);
        Thread t = new Thread(wt);
        t.start();
    }

    public static void removeThread()
    {
        WorkerThread wt = workerList.get(0);
        wt.finished = true;

        workerList.remove(0);

    }

}
