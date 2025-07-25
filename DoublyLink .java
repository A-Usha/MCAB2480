import java.util.Scanner;

class Node {
    int data;
    Node next;
    Node prev;
}

class DoublyLink {
    Node header;

    // Insert at the beginning
    public void insertF(int x) {
        Node temp = new Node();
        if (temp == null) {
            System.out.println("No insertion");
        } else {
            temp.data = x;
            temp.next = header;
            temp.prev = null;
            if (header != null) {
                header.prev = temp;  // Update previous pointer of the old header
            }
            header = temp;
        }
    }

    // Insert at the last
    public void insertLast(int x) {
        Node temp = new Node();
        temp.data = x;
        temp.next = null;

        if (header == null) {
            temp.prev = null;
            header = temp;
        } else {
            Node ptr = header;
            while (ptr.next != null) {
                ptr = ptr.next;
            }
            ptr.next = temp;
            temp.prev = ptr;  // Set previous pointer of the new node
        }
    }

    // Insert at any position
    public void insertAtany(int x, int pos) {
        Node temp = new Node();
        temp.data = x;

        if (pos == 1) {
            insertF(x);  // Use insert at beginning if position is 1
            return;
        }

        Node ptr = header;
        for (int i = 1; i < pos - 1 && ptr != null; i++) {
            ptr = ptr.next;
        }

        if (ptr == null) {
            System.out.println("Position out of range.");
        } else {
            temp.next = ptr.next;
            if (ptr.next != null) {
                ptr.next.prev = temp;  // Update previous pointer of the next node
            }
            temp.prev = ptr;
            ptr.next = temp;
        }
    }

    // Delete first element
    public void deleteFirst() {
        if (header == null) {
            System.out.println("List is empty");
        } else {
            if (header.next != null) {
                header.next.prev = null;  // Update previous pointer of the second node
            }
            header = header.next;
        }
    }

    // Delete last element
    public void deleteLast() {
        if (header == null) {
            System.out.println("List is empty");
        } else if (header.next == null) {
            header = null;
        } else {
            Node ptr = header;
            while (ptr.next != null) {
                ptr = ptr.next;
            }
            ptr.prev.next = null;  // Remove the last node by updating the previous node's next pointer
        }
    }

    // Delete at any position
    public void deleteAtPosition(int pos) {
        if (header == null) {
            System.out.println("List is empty");
            return;
        }

        if (pos == 1) {
            deleteFirst();
            return;
        }

        Node ptr = header;
        for (int i = 1; i < pos && ptr != null; i++) {
            ptr = ptr.next;
        }

        if (ptr == null) {
            System.out.println("Position out of range.");
        } else {
            if (ptr.next != null) {
                ptr.next.prev = ptr.prev;  // Update the previous pointer of the next node
            }
            if (ptr.prev != null) {
                ptr.prev.next = ptr.next;  // Update the next pointer of the previous node
            }
        }
    }

    // Search an element
    public void search(int x) {
        Node ptr = header;
        while (ptr != null) {
            if (ptr.data == x) {
                System.out.println("Element " + x + " found.");
                return;
            }
            ptr = ptr.next;
        }
        System.out.println("Element " + x + " not found.");
    }

    // Sort the list (ascending order)
    public void sort() {
        if (header == null || header.next == null) {
            return;
        }

        for (Node i = header; i != null; i = i.next) {
            for (Node j = i.next; j != null; j = j.next) {
                if (i.data > j.data) {
                    int temp = i.data;
                    i.data = j.data;
                    j.data = temp;
                }
            }
        }
    }

    // Merge two linked lists
    public DoublyLink merge(DoublyLink otherList) {
        DoublyLink mergedList = new DoublyLink();
        Node ptr1 = this.header;
        Node ptr2 = otherList.header;

        while (ptr1 != null) {
            mergedList.insertLast(ptr1.data);
            ptr1 = ptr1.next;
        }

        while (ptr2 != null) {
            mergedList.insertLast(ptr2.data);
            ptr2 = ptr2.next;
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
            ptr = ptr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DoublyLink list1 = new DoublyLink();
        DoublyLink list2 = new DoublyLink();
        int choice, element, pos;

        // Input values for list1
        System.out.println("Enter elements for List 1 (enter -1 to stop):");
        while (true) {
            System.out.print("Enter element to insert into List 1: ");
            element = sc.nextInt();
            if (element == -1) break;  // Stop when user enters -1
            list1.insertLast(element);
        }

        // Input values for list2
        System.out.println("Enter elements for List 2 (enter -1 to stop):");
        while (true) {
            System.out.print("Enter element to insert into List 2: ");
            element = sc.nextInt();
            if (element == -1) break;  // Stop when user enters -1
            list2.insertLast(element);
        }

        while (true) {
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
                    list1.search(element);
                    break;

                case 8:
                    list1.sort();
                    System.out.println("List sorted.");
                    break;

                case 9:
                    System.out.println("Merging list1 and list2...");
                    DoublyLink mergedList = list1.merge(list2);
                    mergedList.print();
                    break;

                case 10:
                    list1.print();
                    break;

                case 11:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
