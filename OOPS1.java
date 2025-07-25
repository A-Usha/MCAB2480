import java.util.Scanner;

class OOPS1{
    public static void main(String[] args) {
        menu();
    }

    static void menu() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Abstraction");
            System.out.println("2. Encapsulation");
            System.out.println("3. Polymorphism");
            System.out.println("4. Inheritance");
            System.out.println("5. Exit the program");
            System.out.print("Choose the choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    B b = new B();
                    b.m1();
                    b.m2();
                    b.m3();
                    break;
                case 2:
                    Scanner sc1 = new Scanner(System.in);
                    Factorial ft = new Factorial();
                    System.out.print("Enter the number: ");
                    int n = sc1.nextInt();
                    ft.setNum(n);
                    System.out.println(ft.getNum() + "! = " + ft.fact());
                    break;
                case 3:
                    Scanner s = new Scanner(System.in);
                    Add a = new Add();
                    System.out.print("Enter first number: ");
                    int x = s.nextInt();
                    System.out.print("Enter second number: ");
                    int y = s.nextInt();
                    a.sum(x, y);
                    System.out.print("Enter first number: ");
                    int k = s.nextInt();
                    System.out.print("Enter second number: ");
                    int l = s.nextInt();
                    System.out.print("Enter third number: ");
                    int m = s.nextInt();
                    a.sum(k, l, m);
                    break;
                case 4:
                    D d = new D();
                    d.m2();
                    break;
                case 5:
                    System.out.println("Exiting the program.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please choose a valid choice.");
                    break;
            }
        }
    }
}

abstract class A {
    abstract void m1();

    public void m2() {
        System.out.println("m2() defined in class A");
    }

    public void m3() {
        System.out.println("m3() defined in class A");
    }
}

class B extends A {
    @Override
    public void m1() {
        System.out.println("Abstract method m1() defined in class B");
    }

    @Override
    public void m2() {
        System.out.println("Overridden method m2() in class B");
    }
}

class Factorial {
    private int num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int fact() {
        int fact = 1;
        for (int i = 1; i <= num; i++) {
            fact = fact * i;
        }
        return fact;
    }
}

class Add {
    public void sum(int a, int b) {
        int c = a + b;
        System.out.println("Sum of " + a + " and " + b + " is: " + c);
    }

    public void sum(int a, int b, int c) {
        int sum = a + b + c;
        System.out.println("Sum of " + a + ", " + b + ", and " + c + " is: " + sum);
    }
}

class C {
    public void m1() {
        System.out.println("m1() defined in class C");
    }
}

class D extends C {
    public void m2() {
        m1();
        System.out.println("m2() defined in class D");
    }
}

        
       
