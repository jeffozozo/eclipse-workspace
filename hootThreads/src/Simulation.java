/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 * @author joshuahootman
 */
public class Simulation{

   // private Threadmanager manager = new Threadmanager();
    private LinkedBlockingQueue<Transaction> inputQueue = new LinkedBlockingQueue<Transaction>();
    private LinkedBlockingQueue<Transaction> responseQueue = new LinkedBlockingQueue<Transaction>();
    private Log log = new Log();
    private Timer timer;
    private int TransactionsEverySecond = 1000;//milliseconds

    private Bank Citi ;
    private Bank USAA ;
    private Bank WrightPatt;
    private Bank Weber;
    
    


    public Simulation() throws InterruptedException {
        SetUpBanks();
         log.writeLog("Setting up Banks");
         log.writeLog("Starting the Simulation");
        Threadmanager manager = new Threadmanager(inputQueue, responseQueue, log, Citi, USAA, WrightPatt, Weber);
        TransactionScheduler ts = new TransactionScheduler(inputQueue, log);
        timer = new Timer();
          manager.AddThread();
         manager.AddThread();
         manager.AddThread();
         timer.schedule(ts, 0,TransactionsEverySecond);
       //  manager.AddThread();
       
    
    
    }


    public void SetUpBanks() {
        Citi = new Bank(10, 100);
        USAA = new Bank(1, 100);
        WrightPatt = new Bank(200, 5000);
        Weber = new Bank(600, 80000);

    }

}
