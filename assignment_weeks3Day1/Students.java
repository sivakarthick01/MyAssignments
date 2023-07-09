package assignment_weeks3Day1;

import org.student.Student;

//Week 3 Day 1:Method overload Assignment 4

public class Students extends Student
{
	public void getStudentInfo(int id) 
	{
		System.out.println("Passing id argument alone: "+id);

	}
	public void getStudentInfo(int id,String name) 
	{
		System.out.println("Passing id and name argument: "+id+" "+name);

	}
	public void getStudentInfo(String email,String phonenumber) 
	{
		System.out.println("Passing id and name argument: "+email+" "+phonenumber);

	}
	public static void main(String[] args)
	{
		Students student=new Students();
		System.out.println("<<<<<Method Overloading>>>>");//When two or more methods in the same class have the same name but different parameters.
		student.getStudentInfo(1234);
		student.getStudentInfo(1234,"sivagami karthick");
		student.getStudentInfo("siva@gmail.com","9123456789");
	}
}
