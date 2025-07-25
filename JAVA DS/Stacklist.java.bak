//Stack using list: 
import java.util.*; 

class Node { 
    int data; 
    Node link; 
} 

class Stacklist { 
    static Node head; 
    static Scanner sc = new Scanner(System.in); 

    public static void main(String[] args) { 
        stackoperations(); 
    } 

    public static void stackoperations() { 
        System.out.println("Enter the range of the list: "); 
        int range = sc.nextInt(); 
        System.out.println("Enter the element you want to insert into the stack: "); 

        for (int i = 0; i < range; i++) { 
            pushoperation(); 
        } 

        while (true) { 
            System.out.println("Choose the operation"); 
            System.out.println("1. Push operation"); 
            System.out.println("2. Pop operation"); 
            System.out.println("3. Peek element"); 
            System.out.println("4. Display the stack"); 
            System.out.println("5. Exit from the menu"); 
            int ch = sc.nextInt(); 

            switch (ch) { 
                case 1: 
                    System.out.println("Enter the element you want to insert: "); 
                    pushoperation(); 
                    display(); 
                    break; 
                case 2: 
                    popoperation(); 
                    display(); 
                    break; 
                case 3: 
                    peekelement(); 
                    break; 
                case 4: 
                    display(); 
                    break; 
                case 5: 
                    System.out.println("Terminating from the menu..."); 
                    System.exit(0); 
                    break; 
                default: 
                    System.out.println("Invalid input! Please choose a valid option"); 
            } 
        } 
    } 

    public static void pushoperation() { 
        Node node = new Node(); 
        System.out.println("Enter element to push: "); 
        int fel = sc.nextInt(); 

        node.data = fel; 
        node.link = head; 
        head = node; 
    } 

    public static void popoperation() { 
        if (head == null) { 
            System.out.println("Stack is empty! Cannot pop element from an empty stack."); 
        } else { 
            Node temp = head; 
            head = head.link; 
            temp.link = null; 
            System.out.println("Successfully popped the top element from the stack."); 
        } 
    } 

    public static void peekelement() { 
        if (head == null) { 
            System.out.println("Stack is empty! No element to peek."); 
        } else { 
            System.out.println("The top element in the stack is: " + head.data); 
        } 
    } 

    public static void display() { 
        if (head == null) { 
            System.out.println("Stack is empty!"); 
        } else { 
            System.out.println("The current elements of the stack are: "); 
            Node ptr = head; 
            while (ptr != null) { 
                System.out.print(ptr.data + " "); 
                ptr = ptr.link; 
            } 
            System.out.println(); 
        } 
    } 
}
