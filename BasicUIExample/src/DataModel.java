
public class DataModel
{
	public String studentName;
	public String wNum;
	public String address1;
	public String address2;
	public String city;
	public String state;
	public String color;
	
	@Override
	public String toString()
	{
		StringBuilder s = new StringBuilder();
		
		s.append("Name: "+ studentName + "\n");
		s.append("W#:" +wNum + "\n");
		s.append("address: " + address1 + " " + address2 + ", " + city + " " + state +"\n");
		s.append("favorite color: "+ color);

		return s.toString();
		
	}
	
	public void clear()
	{
		studentName ="";
		wNum="";
		address1 = "";
		address2 = "";
		city = "";
		state = "";
		color = "";
				
	}
}
