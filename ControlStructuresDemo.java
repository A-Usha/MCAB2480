import java.util.Scanner;
public class ControlStructuresDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. If-Else Statement Example
        System.out.println("1. If-Else Statement Example:");
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();
        
        if (num % 2 == 0) {
            System.out.println(num + " is an even number.");
        } else {
            System.out.println(num + " is an odd number.");
        }

        // 2. Switch Statement Example
        System.out.println("\n2. Switch Statement Example:");
        System.out.print("Enter a day number (1-7): ");
        int day = scanner.nextInt();
        
        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("Invalid day number.");
        }

        // 3. For Loop Example
        System.out.println("\n3. For Loop Example:");
        System.out.print("Enter a number for factorial calculation: ");
        int n = scanner.nextInt();
        
        long factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        System.out.println("Factorial of " + n + " is: " + factorial);

        // 4. While Loop Example
        System.out.println("\n4. While Loop Example:");
        System.out.print("Enter a number to count down from: ");
        int countdown = scanner.nextInt();
        
        while (countdown >= 0) {
            System.out.println("Countdown: " + countdown);
            countdown--;
        }

        // 5. Do-While Loop Example
        System.out.println("\n5. Do-While Loop Example:");
        int choice;
        do {
            System.out.println("Enter a number (1 to exit, any other number to continue): ");
            choice = scanner.nextInt();
            
            if (choice != 1) {
                System.out.println("You entered: " + choice);
            }
        } while (choice != 1);
        
        System.out.println("Program exited!");

        scanner.close();
    }
}