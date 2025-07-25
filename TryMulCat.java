class TryMulCat
{
public static void main(String args[])
{
System.out.println("Hello world");
try
{
	
		String name="null";
		System.out.println(name.length());
	}

catch(NullPointerException npe)
{
	System.out.println(npe);
	System.out.println("1");
}
//catch(ArrayIndexOutOfBoundException aob)
	//{
	//System.out.println(aob);
	//System.out.println("2");
	//}
	catch(ArithmeticException e)
	{
		System.out.println(e);
		System.out.println("3");
	}
	finally
	{
		System.out.println("Goodbye");
	}
}
}
