
public class BodyBuilder extends Machine 
{
	@Override
	public void build(Car carIn) 
	{
		
		String[] bodyStyles = {"beetle","corvette","police car","truck","porche"};	
		String[] paintColors = {"red","green","blue","yellow","purple","orange"};
		
		int bodyChoice =  (int) Math.round((Math.random() * 4));
		int colorChoice = (int) Math.round((Math.random() * 4));
		
		Body theBody = new Body(bodyStyles[bodyChoice],Machine.generateSerialNum());
		theBody.paint(paintColors[colorChoice]);
		carIn.setBody(theBody);
	}
}
