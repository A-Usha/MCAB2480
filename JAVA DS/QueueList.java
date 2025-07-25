import java.util.Scanner;
class QueueList{
static class Node
{
	int data;
	Node next;
	Node(int data){
		this.data=data;
		this.next=null;
}
}
private Node front=null;
private Node rear=null;
public void enqueue(int data){
	Node newNode=new Node(data);
	if(rear==null){
		front=rear=newNode;
		return;
	}
	rear.next=newNode;
	rear=newNode;
}
public void dequeue(){
	if(front==null){
		System.out.println("Queue is empty");
		return;
	}
	front=front.next;
	if(front==null){
		rear=null;
	}
}
public void display(){
	if(front==null){
	System.out.println("Queue is empty");
		return;
	}
	Node temp=front;
	while(temp!=null){
		System.out.println(temp.data+"");
		temp=temp.next;
	}
	System.out.println();
}
public static void main(String args[]){
	Scanner sc=new Scanner(System.in);
	QueueList queue=new QueueList();
	while(true){
		System.out.println("\nMenu");
		System.out.println("Queue Operations");
		System.out.println("1.Enqueue");
		System.out.println("2.Dequeue");
		System.out.println("3.Display Queue");
		System.out.println("4.Exit");
		System.out.println("Enter your choice");
		int ch=sc.nextInt();
		switch(ch){
			case 1:
				System.out.println("Enter data to enqueue");
			int data=sc.nextInt();
			queue.enqueue(data);
			break;
			case 2:
				queue.dequeue();
			break;
			case 3:
				queue.display();
			break;
			case 4:
				System.out.println("Exiting from program...");
			sc.close();
			System.exit(0);
			break;
			default:
				System.out.println("Invalid choice");
		}
	}
}
}

		
		