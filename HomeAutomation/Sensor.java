import java.util.Date;


public class Sensor extends ControllableObject 
{

	public Sensor(String nameIn)
	{
		name = nameIn;
		this.setOff();
	}
	
	public void doAction(Action a)
	{
		if(a == Action.trigger)
		{
			Date d = new Date();
			log.write(this.getName() + " sensor was triggered at " + d );
			this.setOn();	
		}	
		else if(a == Action.untrigger)
		{
			Date d = new Date();
			log.write(this.getName() + " sensor was untriggered at " + d);
			this.setOff();
		}	
		
		
		
	}
}
