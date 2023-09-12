package treetester;

public class tester
{

	public static void main(String[] args)
	{
		int numList[] ={0,-1,-2,-3,-4,-5,-6,-7,-8, 5, 7, 10, 2, 1, 29};
		treeClass theTree = new treeClass();
		
		for(int i : numList)
		{
			theTree.insertNode(i, theTree.head);
			
		}
		System.out.println("sorted list");

		theTree.printTree(theTree.head);
		
		
	}

}
