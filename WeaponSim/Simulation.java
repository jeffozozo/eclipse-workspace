import java.util.ArrayList;


public class Simulation 
{

	public static void main(String[] args) 
	{ 
		ArrayList<MobileWeapon> weaponList = new ArrayList<MobileWeapon>();

		weaponList.add(new Tank("Tank1"));
		weaponList.add(new Submarine("Sub1"));
		weaponList.add(new Helicopter("Heli1"));
		
		for(MobileWeapon mw: weaponList)
		{
			
		}
		
		
	}

}
