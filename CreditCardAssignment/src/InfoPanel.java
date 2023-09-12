
import java.text.DecimalFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class InfoPanel extends JPanel
{
	private static final long serialVersionUID = 1L;

	//labels
	JLabel empty = new JLabel(" ");
	JLabel workers = new JLabel(" Worker Threads: 0");
	JLabel requestsInQueue = new JLabel(" Requests in Queue: 0");
	
	JLabel citiResponse = new JLabel(" Citibank Avg Response: 0");
	JLabel BofAResponse = new JLabel(" Bank of America Avg Response: 0");
	JLabel chaseResponse = new JLabel(" Chase Avg Response: 0");
	JLabel wellsFargoResponse = new JLabel(" Chase Avg Response: 0");
	
	JLabel txnsProcessed = new JLabel(" Transactions processed: 0");
	JLabel elapsedTime = new JLabel(" Time Elapsed: ");
	JLabel avgTxns = new JLabel(" Avg Txns per second: ");
	
	int startThreads = DashBoardFrame.startThreads;
	
	public InfoPanel()
	{
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createEtchedBorder());
		
		add(workers);
		add(requestsInQueue);
		add(txnsProcessed);
		add(elapsedTime);
		add(avgTxns);
		
		add(empty);
		add(citiResponse);
		add(chaseResponse);
		add(wellsFargoResponse);
		add(BofAResponse);
	}
	
	public void updateData(DashBoardData dataIn)
	{
		DecimalFormat df = new DecimalFormat("###.##");
		
		long millis = (new Date()).getTime() - dataIn.StartTime.getTime();
	
		String elapsed = String.format("%02d:%02d:%02d", 
			    TimeUnit.MILLISECONDS.toHours(millis),
			    TimeUnit.MILLISECONDS.toMinutes(millis) - 
			    TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
			    TimeUnit.MILLISECONDS.toSeconds(millis) - 
			    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
		
		double txns =  (double) dataIn.txnsProcessed /(double)(TimeUnit.MILLISECONDS.toSeconds(millis)) ;	
			
		workers.setText(" Worker Threads: "+ dataIn.numThreads);
		requestsInQueue.setText(" Requests In Queue: "+ dataIn.pendingRequests);
		txnsProcessed.setText(" Transactions Processed: "+ dataIn.txnsProcessed);
		elapsedTime.setText(" Elapsed Time: "+ elapsed);
		avgTxns.setText(" Average Txns per second: "+ df.format(txns));
		
		citiResponse.setText(" Citibank Avg Response: "+ df.format(dataIn.CitiAvgTime));
		BofAResponse.setText(" Bank of America Avg Response: "+ df.format(dataIn.BofAAvgTime));
		chaseResponse.setText(" Chase Avg Response: "+ df.format(dataIn.ChaseAvgTime));
		wellsFargoResponse.setText(" Wells Fargo Avg Response: "+ df.format(dataIn.WellsFargoAvgTime));
		
	}

	
}
