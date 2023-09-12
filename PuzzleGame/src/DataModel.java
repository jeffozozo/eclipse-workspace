import java.util.ArrayList;


public class DataModel
{
	ArrayList<String> questionList = new ArrayList<String>();
	ArrayList<String> answerList = new ArrayList<String>();
	
	int currentQuestion;
	String userAnswer;
	
	public DataModel()
	{
		questionList.add("what color is the sky?");
		answerList.add("blue");

		questionList.add("who is the bus driver?");
		answerList.add("tammy");

		questionList.add("why?");
		answerList.add("because");
		
	}
	
	public String getCurrentQuestion()
	{
		return questionList.get(currentQuestion);
	}
	
	public String getRandomQuestion()
	{
		currentQuestion = (int)(Math.random()*questionList.size());
		return questionList.get(currentQuestion);
	}
	
	public boolean checkAnswer()
	{
		return answerList.get(currentQuestion).compareTo(userAnswer) == 0;
	}
	
	
}
