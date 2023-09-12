import java.util.*;


public class HelloWorld 
{

	public static void main(String[] args) 
	{
		int my_num = 0 ;
		int user_num = 1;
		String answer;
		boolean done = false;
		
		Random rand_guy = new Random();
		Scanner sc = new Scanner(System.in);
		

		
		System.out.println("Let's play a game. I'll think of a number and you try to guess it.");
		while(done == false)
		{	
			my_num = rand_guy.nextInt(10)+1;
			user_num = 0;
		
			while(my_num != user_num) 
			{
				System.out.print("Your Guess:");
				String num_in = sc.nextLine();
				user_num = Integer.valueOf(num_in);
				
				if(my_num < user_num)
				{
					System.out.println("Lower. Try again.");
				}
				else if(my_num > user_num)
				{
					System.out.println("Higher. Try again.");
				}
				
			}
			
		
			System.out.println("Nice! The number I thought of was " + Integer.valueOf(my_num));
			System.out.print("Play again?");
			answer = sc.nextLine();
			
			if(answer.contains("n"))
			{
				done = true;
			}
			else
				System.out.println("Ok, let's go, I've got a new number.");
		}
		
		System.out.println("Thanks for playing! See ya!");
		sc.close();

	}

}
