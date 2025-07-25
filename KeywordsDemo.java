import java.util.Scanner;

public class KeywordsDemo{

    public static void main(String[] args) {
        menu();
    }

    static void menu() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("menu");
            System.out.println("1.Super");
            System.out.println("2.This");
			System.out.println("3.final");
            System.out.println("4. Exit the program");
            System.out.print("Choose the correct choice: ");
            int choice = sc.nextInt();
            
            switch (choice) {
                case 1: 
                    superKeywordDemo();
                    break;
                case 2:
                    thisKeywordDemo();
                    break;
                case 3:
                    finalKeywordDemo();
                    break;
                case 4:
                    System.out.println("Exiting the program...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice, please choose a valid option.");
            }
        }
    }

    static void superKeywordDemo() {
        // Demonstration of the 'super' keyword in Java
        System.out.println("Super Keyword Demo:");
        Child child = new Child();
        child.displayMessage(); // This will call the method from the parent class via 'super'
    }

    static void thisKeywordDemo() {
        // Demonstration of the 'this' keyword in Java
        System.out.println("This Keyword Demo:");
        MyClass obj = new MyClass(10);
        obj.displayValue();
    }

    static void finalKeywordDemo() {
        // Demonstration of the 'final' keyword in Java
        System.out.println("Final Keyword Demo:");
        final int A= 100;
        System.out.println("The A value is: " + A);
      
    }

}

class Parent {
    void displayMessage() {
        System.out.println("This is the Parent class");
    }
}

class Child extends Parent {
    // Overriding the method in Child class
    @Override
    void displayMessage() {
        super.displayMessage(); // Call Parent's displayMessage() using 'super'
        System.out.println("This is the Child class");
    }
}

class MyClass {
    int value;

    MyClass(int value) {
        this.value = value; // Using 'this' keyword to refer to the instance variable
    }

    void displayValue() {
        System.out.println("Value is: " + this.value); // Using 'this' to refer to the instance variable
    }
}
