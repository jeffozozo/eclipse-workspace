import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Logger 
{
	private final String logFileName = "HomeAutomation.log";
	private File logFile;
	String log;
	
	public Logger()
	{

		logFile = new File(logFileName);
	}
	
	public void write(String s)
	{
		PrintWriter pw;
		try {
			pw = new PrintWriter(new FileWriter(logFile),true);
			pw.println(s);
			pw.close();
		} catch (IOException e) {
		
			System.out.println("Logger failed to open the log file " + logFileName);
		}

	}
	
	
	
	
}
