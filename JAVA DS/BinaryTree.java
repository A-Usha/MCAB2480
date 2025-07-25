import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = null;
        right = null;
    }
}

class BinaryTree {
    Node root;

    public void insert(int data) {
        root = insertRec(root, data);
    }

    public Node insertRec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else {
            root.right = insertRec(root.right, data);
        }
        return root;
    }

    public void inorder() {
        inorderRec(root);
        System.out.println();
    }

    public void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + "  ");
            inorderRec(root.right);
        }
    }

    public boolean search(int data) {
        return searchRec(root, data);
    }

    public boolean searchRec(Node root, int data) {
        if (root == null) {
            return false;
        }
        if (root.data == data) {
            return true;
        }
        if (data < root.data) {
            return searchRec(root.left, data);
        }
        return searchRec(root.right, data);
    }

    public void delete(int key) {
        root = deleteRec(root, key);
    }

    public Node deleteRec(Node root, int key) {
        if (root == null) {
            return root;
        }

        if (key < root.data) {
            root.left = deleteRec(root.left, key);
        } else if (key > root.data) {
            root.right = deleteRec(root.right, key);
        } else {
            // Node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // Node with two children: Get the inorder successor (smallest in the right subtree)
            root.data = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.data);
        }

        return root;
    }

    public int minValue(Node root) {
        int min = root.data;
        while (root.left != null) {
            min = root.left.data;
            root = root.left;
        }
        return min;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        BinaryTree obj = new BinaryTree();
        int choice;

        do {
            System.out.println("\n--- Binary Tree Menu ---");
            System.out.println("1. Insert");
            System.out.println("2. Search");
            System.out.println("3. Delete");
            System.out.println("4. Inorder Traversal");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = s.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the element to insert: ");
                    int data = s.nextInt();
                    obj.insert(data);
                    break;

                case 2:
                    System.out.print("Enter the element to search: ");
                    int searchItem = s.nextInt();
                    if (obj.search(searchItem)) {
                        System.out.println("Element " + searchItem + " found in the binary tree.");
                    } else {
                        System.out.println("Element " + searchItem + " not found in the binary tree.");
                    }
                    break;

                case 3:
                    System.out.print("Enter the element to delete: ");
                    int deleteItem = s.nextInt();
                    obj.delete(deleteItem);
                    System.out.println("Deleted " + deleteItem + " if it existed.");
                    break;

                case 4:
                    System.out.println("Inorder traversal of binary tree:");
                    obj.inorder();
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        s.close();
}
}
