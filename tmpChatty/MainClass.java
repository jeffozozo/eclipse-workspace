
public class MainClass
{
	public static void main(String[] args)
	{
		ChatListener listener = new ChatListener(8588);
		ChatSender sender = new ChatSender("gumby",8587);
		
		Thread L = new Thread(listener);
		L.start();
		
		Thread S = new Thread(sender);
		S.start();
		
		
	}
}
