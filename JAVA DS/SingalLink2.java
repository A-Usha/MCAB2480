import java.util.Scanner;

class Node {
    int data;
    Node link;
}

class SingalLink2 {
    Node header;

    // Insert at the beginning
    public void insertF(int x) {
        Node temp = new Node();
        if (temp == null) {
            System.out.println("No insertion");
        } else {
            temp.data = x;
            temp.link = header;
            header = temp;
        }
    }

    // Insert at the last
    public void insertLast(int x) {
        Node temp = new Node();
        temp.data = x;
        temp.link = null;

        if (header == null) {
            header = temp;
        } else {
            Node ptr = header;
            while (ptr.link != null) {
                ptr = ptr.link;
            }
            ptr.link = temp;
        }
    }

    // Insert at any position
    public void insertAtany(int x, int pos) {
        Node temp = new Node();
        temp.data = x;

        if (pos == 1) {
            temp.link = header;
            header = temp;
            return;
        }

        Node ptr = header;
        for (int i = 1; i < pos - 1 && ptr != null; i++) {
            ptr = ptr.link;
        }

        if (ptr == null) {
            System.out.println("Position out of range.");
        } else {
            temp.link = ptr.link;
            ptr.link = temp;
        }
    }

    // Delete first element
    public void deleteFirst() {
        if (header == null) {
            System.out.println("List is empty");
        } else {
            header = header.link;
        }
    }

    // Delete last element
    public void deleteLast() {
        if (header == null) {
            System.out.println("List is empty");
        } else if (header.link == null) {
            header = null;
        } else {
            Node ptr = header;
            while (ptr.link != null && ptr.link.link != null) {
                ptr = ptr.link;
            }
            ptr.link = null;
        }
    }

    // Delete at any position
    public void deleteAtPosition(int pos) {
        if (header == null) {
            System.out.println("List is empty");
            return;
        }

        if (pos == 1) {
            header = header.link;
            return;
        }

        Node ptr = header;
        for (int i = 1; i < pos - 1 && ptr != null; i++) {
            ptr = ptr.link;
        }

        if (ptr == null || ptr.link == null) {
            System.out.println("Position out of range.");
        } else {
            ptr.link = ptr.link.link;
        }
    }

    // Search an element (Modified to print result instead of returning boolean)
    public void search(int x) {
        Node ptr = header;
        while (ptr != null) {
            if (ptr.data == x) {
                System.out.println("Element " + x + " found.");
                return;
            }
            ptr = ptr.link;
        }
        System.out.println("Element " + x + " not found.");
    }

    // Sort the list (ascending order)
    public void sort() {
        if (header == null || header.link == null) {
            return;
        }

        for (Node i = header; i != null; i = i.link) {
            for (Node j = i.link; j != null; j = j.link) {
                if (i.data > j.data) {
                    int temp = i.data;
                    i.data = j.data;
                    j.data = temp;
                }
            }
        }
    }

    // Merge two linked lists
    public SingalLink2 merge(SingalLink2 otherList) {
        SingalLink2 mergedList = new SingalLink2();
        Node ptr1 = this.header;
        Node ptr2 = otherList.header;

        while (ptr1 != null) {
            mergedList.insertLast(ptr1.data);
            ptr1 = ptr1.link;
        }

        while (ptr2 != null) {
            mergedList.insertLast(ptr2.data);
            ptr2 = ptr2.link;
        }
        return mergedList;
    }

    // Print the list
    public void print() {
        if (header == null) {
            System.out.println("List is empty");
            return;
        }

        Node ptr = header;
        while (ptr != null) {
            System.out.print(ptr.data + " ");
            ptr = ptr.link;
        }
        System.out.println();
    }

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SingalLink2 list1 = new SingalLink2();  // Correct type
        SingalLink2 list2 = new SingalLink2();  // Correct type
        int choice, element, pos, numElements;

        // Input values for list1     
       System.out.println("Enter number of elements for List 1:");
        numElements = sc.nextInt();
        System.out.println("Enter elements for List 1:");
        for (int i = 0; i < numElements; i++) {
            element = sc.nextInt();
            list1.insertLast(element);  // Add elements to list1
        }

        // Input values for list2
       System.out.println("Enter number of elements for List 2:");
       numElements = sc.nextInt();
        System.out.println("Enter elements for List 2:");
        for (int i = 0; i < numElements; i++) {
            element = sc.nextInt();
            list2.insertLast(element);  // Add elements to list2
        }

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Insert at beginning");
            System.out.println("2. Insert at last");
            System.out.println("3. Insert at any position");
            System.out.println("4. Delete first element");
            System.out.println("5. Delete last element");
            System.out.println("6. Delete at any position");
            System.out.println("7. Search an element");
            System.out.println("8. Sort the list");
            System.out.println("9. Merge two lists");
            System.out.println("10. Display the list");
            System.out.println("11. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter element to insert at beginning: ");
                    element = sc.nextInt();
                    list1.insertF(element);
                    break;

                case 2:
                    System.out.print("Enter element to insert at last: ");
                    element = sc.nextInt();
                    list1.insertLast(element);
                    break;

                case 3:
                    System.out.print("Enter element to insert: ");
                    element = sc.nextInt();
                    System.out.print("Enter position: ");
                    pos = sc.nextInt();
                    list1.insertAtany(element, pos);
                    break;

                case 4:
                    list1.deleteFirst();
                    break;

                case 5:
                    list1.deleteLast();
                    break;

                case 6:
                    System.out.print("Enter position to delete: ");
                    pos = sc.nextInt();
                    list1.deleteAtPosition(pos);
                    break;

                case 7:
                    System.out.print("Enter element to search: ");
                    element = sc.nextInt();
                    list1.search(element);  // Print result instead of returning boolean
                    break;

                case 8:
                    list1.sort();
                    System.out.println("List sorted.");
                    break;

                case 9:
                    System.out.println("Merging list1 and list2...");
                    SingalLink2 mergedList = list1.merge(list2);
                    mergedList.print();
                    break;

                case 10:
                    list1.print();
                    break;

                case 11:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice, please try again.");
            }
        } while (choice != 11);

        sc.close();
    }
}
