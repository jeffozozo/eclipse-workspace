package treetester;

public class treeClass
{
	public treeNode head;
	
	public void insertNode(int value, treeNode current)
	{
		treeNode temp = new treeNode( value );
		
		if(head == null)
		{
			head = temp;
			return;
		}

		
		if(current == null)
		{
			current = temp;
		}
		else
		{
			if(value < current.value)
			{	
				if(current.left != null)
					insertNode(value,current.left);
				else
					current.left = temp;
			}
			else if( value > current.value)
			{
				if(current.right != null)
					insertNode(value, current.right);
				else
					current.right = temp;
			}	
			// if value == current.value, ignore. no duplicates
		}	
	}
	
	public void printTree(treeNode current)
	{
		if(current == null)
			return;
		
		printTree(current.left);
		System.out.println(current.value);
		printTree(current.right);
	}
	
}
