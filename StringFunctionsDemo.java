public class StringFunctionsDemo {
    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "World";
        
        // 1. length() - Returns the length of the string
        System.out.println("Length of str1: " + str1.length());

        // 2. charAt() - Returns the character at a specific index
        System.out.println("Character at index 1 of str1: " + str1.charAt(1));

        // 3. equals() - Compares two strings for equality
        System.out.println("str1 equals str2: " + str1.equals(str2));

        // 4. equalsIgnoreCase() - Compares two strings ignoring case
        System.out.println("str1 equalsIgnoreCase 'hello': " + str1.equalsIgnoreCase("hello"));

        // 5. compareTo() - Compares two strings lexicographically
        System.out.println("str1 compareTo str2: " + str1.compareTo(str2));

        // 6. compareToIgnoreCase() - Compares two strings lexicographically ignoring case
        System.out.println("str1 compareToIgnoreCase 'HELLO': " + str1.compareToIgnoreCase("HELLO"));

        // 7. toUpperCase() - Converts the string to uppercase
        System.out.println("str1 in uppercase: " + str1.toUpperCase());

        // 8. toLowerCase() - Converts the string to lowercase
        System.out.println("str1 in lowercase: " + str1.toLowerCase());

        // 9. trim() - Removes leading and trailing whitespace
        String str3 = "  Hello World  ";
        System.out.println("Trimmed string: '" + str3.trim() + "'");

        // 10. substring() - Extracts a substring from the string
        System.out.println("Substring of str1 from index 1: " + str1.substring(1));

        // 11. substring() - Extracts a substring from index to index
        System.out.println("Substring of str1 from index 1 to 3: " + str1.substring(1, 3));

        // 12. concat() - Concatenates two strings
        System.out.println("Concatenated string: " + str1.concat(" ").concat(str2));

        // 13. contains() - Checks if a substring exists in the string
        System.out.println("Does str1 contain 'el': " + str1.contains("el"));

        // 14. startsWith() - Checks if the string starts with the specified prefix
        System.out.println("Does str1 start with 'He': " + str1.startsWith("He"));

        // 15. endsWith() - Checks if the string ends with the specified suffix
        System.out.println("Does str1 end with 'lo': " + str1.endsWith("lo"));

        // 16. indexOf() - Returns the index of the first occurrence of a substring
        System.out.println("Index of 'l' in str1: " + str1.indexOf('l'));

        // 17. lastIndexOf() - Returns the index of the last occurrence of a substring
        System.out.println("Last index of 'l' in str1: " + str1.lastIndexOf('l'));

        // 18. replace() - Replaces all occurrences of a character with another
        System.out.println("Replacing 'l' with 'z' in str1: " + str1.replace('l', 'z'));

        // 19. split() - Splits the string into an array based on a delimiter
        String str4 = "apple,banana,orange";
        String[] fruits = str4.split(",");
        System.out.println("Fruits array:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        // 20. isEmpty() - Checks if the string is empty
        System.out.println("Is str1 empty: " + str1.isEmpty());

        // 21. valueOf() - Converts other types to a string
        int number = 123;
        System.out.println("Value of number as string: " + String.valueOf(number));

        // 22. format() - Formats a string with placeholders
        String formatted = String.format("My name is %s and I am %d years old.", "Alice", 25);
        System.out.println("Formatted string: " + formatted);

        // 23. join() - Joins an array of strings with a delimiter
        String joined = String.join(", ", fruits);
        System.out.println("Joined string: " + joined);
    }
}