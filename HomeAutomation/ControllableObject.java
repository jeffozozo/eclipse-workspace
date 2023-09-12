
public abstract class ControllableObject 
{	
	protected String name;
	protected ControllerState state;
	
	protected Logger log;
	
	public void setLogger(Logger logIn)
	{
		log = logIn;
	}
	
	public boolean isOn()
	{
		return(state == ControllerState.on);
	}
	
	public void setOn()
	{
		state = ControllerState.on;
	}
	
	public void setOff()
	{
		state = ControllerState.on;
	}
	
	
	public void toggleState()
	{	
		if(state == ControllerState.on)
			state = ControllerState.off;
		else
			state = ControllerState.on;
	}
	
	public String getName()
	{
		return name;
	}
	
	public abstract void doAction(Action a);

	
}
