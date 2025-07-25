public class Main
{
	static void checkAge(int age)throws ArithmeticException
	{
		if(age<18)
		{
			throw new ArithmeticException("you are under age");
		}
		else
		{
			System.out.println("you are eligible");
		}
	}
	public static void main(String args[])
	{
		checkAge(15);
	}
}
		
