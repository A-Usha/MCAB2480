import java.util.Scanner;

public class Main2{

    public static void main(String[] args) {
        menu();
    }

    static void menu() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("menu");
            System.out.println("1. Overriding");
            System.out.println("2. Overloading");
            System.out.println("3. Exit the program");
            System.out.print("Choose the correct choice: ");
            int choice = sc.nextInt();
            
            switch (choice) {
                case 1: 
                    // Demonstrating Method Overriding
                    System.out.println("Demonstrating Method Overriding:");
				
                    Animal animal = new Dog();
                    animal.sound(); // This will call Dog's sound method (overridden)
                    break;

                case 2: 
                    // Demonstrating Method Overloading
                    System.out.println("Demonstrating Method Overloading:");
					
             
                    Abc a= new Abc();
                    a.add(5); // Calls add(int a)
                    a.add(); // Calls add() with no arguments
                    break;

                case 3: 
                    // Exit the program
                    System.out.println("Exiting the program....");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice, please choose from 1-3");
            }
        }
    }
}
// Demonstrating Method Overriding
 class Animal {
            void sound() {
             System.out.println("Animal makes a sound");
             }
          }

          class Dog extends Animal {
          @Override
          void sound() {
          System.out.println("Dog barks");
        }
      }      
// Demonstrating Method Overloading
class Abc {
   
                     public void add(int a) {
                  System.out.println("Method with parameters"  +a);
                  }
            public void add() {
            System.out.println("Method with no parameters");
            }
}
