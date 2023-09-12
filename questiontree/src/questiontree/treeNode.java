package questiontree;

public class treeNode
{

	private String question;
	public treeNode yes, no;
	
	public treeNode(String s_in)
	{
		question = s_in;
	}
	
	public void printNode()
	{
		System.out.println(question);
	}
	
	
}
