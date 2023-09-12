/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joshuahootman
 */
public class WorkerThread implements Runnable {
    //add all the banks 

    //add both of the queues
    private LinkedBlockingQueue<Transaction> inputQueue;
    public boolean finished = false;
    private static volatile int _threadID = 1;
    private Bank Citi;
    private Bank USAA;
    private Bank WrightPatt;
    private Bank Weber;
    private Log log;

    public WorkerThread(Bank CitiIN, Bank USAAIN, Bank WrightPattIN, Bank WeberIN, LinkedBlockingQueue<Transaction> inputQueueIN, Log loger) {
        Citi = CitiIN;
        USAA = USAAIN;
        WrightPatt = WrightPattIN;
        Weber = WeberIN;
        log = loger;
        inputQueue = inputQueueIN;
        _threadID++;
        log.writeLog("A Worker Thread has been created: " + _threadID);
    }

    @Override
    public void run() {

        Transaction request;

        while (!finished) {
            try {

                request = null;
                request = inputQueue.poll(100, TimeUnit.MILLISECONDS);
                if (request != null) {

                    processTxn(request);

                } else {
                    System.out.println("Request was null");

                    Thread.sleep(500);
                }

            } catch (InterruptedException ex) {
                Logger.getLogger(WorkerThread.class.getName()).log(Level.SEVERE, null, ex);
            }

            //         System.out.println("Thread is doing something");
        }
    }

    private Bank GetBank(Transaction t) {
        /**
         * use switch statement          *
         * to get the bank*
         */
        switch (t.bankName) {
            case "Citi":
                return Citi;
            case "USAA":
                return USAA;
            case "WrightPatt":
                return WrightPatt;
            case "Weber":
                return Weber;
            default:
                return Citi;
        }
    }

    private void processTxn(Transaction request) throws InterruptedException {
        Bank bankToProcess = GetBank(request);
        bankToProcess.Authorize(request);
        if (request.approved) {
            log.writeLog("Worker Thread +" + _threadID + " Successfully Procesed a "
                    + "Transacton from " + request.bankName);
            return;
        } else {
            while (!request.approved) {
                System.out.println("REJECTED");
                bankToProcess.Authorize(request);
            }
        }
    }
}
