import java.util.Scanner;

public class ShowPolygons {
    public static void rectangle() {
        int i;
        int j;
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 10; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void squareTriangleTopLeft() {
        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void squareTriangleBottomLeft() {
        int i;
        int j;
        for (i = 7; i >= 1; i--) {
            for (j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void squareTriangleTopRight (){
        int i;
        int j;
        for (i = 0; i < 6; i++) {
            for (j = 0; j < 6; j++) {
                if ((i == 0 && (j == 0 || j == 1 || j == 2 || j == 3 || j == 4 || j == 5)) ||
                        (i == 1 && (j == 1 || j == 2 || j == 3 || j == 4 || j == 5)) ||
                        (i==2&&(j == 2 || j == 3 || j == 4 || j == 5))||
                        (i==3&&(j == 3 || j == 4 || j == 5))||
                        (i==4&&(j == 4 || j == 5))||
                        (i==5&&(j==5))) {
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void squareTriangleBottomRight() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if ((i == 0 && (j == 5)) ||
                        (i == 1 && (j == 4 || j == 5)) ||
                        (i == 2 && (j == 3 || j == 4 || j == 5)) ||
                        (i == 3 && (j == 2 || j == 3 || j == 4 || j == 5)) ||
                        (i == 4 && (j == 1 || j == 2 || j == 3 || j == 4 || j == 5)) ||
                        i == 5) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println();

    }

    public static void isoscelesTriangle() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 7; j++) {
                if ((i == 0 && (j == 0 || j == 1 || j == 2 || j == 4 || j == 5 || j == 6)) ||
                        (i == 1 && (j == 0 || j == 1 || j == 5 || j == 6)) ||
                        (i == 2 && (j == 0 || j == 6))) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Menu:\n" +
                "1.Print the rectangle\n" +
                "\n" +
                "2.Print the square triangle\n" +
                "(The corner is square at 4 different angles: top-left, top-right, bottom-left, bottom-right)\n" +
                "\n" +
                "3.Print isosceles triangle\n" +
                "\n" +
                "4.Exit\n");
        int option;
        do {
            System.out.println("Choose the option: ");
            option = sc.nextInt();
        } while (option < 1 || option > 4);
        switch (option) {
            case 1:
                rectangle();
                break;
            case 2:
                squareTriangleBottomLeft();
                squareTriangleTopLeft();
                squareTriangleTopRight();
                squareTriangleBottomRight();
                break;
            case 3:
                isoscelesTriangle();
                break;
            case 4:
                System.out.println("Program has been stopped.");
        }
    }
}
