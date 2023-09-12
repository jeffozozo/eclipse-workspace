/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author joshuahootman
 */
public class Bank {
    private long sleepTime;
    private int minTime; //use the mintime + random * maxTime = sleeptime
    private int maxTime;
    private String name;
    
    public Bank(int min, int max){
        minTime = min;
        maxTime = max;
    CalcualteSleep();    
        
    }
    
    public void Authorize(Transaction t) throws InterruptedException
    {
    try
            {
               Thread.sleep(sleepTime);
               
            }
    catch(InterruptedException e){
        t.approved = false;
        throw(e);
    }
    t.approved = (Math.random()*10<8);
    }

    private void CalcualteSleep() {
        sleepTime = (long) (minTime + Math.random()*maxTime);
        
       
    }
    
    public void process(Transaction T){
        
        if ((Math.random() *100) < 80 ){
            T.Approve(true);
    }
    else{
             T.Approve(false);
        }
    }
    
}
