
public class StudentList 
{
	int currentNumStudents;
	Student[] studentList;
	
	
	public StudentList()
	{
		studentList= new Student[10];
		currentNumStudents=0;
	}
	
	
	
	// use the 'currentNumStudents' as a way to keep track of the next
	// student to add
	public void addStudent(Student studentToAdd)
	{

			studentList[currentNumStudents]=studentToAdd;
			currentNumStudents++;  // increment the counter.
			
		// This will throw an array out of bound exception if you try to add more than 10 students
	}
	
	
	public void printStudentList()
	{
		for(int i=0;i<currentNumStudents;i++)
		{
			studentList[i].printStudent();
		}
	}
	
	
}
