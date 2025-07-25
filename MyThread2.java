//SNYCHRONIZATION EXAMPLE
//MAIN AND NEW THREAD WILL EXECUTE AT SAME TIME
class MyThread extends Thread{
	public void run(){
		this.setName("Thread1");
		
	for(int i=0;i<=3;i++){
		try{
			Thread.sleep(2500);
		System.out.println(this.getName() + " is executing  "+i);
	}
	catch(Exception e){
		System.out.println(e);
	}
	}
	}
}
class MyThread1 extends Thread{
	public void run(){
		this.setName("Thread2");
		
		for(int i=0;i<=3;i++){
			try{
			Thread.sleep(2500);
		System.out.println(this.getName() + " is executing  "+i);
	}
	catch(Exception e){
		System.out.println(e);
		}
	}
}
}
class MyThread2{
	
public static void main(String args[]){
	MyThread obj=new MyThread();
	MyThread1 obj1=new MyThread1();
	obj.start();
	obj1.start();
	 
}
}

		
		
		
		
		
		
		
		
		

