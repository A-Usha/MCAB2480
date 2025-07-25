// Method to input a list from the user
    public void inputList(Scanner sc) {
        System.out.print("Enter number of elements to input: ");
        int n = sc.nextInt();
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            int element = sc.nextInt();
            insertLast(element);
        }
    }
