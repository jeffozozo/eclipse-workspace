import java.util.Date;


public class Switch extends ControllableObject 
{

	public Switch(String nameIn)
	{
		name = nameIn;
		this.setOff();
	}
	
	@Override
	public void doAction(Action a) 
	{
		if(a == Action.on)
		{
			Date d = new Date();
			log.write(this.getName() + " swtich was turned on at " + d );
			this.setOn();	
		}	
		else if(a == Action.off)
		{
			Date d = new Date();
			log.write(this.getName() + " switch was turned off at " + d);
			this.setOff();
		}	

	}

}
