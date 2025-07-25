class Method extends Thread {
    public void run() {
        System.out.println("Thread " + getName() + " is running");
        System.out.println("JAVA PROGRAMMING");
        for (int i = 0; i <= 3; i++) {
            try {
                Thread.sleep(1000);
                System.out.println(i);
            } catch (InterruptedException ie) {
                System.out.println(ie);
            }
        }
    }
}

public class Method1 {
    public static void main(String args[]) {
       
        Method obj = new Method();
        obj.setName("JAVA THREADS FUNCTIONS");  
        obj.start(); 
        
        try {
            obj.join(); 
            System.out.println("Thread is alive or not? " + obj.isAlive());
        } catch (Exception e) {
            System.out.println("Main thread is interrupted: " + e);
        }
        
       
        System.out.println("Thread " + obj.getName() + " has finished execution");
    }
}

