import java.util.*;

class Inheritance{

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        while (true) {
  System.out.println("\n....INHERITANCE TYPES....\n1.Single inheritance\n2.Multiple inheritance\n3.Multilevel inheritance\n4.Hierarchical inheritance\n5.Hybrid inheritance\n6.Exit\nEnter your choice");
            int a = sc.nextInt();
            switch (a) {
                case 1:
                    System.out.println("---Single inheritance started---");
                    Single s = new Single();
                    s.Single();
                    s.Single1();
                    System.out.println("---Single inheritance Ended---");
                    break;
                case 2:
                    System.out.println("---Multiple inheritance started---");
                    System.out.println("Multiple inheritance cannot be supported by Java\n so, please try other options");
                    System.out.println("---Multiple inheritance ended---");
                    break;
                case 3:
                    System.out.println("---Multilevel inheritance started---");
                    Multi1 m = new Multi1();
                    m.Multi();
                    m.Multi1();
                    m.Multi2();
                    System.out.println("--- Multilevel inheritance Ended---");
                    break;
                case 4:
                    System.out.println("---Hierarchical Inheritance start---");
                    Hierarch h = new Hierarch();
                    h.hierarchial();
                   
                    Hierarch h1 = new Hierarch();
                    h1.hierarchial2();
                    System.out.println("---Hierarchical Inheritance ended---");
                    break;
                case 5:
                    System.out.println("---Hybrid inheritance started---");
                    Hybri h2 = new Hybri();
                    h2.hybri();
                    h2.hybri1();
                    Hybri1 h3 = new Hybri1();
                    h3.hybri1();
                    Hybri2 h4 = new Hybri2();
                    h4.hybri3();
                    System.out.println("--- Hybrid inheritance Ended---");
                    break;
                case 6:
                    System.out.println("Exited from Inheritance");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter correct choice");
            }
        }
    }
}

// Single Inheritance
class Sing {
    public void Single() {
        System.out.println("It is also a single Inheritance of class Sing");
    }
}

class Single extends Sing {

    public void Single1() {
        System.out.println("It is also a single Inheritance of class Single1");
    }
}

// Multilevel Inheritance
class Mul {
    public void Multi() {
        System.out.println("It is also a Multilevel Inheritance of class Mul");
    }
}

class Mult extends Mul {
    public void Multi1() {
        System.out.println("This is also a Multilevel Inheritance of class Mult");
    }
}

class Multi1 extends Mult {
    public void Multi2() {
        System.out.println("This is also a Multilevel Inheritance of class Multi1");
    }
}

// Hierarchical Inheritance
class Hierar {
    public void hierarchial() {
        System.out.println("It is a hierarchical Inheritance of class Hierar");
    }
}

class Hierar1 extends Hierar {
    public void hierarchial1() {
        System.out.println("This is also a hierarchical Inheritance of class Hierar1");
    }
}

class Hierarch extends Hierar {
    public void hierarchial2() {
        System.out.println("This is also a hierarchical Inheritance of class Hierarch");
    }
}

// Hybrid Inheritance
class Hyb {
    public void hybri() {
        System.out.println("It is a hybrid Inheritance of class Hyb");
    }
}

class Hybri extends Hyb {
    public void hybri1() {
        System.out.println("This is also a Hybrid Inheritance of class Hybri");
    }
}

class Hybri1 extends Hybri {
    public void hybri2() {
        System.out.println("This is also a Hybrid Inheritance of class Hybri1");
    }
}

class Hybri2 extends Hybri {
    public void hybri3() {
        System.out.println("This is also a Hybrid Inheritance of class Hybri2");
    }
}