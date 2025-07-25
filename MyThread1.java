//SNYCHRONIZATION EXAMPLE
//MAIN AND NEW THREAD WILL EXECUTE AT SAME TIME
class MyThread extends Thread{
	public void run(){
		System.out.println("Welcome");
		System.out.println("To java programming");
	}
}
class MyThread1{
	public static void main(String args[]){
		
MyThread myThread=new MyThread();
myThread.start();
System.out.println("Thank you.....");
	}
}
