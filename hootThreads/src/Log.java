/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author joshuahootman
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Log {

    private PrintWriter log;
    private File logFile;

    private Date dNow;
    private SimpleDateFormat ft;

      
    public Log() {
        try {
            logFile = new File("Log.txt");
            log = new PrintWriter(logFile);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Log.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //this makes it so that our threads are synchronized and only one thread can
    //access it at a time
    synchronized public void writeLog(String logEntry) {
//log entry is what ever you want it to be and will be printed to the log
        dNow = new Date();
        SimpleDateFormat ft= new SimpleDateFormat("E yyyy.MM.dd ':' hh:mm:ss a");
        log.println("["+ft.format(dNow) +"] " + logEntry);
        log.flush();
    }

}
