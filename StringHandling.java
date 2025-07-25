import java.util.Scanner;

public class StringHandling {

    public static void main(String[] args) {
        menu();
    }

    static void menu() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter a string:");
            String str = sc.nextLine();

            System.out.println("Choose a function to perform:");
            System.out.println("1. Convert to Uppercase");
            System.out.println("2. Convert to Lowercase");
            System.out.println("3. Get Length of String");
            System.out.println("4. Check if String is Empty");
            System.out.println("5. Trim Whitespace");
            System.out.println("6. Concatenate String");
            System.out.println("7. Check if String contains another String");
            System.out.println("8. Check if String starts with a prefix");
            System.out.println("9. Check if String ends with a suffix");
            System.out.println("10. Reverse String");
			System.out.println("11.indexOf function");
		
            System.out.println("12. Exit the program...");

            int choice = sc.nextInt(); 
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    // Convert to uppercase
                    System.out.println("Uppercase: " + str.toUpperCase());
                    break;
                case 2:
                    // Convert to lowercase
                    System.out.println("Lowercase: " + str.toLowerCase());
                    break;
                case 3:
                    // Get the length of the string
                    System.out.println("Length: " + str.length());
                    break;
                case 4:
                    // Check if the string is empty
                    if (str.isEmpty()) {
                        System.out.println("The string is empty.");
                    } else {
                        System.out.println("The string is not empty.");
                    }
                    break;
                case 5:
                    // Trim the string
                    System.out.println("Trimmed: '" + str.trim() + "'");
                    break;
                case 6:
                    // Concatenate string
                    System.out.print("Enter the string to concatenate with: ");
                    String concatString = sc.nextLine();
                    System.out.println("Concatenated String: " + str.concat(concatString));
                    break;
                case 7:
                    // Check if string contains another string
                    System.out.println("Enter a substring to search:");
                    String substring = sc.nextLine();
                    if (str.contains(substring)) {
                        System.out.println("The string contains the substring.");
                    } else {
                        System.out.println("The string does not contain the substring.");
                    }
                    break;
                case 8:
                    // Check if string starts with a prefix
                    System.out.println("Enter the prefix:");
                    String prefix = sc.nextLine();
                    if (str.startsWith(prefix)) {
                        System.out.println("The string starts with the prefix.");
                    } else {
                        System.out.println("The string does not start with the prefix.");
                    }
                    break;
                case 9:
                    // Check if string ends with a suffix
                    System.out.println("Enter the suffix:");
                    String suffix = sc.nextLine();
                    if (str.endsWith(suffix)) {
                        System.out.println("The string ends with the suffix.");
                    } else {
                        System.out.println("The string does not end with the suffix.");
                    }
                    break;
                case 10:
                    // Reverse the string
                   Scanner sc= new Scanner(System.in);
        
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
          
            reversed += str.charAt(i);
        }
        
        // Print the reversed string
        System.out.println("Reversed String: " + reversed);
    

           break;
		   case 11:
			   System.out.print("Enter a character to search for: ");
        String search = sc.nextLine();
        
        // Use the indexOf() method and print the result directly
        System.out.println("The index of \"" + search + "\" is: " + str.indexOf(search));
		  
		  break;
		 
                case 12:
                    // Exit the program
                    System.out.println("Exiting the program...");
                    sc.close(); 
                    return; 
                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 11.");
            }
        }
    }
	}