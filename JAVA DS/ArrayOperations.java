import java.util.Scanner;

public class ArrayOperations {

    public static void main(String[] args) {
        menu();
    }

    static void menu() {
        Scanner sca = new Scanner(System.in);
        while (true) {
            System.out.println("Menu");
            System.out.println("1. Traversing");
            System.out.println("2. Insertion");
            System.out.println("3. Deletion");
            System.out.println("4. Sorting");
            System.out.println("5. Searching");
            System.out.println("6. Merging");
            System.out.println("7. Exit the program");
            System.out.print("Choose the correct choice: ");
            int choice = sca.nextInt();

            switch (choice) {
                case 1:
					
                    Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements in the array:");
        int len = sc.nextInt();
        int[] arr = new int[len];
        System.out.println("Enter elements:");
        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Array elements are:");
        for (int i = 0; i < len; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
                    break;
                case 2:
					
                    Scanner sc1 = new Scanner(System.in);
        System.out.println("Enter number of elements in the array:");
        int len1 = sc1.nextInt();
        int[] arr1= new int[len1 + 1]; // One extra space for insertion
        System.out.println("Enter elements:");
        for (int i1 = 0; i1 < len1; i1++) {
            arr1[i1] = sc1.nextInt();
        }
        System.out.println("Enter the element to insert:");
        int e = sc1.nextInt();
        System.out.println("Enter the position to insert (0 to " + len1 + "):");
        int pos = sc1.nextInt();

        // Shift elements to the right
        for (int i1 = len1; i1> pos; i1--) {
            arr1[i1] = arr1[i1 - 1];
        }
        arr1[pos] = e;

        System.out.println("Array after insertion:");
        for (int i1 = 0; i1 <= len1; i1++) {
            System.out.print(arr1[i1] + " ");
        }
        System.out.println();
    
                    break;
		case 3:
						
        int len2, pos1, i2;
        Scanner sc2 = new Scanner(System.in);

        // Input number of elements
        System.out.println("Enter number of elements in the array:");
        len2 = sc2.nextInt();
        int[] arr2 = new int[len2];

        // Input array elements
        System.out.println("Enter elements:");
        for (i2 = 0; i2 < len2; i2++) {
            arr2[i2] = sc2.nextInt();
        }

        // Input position to delete
        System.out.println("Enter the index (0-based) of the element to delete:");
        pos1 = sc2.nextInt();

        // Check for valid position
        if (pos1 < 0 || pos1 >= len2) {
            System.out.println("Invalid position!");
            return;
        }

        // Shift elements to the left after deleting
        for (i2 = pos1; i2 < len2 - 1; i2++) {
            arr2[i2] = arr2[i2 + 1];
        }

        // Print array after deletion
        System.out.println("Array after deletion:");
        for (i2 = 0; i2 < len2 - 1; i2++) {
            System.out.print(arr2[i2] + " ");
        }
        System.out.println();
		break;
    case 4:
		
// Sort method to sort the array
   int len3,i3,j;
        Scanner sc3 = new Scanner(System.in);
        System.out.println("Enter number of elements in the array:");
        len3 = sc3.nextInt();
        int[] arr3 = new int[len3];
        System.out.println("Enter elements:");
        for (i3 = 0; i3< len3; i3++) {
            arr3[i3] = sc3.nextInt();
        }
        // Sorting the array in ascending order
        for (i3 = 0; i3 < len3 - 1; i3++) {
            for (j = 0; j < len3-1; j++) {
                if (arr3[j] > arr3[j+1]) {
                    // Swap
                    int temp = arr3[j];
                    arr3[j] = arr3[j+1];
                    arr3[j+1] = temp;
                }
            }
        }
        System.out.println("Array after sorting:");
        for (i3 = 0; i3 < len3; i3++) {
            System.out.print(arr3[i3] + " ");
        }
        System.out.println();
		case 5:
        int size, key, m;
        boolean found = false;
        Scanner sc5 = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array:");
        size = sc5.nextInt();
        int[] ar = new int[size];
        System.out.println("Enter the elements of the array:");
        for (m = 0; m < size; m++) {
            ar[m] = sc5.nextInt();
        }
        System.out.println("Enter the element to search for:");
        key = sc5.nextInt();
        for (m = 0; m< size; m++) {
            if (ar[m] == key) {
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("Element " + key + " found at index " + m);
        } else {
            System.out.println("Element " + key + " not found in the array.");
        }
    
break;


         case 6:
        int j1, size1, size2, count, k;
        Scanner sc4 = new Scanner(System.in);
        System.out.println("Enter size of first array:");
        size1 = sc4.nextInt();
        System.out.println("Enter size of second array:");
        size2 = sc4.nextInt();
        int[] a = new int[size1];
        int[] b = new int[size2];
        System.out.println("Enter elements of first array:");
        for (k = 0; k < size1; k++) {
            a[k] = sc4.nextInt();
        }
        System.out.println("Enter elements of second array:");
        for (k = 0; k < size2; k++) {
            b[k] = sc4.nextInt();
        }
        int[] c = new int[size1 + size2];
        for (k = 0; k < size1; k++) {
            c[k] = a[k];
        }
        count = 0;
        for (j1 = size2; j1 < size1 + size2; j1++) {
            c[j1] = b[count];
            count++;
        }

        // Print the merged array
        System.out.println("Merged array:");
        for (j1 = 0; j1 < size1 + size2; j1++) {
            System.out.print(c[j1] + " ");
        }
        System.out.println();
	break;

			
                case 7:
                    System.out.println("Exiting the program.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
}}
