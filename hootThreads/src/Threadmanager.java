

import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 * @author joshuahootman
 */
public class Threadmanager {

    ArrayList<WorkerThread> _listOfThreads = new ArrayList<WorkerThread>();
    private LinkedBlockingQueue<Transaction> inputQueue;
    private LinkedBlockingQueue<Transaction> responseQueue;
    private Log log;
    Bank Citi;
    Bank USAA;
    Bank WrightPatt;
    Bank Weber;

    public Threadmanager(LinkedBlockingQueue<Transaction> input, LinkedBlockingQueue<Transaction> response, Log loger, Bank CitiIN, Bank USAAIN, Bank WrightPattIN, Bank WeberIN) {
        Citi = CitiIN;
        USAA = USAAIN;
        WrightPatt = WrightPattIN;
        Weber = WeberIN;
        log = loger;
        log.writeLog("The ThreadManager Construct has been called, all information has been passed.");
        inputQueue = input;
        
    }

    public void AddThread() {
        WorkerThread t1 = new WorkerThread(Citi, USAA, WrightPatt, Weber, inputQueue, log);
        _listOfThreads.add(t1);

        Thread temp = new Thread(t1);
        temp.start();

    }

    public void RemoveThread() {
        WorkerThread w = _listOfThreads.get(0);
        w.finished = true;
        _listOfThreads.remove(w);

    }

    public void SleepThread(int threadID) throws InterruptedException {

    }

}
