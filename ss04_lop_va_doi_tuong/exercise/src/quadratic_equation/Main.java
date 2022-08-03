package quadratic_equation;

import java.util.Scanner;

public class Main {

    public static void solve(double aNumber, double bNumber, double cNumber) {
        QuadraticEquationClass quadraticEquationObject = new QuadraticEquationClass(aNumber, bNumber, cNumber);
        double delta = quadraticEquationObject.getDiscriminant();
        double root1 = quadraticEquationObject.getRoot1();
        double root2 = quadraticEquationObject.getRoot2();
        if (aNumber == 0) {
            if (bNumber == 0) {
                if (cNumber == 0) {
                    System.out.println("Phương trình có vô số nghiệm.");
                } else {
                    System.out.println("Phương trình vô nghiệm.");
                }
            } else if (bNumber != 0) {
                System.out.println("Phương trình có nghiệm: " + (-cNumber / bNumber));
            }
        } else if (aNumber != 0) {
            if (delta > 0) {
                System.out.println("Phương trình có 2 nghiệm: ");
                System.out.printf("x1= %.2f", root1);
                System.out.printf("\nx2= %.2f", root2);
            } else if (delta == 0) {
                System.out.println("Phương trình có nghiệm kép: " + root1);
            } else if (delta < 0) {
                System.out.println("Phương trình vô nghiệm.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Giải phương trình bậc 2: ax^2 + bx + c = 0 ");
        System.out.print("Nhập a: ");
        double aNumber = Double.parseDouble(sc.nextLine());
        System.out.print("Nhập b: ");
        double bNumber = Double.parseDouble(sc.nextLine());
        System.out.print("Nhập c: ");
        double cNumber = Double.parseDouble(sc.nextLine());
        solve(aNumber, bNumber, cNumber);
    }
}
