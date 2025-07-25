
import java.util.*;

class ControlStructures {
    public static void main(String args[]) {
        menu();
    }

    static void menu() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Hello, welcome to JAVA programming");
            System.out.println("Control structures");
            System.out.println("Enter any option");
            System.out.println("1. Conditional");
            System.out.println("2. Looping");
            System.out.println("3. Jumping");
            System.out.println("4. Exit");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    while (true) {
                        System.out.println("1. Conditional");
                        System.out.println("Select any option");
                        System.out.println("1. if");
                        System.out.println("2. ifelse");
                        System.out.println("3. nested if");
                        System.out.println("4. Go back");
                        int select = sc.nextInt();
                        switch (select) {
                            case 1:
                                System.out.println("Enter age:");
                                int age = sc.nextInt();
                                if (age >= 18) {
                                    System.out.println("You are eligible for voting.");
                                }
                                break;
                            case 2:
                                System.out.println("Enter any number:");
                                int num = sc.nextInt();
                                if (num % 2 == 0) {
                                    System.out.println("Even number.");
                                } else {
                                    System.out.println("Odd number.");
                                }
                                break;
                            case 3:
                                System.out.println("Enter first number:");
                                int a = sc.nextInt();
                                System.out.println("Enter second number:");
                                int b = sc.nextInt();
                                System.out.println("Enter third number:");
                                int c = sc.nextInt();
                                if (a > b && a > c) {
                                    System.out.println("a is the largest.");
                                } else if (b > a && b > c) {
                                    System.out.println("b is the largest.");
                                } else {
                                    System.out.println("c is the largest.");
                                }
                                break;
                            case 4:
                                break;
                            default:
                                System.out.println("Invalid option");
                        }
                        if (select == 4) break;
                    }
                    break;

                case 2:
                    while (true) {
                        System.out.println("Looping");
                        System.out.println("Select any option");
                        System.out.println("1. while");
                        System.out.println("2. do while");
                        System.out.println("3. for");
                        System.out.println("4. Go back");
                        int select1 = sc.nextInt();
                        switch (select1) {
                            case 1:
                                System.out.println("While loop:");
                                int w = 1;
                                while (w <= 10) {
                                    System.out.println(w);
                                    w++;
                                }
                                break;
                            case 2:
                                System.out.println("Enter a number to find the sum of squares:");
                                int n = sc.nextInt();
                                int sum = 0, r = 1;
                                do {
                                    sum =sum+(r * r);
                                    r++;
                                } while (r <= n);
                                System.out.println("Sum of squares is: " + sum);
                                break;
                            case 3:
                                System.out.println("Enter a value to find the factorial:");
                                int f = sc.nextInt();
                                int fact = 1;
                                for (int i = 1; i <= f; i++) {
                                    fact *= i;
                                }
                                System.out.println("Factorial is: " + fact);
                                break;
                            case 4:
                                break;
                            default:
                                System.out.println("Invalid option");
                        }
                        if (select1 == 4) break;
                    }
                    break;

                case 3:
                    while (true) {
                        System.out.println("Jumping");
                        System.out.println("Select any option");
                        System.out.println("1. break");
                        System.out.println("2. continue");
                        System.out.println("3. Go back");
                        int select2 = sc.nextInt();
                        switch (select2) {
                            case 1:
                                for (int i = 0; i <= 3; i++) {
                                    System.out.println("Iteration number: " + i);
                                    if (i == 2) break;
                                }
                                break;
                            case 2:
                                for (int i = 0; i <= 3; i++) {
                                    if (i == 1) continue;
                                    System.out.println("Iteration number: " + i);
                                }
                                break;
                            case 3:
                                break;
                            default:
                                System.out.println("Invalid option");
                        }
                        if (select2 == 3) break;
                    }
                    break;

                case 4:
                    System.out.println("Exiting program...");
                    return;

                default:
                    System.out.println("Invalid option");
            }
        }
    }
}
				
						