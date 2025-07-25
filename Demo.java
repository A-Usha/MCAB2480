 
interface I1
{
	void show();
	default void test()
	{
		System.out.println("java");
	}
	static void print()
	{
	System.out.println("os");	
	}
}
interface I2
{
	void m1();
}
interface I3 extends I1,I2
{
	void m2();
}
	class Demo implements I3
	{
		public void show()
		{
			System.out.println("1");
		}
		public void m1()
		{
		System.out.println("2");	
		}
		public void m2()
		{
			System.out.println("3");
		}
		public static void main(String args[])
		{
			Demo d=new Demo();
			d.show();
			d.m1();
			d.m2();
			d.test();
			I1.print();
		}
	}
	