package assignment_weeks3Day1;

public class AxisBank extends BankInfo
{
	public void deposit()
	{
		System.out.println("Sub class method:deposit()");

	}
	public static void main(String[] args) 
	{
		System.out.println("Overriding concept");//Method signature(name and parameters)are the same in the superclass and the child class
		AxisBank AB=new AxisBank();
		AB.deposit();
		BankInfo BI=new BankInfo();
		BI.deposit();
	}
}
