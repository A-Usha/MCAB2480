import java.util.Scanner;

class parityCheck {
    public static void main(String[] args) {
        // Create a scanner object to read input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a binary string number: ");
        String binaryString = sc.nextLine();
        
        int countOnes = 0;
        for (int i = 0; i < binaryString.length(); i++) {
            if (binaryString.charAt(i) == '1') {
                countOnes++;
            }
        }

        // Check current parity and modify the string
        if (countOnes % 2 == 0) {
            binaryString += "1";  
            
            System.out.println("It is Odd parity: " + binaryString);
        } else {
            binaryString += "1";  
				System.out.println("It is Even parity: " + binaryString);
        }
    }
}
