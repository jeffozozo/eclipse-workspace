
public class MainClass
{
	public static void main(String[] args)
	{
		ChatListener listener = new ChatListener(8587);
		ChatSender sender = new ChatSender("Jeff",8588);
		
		Thread L = new Thread(listener);
		L.start();
		
		Thread S = new Thread(sender);
		S.start();
		
		
	}
}
