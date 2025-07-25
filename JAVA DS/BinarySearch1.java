import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch1 {

    public static void main(String[] args) {
        menu();
    }

    static void menu() {
        Scanner sca = new Scanner(System.in);
        while (true) {
            System.out.println("\nMenu");
            System.out.println("1. Integer");
            System.out.println("2. String");
            System.out.println("3. Character");
            System.out.println("4. Exit the program");
            System.out.print("Choose the correct choice: ");
            int choice = sca.nextInt();
            sca.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    // Integer Binary Search
                    System.out.print("Enter the number of integers: ");
                    int intSize = sca.nextInt();
                    int[] intArray = new int[intSize];
                    System.out.println("Enter " + intSize + " integers:");
                    for (int i = 0; i < intSize; i++) {
                        intArray[i] = sca.nextInt();
                    }
                    Arrays.sort(intArray); // Sort for binary search
                    System.out.print("Enter integer to search: ");
                    int intKey = sca.nextInt();

                    int intIndex = Arrays.binarySearch(intArray, intKey);
                    if (intIndex >= 0) {
                        System.out.println("Element " + intKey + " found at index " + intIndex);
                    } else {
                        System.out.println("Element " + intKey + " not found.");
                    }
                    break;

                case 2:
                    // String Binary Search
                    System.out.print("Enter the number of strings: ");
                    int strSize = sca.nextInt();
                    sca.nextLine(); // consume newline
                    String[] strArray = new String[strSize];
                    System.out.println("Enter " + strSize + " strings:");
                    for (int i = 0; i < strSize; i++) {
                        strArray[i] = sca.nextLine();
                    }
                    Arrays.sort(strArray);
                    System.out.print("Enter string to search: ");
                    String strKey = sca.nextLine();

                    int strIndex = Arrays.binarySearch(strArray, strKey);
                    if (strIndex >= 0) {
                        System.out.println("Element \"" + strKey + "\" found at index " + strIndex);
                    } else {
                        System.out.println("Element \"" + strKey + "\" not found.");
                    }
                    break;

                case 3:
                    // Character Binary Search
                    System.out.print("Enter the number of characters: ");
                    int charSize = sca.nextInt();
                    char[] charArray = new char[charSize];
                    System.out.println("Enter " + charSize + " characters:");
                    for (int i = 0; i < charSize; i++) {
                        charArray[i] = sca.next().charAt(0);
                    }
                    Arrays.sort(charArray);
                    System.out.print("Enter character to search: ");
                    char charKey = sca.next().charAt(0);

                    int charIndex = Arrays.binarySearch(charArray, charKey);
                    if (charIndex >= 0) {
                        System.out.println("Character '" + charKey + "' found at index " + charIndex);
                    } else {
                        System.out.println("Character '" + charKey + "' not found.");
                    }
                    break;

                case 4:
                    System.out.println("Exiting program.");
                    return;

                default:
                    System.out.println("Invalid choice! Please enter 1, 2, 3, or 4.");
            }
        }
    }
}    