package assignment_weeks3Day1;

import org.checkerframework.checker.units.qual.m;

public class Automation extends MultipleLangauge implements Language
{
	public void Java() 
	{
		System.out.println("Language interface method java() implemented in concrete class");
		
	}

	@Override
	public void python() 
	{
		System.out.println("Abstract method python() implemented in concrete class");
		
	}
	public static void main(String[] args) 
	{
		System.out.println("I am inside concrete class");
		Automation mclass=new Automation();
		mclass.Java();
		mclass.python();
		mclass.Selenium();
		System.out.println("End of concrete class");
	}
}


