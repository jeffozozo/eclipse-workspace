package lunarLander;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class landerSimulator 
{
	public static void main(String args[])
	{
		planet moon = new planet("The moon",1500,1.622);
		lander theLander = new lander(moon.atmosphere_height,moon.gravity,100);
		int fuel=0;
		
		while(theLander.next_second(fuel,moon.name))
		{			
			theLander.printLocation();
			fuel = getFuelToUse();
		}
		
	}
	
	public static int getFuelToUse()
	{
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int fuelToUse = -1;
		
		while(fuelToUse < 0 || fuelToUse > 11 )
		{
			System.out.print("Enter amount of fuel to use: ");
			
			try 
			{
				String choice = bufferedReader.readLine();
				fuelToUse = Integer.valueOf(choice);	
			} 
			catch (IOException e) 
			{	
				e.printStackTrace();
			}
			
			if(fuelToUse < 0 || fuelToUse > 11)
			{
				System.out.println("Choose a number between 0 and 11.");
			}
			
		}
		
		return fuelToUse;
	}
	
	
}
