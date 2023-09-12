package missileSimulator;

public class missileSimulator {

	private static final String secret_key_code="X12DaYQQ12F13$*";
	public static void main(String[] args) 
	{
		missile ms1 = new missile(-114,87,120,87);
		
		ms1.track();
		
		ms1.launch(secret_key_code);
		ms1.arm(secret_key_code);
		
		while(ms1.move())
		{
			ms1.track();			
		}
		
		
		
		
		
	}

}

