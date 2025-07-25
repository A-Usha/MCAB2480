//SNYCHRONIZATION EXAMPLE
//MAIN AND NEW THREAD WILL EXECUTE AT SAME TIME
//class MyThread extends Thread{
	//public void run(){
	//	System.out.println("Welcome");
	////	System.out.println("To java programming");
	//}
//}
//class MyThread1{
	//public static void main(String args[]){
		
//MyThread myThread=new MyThread();
//myThread.start();
//System.out.println("Thank you.....");
	//}
//}


//ASYNCHRONIZATION EXAMPLE
//EXECUTES IN DIFF TIME

class MyThread extends Thread{
	public void run(){
		System.out.println("Welcome");
		for(int i=0;i<=3;i++){
			System.out.println(i);
		}
	}
}
class MyThread1 extends Thread{
	public void run(){
		System.out.println("TO JAVA PROGRAMMING");
		for(int i=0;i<=3;i++){
			System.out.println(i);
		}
	}
}
		
class AsynchronousExample{
	
public static void main(String args[]){
	MyThread obj=new MyThread();
	MyThread1 obj1=new MyThread1();
	obj.start();
	obj1.start();
}
}
		
		
		
		
		
		
		
		
		

