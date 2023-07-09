package org.student;
//week2.Day1 assignment 3
import org.department.Department;

public class Student extends Department
{
	public void studentName() {
		System.out.println("sub class'B':studentName() method");

	}
	public void studentDept() {
		System.out.println("sub class'B':studentDept() method");

	}
	public void studentId() {
		System.out.println("sub class'B':studentId() method");

	}
	public static void main(String[] args) 
	{
	Student std=new Student();
	System.out.println("<<<<<<<<Multilevel Inheritance>>>>>>");
	std.studentDept();
	std.studentId();
	std.studentName();
	std.collegeName();
	std.collegeCode();
	std.collegeRank();
	std.deptName();
	}
}
