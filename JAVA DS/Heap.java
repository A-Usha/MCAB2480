import java.util.Scanner;

class Heap {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Heap hp = new Heap();
        hp.sort(arr);
        hp.print(arr);

        sc.close();
    }

    public void sort(int arr1[]) {
        int length = arr1.length;
        for (int i = length / 2 - 1; i >= 0; i--) {
            heapify(arr1, length, i);
        }
        for (int i = length - 1; i >= 0; i--) {
            int temp = arr1[0];
            arr1[0] = arr1[i];
            arr1[i] = temp;
            heapify(arr1, i, 0);
        }
    }

    public void heapify(int[] arr, int n, int i) {
        int largest = i;
        int lc = 2 * i + 1;
        int rc = 2 * i + 2;

        if (lc < n && arr[lc] > arr[largest]) {
            largest = lc;
        }

        if (rc < n && arr[rc] > arr[largest]) {
            largest = rc;
        }

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(arr, n, largest);
        }
    }

    public void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
