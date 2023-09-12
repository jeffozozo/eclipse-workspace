import java.util.Date;


public class DashBoardData
{
	int CitiTotalTime = 0;
	double CitiAvgTime = 0;
	int CitiNumTxns=0;
	
	int BofATotalTime = 0;
	double BofAAvgTime = 0;
	int BofANumTxns = 0;
	
	int ChaseTotalTime = 0;
	double ChaseAvgTime = 0;
	int ChaseNumTxns = 0;
	
	int WellsFargoTotalTime = 0;
	double  WellsFargoAvgTime = 0;
	int WellsFargoNumTxns = 0;
	
	Date StartTime;
	
	int numThreads;
	int pendingRequests;
	int txnsProcessed;
}
