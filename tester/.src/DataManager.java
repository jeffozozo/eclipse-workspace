import java.util.ArrayList;

import javax.swing.JOptionPane;

//Nearly every class has a reference to this object
public class DataManager 
{
	protected Lander LunarLander;
	protected GamePanel Game;
	protected ArrayList<Planet> Planets = new ArrayList<Planet>();
	protected SettingsPanel Settings;
	
	//Data passed through this class by other classes
	protected int yVelocity;
	protected String planetName;
	protected int currentPlanetIndex;
	protected int WindowHeight;
	protected int WindowWidth;
	protected boolean gameInProgress;
	protected int betweenGames;
	protected int whatNext;
	protected boolean gamePaused = false;

	//For separate message dialogs when the player wins or loses
	private String[] LoseOptions = { "Try Again", "Quit" };
	private String[] WinOptions = { "Next Level", "Quit" };

	public DataManager() 
	{
		gameInProgress = false;
		
		WindowWidth = 500;
		WindowHeight = 500;

		Moon Level1 = new Moon(this);
		Pluto Level2 = new Pluto(this);
		Earth Level3 = new Earth(this);
		Sun Level4 = new Sun(this);
		Planets.add(Level1);
		Planets.add(Level2);
		Planets.add(Level3);
		Planets.add(Level4);
		
		currentPlanetIndex = 0;
	}

	//Starts a new game. The parameter determines what level is next
	public void newGame(int levelIncrease) 
	{
		currentPlanetIndex += levelIncrease;
		Game.CurrentPlanet = Planets.get(currentPlanetIndex);
		Settings.setPlanetName(Planets.get(currentPlanetIndex).name);
		LunarLander.setCurrentPlanet(Planets.get(currentPlanetIndex));
		LunarLander.reset();
		gameInProgress = true;
	}
	
	//Called by the LunarLander's draw method when the player wins
	protected void win() 
	{
		gameInProgress = false;
		whatNext = JOptionPane.showOptionDialog(null,
				"You landed safely!!!", "Nice one!", JOptionPane.NO_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, WinOptions, 1);
		
		if (whatNext == 0)
		{
			newGame(1);
		}
		else
			System.exit(0);
	}
	
	//Called by the LunarLander's draw method when the player loses
	protected void lose() 
	{
		gameInProgress = false;
		if (currentPlanetIndex < 3)
		{
			whatNext = JOptionPane.showOptionDialog(null, "You crashed!!!",
					"Oh no!", JOptionPane.NO_OPTION, JOptionPane.WARNING_MESSAGE,
					null, LoseOptions, 1);
		}
		else
			whatNext = JOptionPane.showOptionDialog(null, "You crashed!!!",
					"You can't land on the sun, genius", JOptionPane.NO_OPTION, JOptionPane.WARNING_MESSAGE,
					null, LoseOptions, 1);
		
		if (whatNext == 0)
		{
			newGame(0);
		}
		else
			System.exit(0);
	}

}
