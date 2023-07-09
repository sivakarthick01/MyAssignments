package org.system;

//Week3 day1 Assignment 2
public class Desktop extends Computer
{
	public void desktopSize() 
	{
		System.out.println("desktopSize() inside sub class");

	}
public static void main(String[] args) 
{
	Desktop desk=new Desktop();
	System.out.println("<<<<<<<<<<<<Single Inheritance>>>>>>>>>>>");
	desk.desktopSize();
	desk.computerModel();
	
}
}
