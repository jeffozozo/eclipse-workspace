
public abstract class Part 
{
	protected String name;
	protected int serialNum;
	
	public Part(){} //default constructor needed because of abstract and protected nature of fields
	public Part(String nameIn, int sNumIn)
	{
		name = nameIn;
		serialNum = sNumIn;
	}
	
	public int getSerialNum()
	{
		return serialNum;
	}
	
	public String getPartName()
	{
		return name;
	}
	
	
}
