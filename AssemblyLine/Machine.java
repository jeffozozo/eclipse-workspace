
public abstract class Machine 
{
	private static int currentSerialNum=0;
	
	static int generateSerialNum()
	{
		currentSerialNum++;
		return currentSerialNum;
	}
	
	 
	public abstract void build(Car carIn);
	


}
