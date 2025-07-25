import java.util.Scanner;

public class BinarySearch {

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
                    bubbleSort(intArray); // Custom sort method
                    System.out.print("Enter integer to search: ");
                    int intKey = sca.nextInt();

                    int intIndex = binarySearch(intArray, intKey);
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
                    bubbleSort(strArray); // Custom sort method
                    System.out.print("Enter string to search: ");
                    String strKey = sca.nextLine();

                    int strIndex = binarySearch(strArray, strKey);
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
                    bubbleSort(charArray); // Custom sort method
                    System.out.print("Enter character to search: ");
                    char charKey = sca.next().charAt(0);

                    int charIndex = binarySearch(charArray, charKey);
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

    // Bubble Sort Implementation for sorting arrays manually
    static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j + 1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Bubble Sort Implementation for sorting String arrays manually
    static void bubbleSort(String[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    // Swap arr[j] and arr[j + 1]
                    String temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Bubble Sort Implementation for sorting char arrays manually
    static void bubbleSort(char[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j + 1]
                    char temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Binary Search Implementation for Integer arrays
    static int binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == key) {
                return mid;
            }

            if (arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1; // Element not found
    }

    // Binary Search Implementation for String arrays
    static int binarySearch(String[] arr, String key) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            int result = arr[mid].compareTo(key);

            if (result == 0) {
                return mid;
            }

            if (result < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1; // Element not found
    }

    // Binary Search Implementation for char arrays
    static int binarySearch(char[] arr, char key) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == key) {
                return mid;
            }

            if (arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1; // Element not found
    }
}
