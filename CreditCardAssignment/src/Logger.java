import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Logger
{
	private File logFile;
	private PrintWriter log;
	
	public Logger(String fileName)
	{
		logFile = new File(fileName);
		
		try
		{
			log = new PrintWriter(logFile);
			log.println("Log File Open, Begin logging...");
		}
		catch(IOException e)
		{
			System.out.println("Error, log file " + fileName + " not found");	
		}
	}
	
	synchronized public void writeLog(String logEntry)
	{
		Date timestamp = new Date();
		SimpleDateFormat df = new SimpleDateFormat("[MM/dd/YYYY hh:mm:ss] ");
		
		log.println(df.format(timestamp)+logEntry);
		log.flush();
	}
	

}
