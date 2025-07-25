class Examp extends Thread{
	public void run()
	{
		System.out.println("JAVA PROGRAMMING");
	
		for(int i=0;i<=5;i++)
		{
			try{
				Thread.sleep(1500);
				System.out.println(i);
			}
			catch(Exception e){
				System.out.println(e);
			}
		}
	}
}
	class Examp1 extends Examp{
		public static void main(String args[]){
			Examp obj=new Examp();
			obj.start();
		}
	}


	

	