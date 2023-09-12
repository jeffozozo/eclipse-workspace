package questiontree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class AllQuestions
{
	private treeNode root;
	private treeNode current;
	
	public AllQuestions()
	{
		root = new treeNode("Think of an animal. Ready?");
		root.yes = new treeNode("Is it an elephant?");
		
	}
	
	public boolean AskQuestion()
	{
		current.printNode();
		String choice = "";
		
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		while(choice==null)
		{

			choice = "";
			try 
			{
				choice = bufferedReader.readLine();
				choice = choice.toUpperCase();
				
				if(choice == "Y")
				{
					System.out.println("Yay! I guessed it!");
					return true;
				}
				else
					System.out.println("ok.");
				
				return false;
								
			} 
			catch (IOException e) 
			{
	
				e.printStackTrace();
			}
		}
		
		return false;

	}
	
	public void addQuestion()
	{
		if(root == null)
		{
			
		}
			
		
	}
	
	
}
