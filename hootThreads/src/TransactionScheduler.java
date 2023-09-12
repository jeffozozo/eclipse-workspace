/**
 *created by Joshua Hootman
 *
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.util.TimerTask;
import java.util.concurrent.LinkedBlockingQueue;

public class TransactionScheduler extends TimerTask {
    private LinkedBlockingQueue<Transaction> inputQueue;
    Log log;
    TransactionScheduler(LinkedBlockingQueue<Transaction> input, Log loger) {
        inputQueue = input;
        log = loger;
        log.writeLog("The Transactions Are being Created...");
    }
    
  
    
    @Override
    public void run() {
        String name = GetRandomBankName();
        Transaction t = new Transaction(name);
        System.out.println("Bank Name: " + name);
           inputQueue.add(t);
        System.out.println("Transaction added yo the size of the queue is :" + inputQueue.size());
    }

    private String GetRandomBankName() {
        int R = (int) ((Math.random() * (3 - 0)) + 0);
         switch (R) {
            case 0:
                return "Citi";
            case 1:
                return "USAA";
            case 2:
                return "WrightPatt";
            case 3:
                return "Weber";
            default:
                return "Citi";
        }
    }

}
