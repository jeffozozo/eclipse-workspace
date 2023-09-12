
public class MainClass 
{

	public static void main(String[] args) 
	{
		StudentList slist = new StudentList();
		Student sToAdd;
		
		sToAdd = new Student("Jeff","123");		
		slist.addStudent(sToAdd);

		sToAdd = new Student("Todd","456");		
		slist.addStudent(sToAdd);

		sToAdd = new Student("Sandy","789");		
		slist.addStudent(sToAdd);
		
		slist.printStudentList();
		
		

	}

}
