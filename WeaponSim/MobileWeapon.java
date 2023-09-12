
public abstract class MobileWeapon 
{
	protected String weaponID;
	protected int currentLat;
	protected int currentLong;
	protected int maxSpeed;
	
	
	
	public String getWeaponID() 
	{
		return weaponID;
	}
	
	public int getCurrentLong() 
	{
		return currentLong;
	}

	public void setCurrentLong(int currentLong) 
	{
		this.currentLong = currentLong;
	}


	public int getCurrentLat() 
	{
		return currentLat;
	}

	public void setCurrentLat(int currentLat) 
	{
		this.currentLat = currentLat;
	}

	
	public abstract void moveTo(int latIn, int longIn);
	public abstract void fireWeapon();
	
}




