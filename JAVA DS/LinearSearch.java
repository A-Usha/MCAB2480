import java.util.Scanner;

public class LinearSearch {

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
                    // Integer Linear Search
                    System.out.print("Enter the number of integers: ");
                    int intSize = sca.nextInt();
                    int[] intArray = new int[intSize];
                    System.out.println("Enter " + intSize + " integers:");
                    for (int i = 0; i < intSize; i++) {
                        intArray[i] = sca.nextInt();
                    }
                    System.out.print("Enter integer to search: ");
                    int intKey = sca.nextInt();

                    boolean intFound = false;
                    int intIndex = -1;
                    for (int i = 0; i < intSize; i++) {
                        if (intArray[i] == intKey) {
                            intFound = true;
                            intIndex = i;
                            break;
                        }
                    }
                    if (intFound) {
                        System.out.println("Element " + intKey + " found at index " + intIndex);
                    } else {
                        System.out.println("Element " + intKey + " not found.");
                    }
                    break;

                case 2:
                    // String Linear Search
                    System.out.print("Enter the number of strings: ");
                    int strSize = sca.nextInt();
                    sca.nextLine(); // consume newline
                    String[] strArray = new String[strSize];
                    System.out.println("Enter " + strSize + " strings:");
                    for (int i = 0; i < strSize; i++) {
                        strArray[i] = sca.nextLine();
                    }
                    System.out.print("Enter string to search: ");
                    String strKey = sca.nextLine();

                    boolean strFound = false;
                    int strIndex = -1;
                    for (int i = 0; i < strSize; i++) {
                        if (strArray[i].equals(strKey)) {
                            strFound = true;
                            strIndex = i;
                            break;
                        }
                    }
                    if (strFound) {
                        System.out.println("Element \"" + strKey + "\" found at index " + strIndex);
                    } else {
                        System.out.println("Element \"" + strKey + "\" not found.");
                    }
                    break;

                case 3:
                    // Character Linear Search
                    System.out.print("Enter the number of characters: ");
                    int charSize = sca.nextInt();
                    char[] charArray = new char[charSize];
                    System.out.println("Enter " + charSize + " characters:");
                    for (int i = 0; i < charSize; i++) {
                        charArray[i] = sca.next().charAt(0);
                    }
                    System.out.print("Enter character to search: ");
                    char charKey = sca.next().charAt(0);

                    boolean charFound = false;
                    int charIndex = -1;
                    for (int i = 0; i < charSize; i++) {
                        if (charArray[i] == charKey) {
                            charFound = true;
                            charIndex = i;
                            break;
                        }
                    }
                    if (charFound) {
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

