import java.util.Scanner;

public class ShowPolygons {
    public static void rectangle(){
        int i;
        int j;
        for (i=0; i<3; i++){
            for( j=0; j<10; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void squareTriangle () {
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void isoscelesTriangle () {
        for (int i=7; i>=1; i--){
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
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
                "4.Exit");
        int option;
        do {
            System.out.println("Choose the option: ");
            option = sc.nextInt();
        }while(option<1 || option>4 );
        switch (option) {
            case 1:
                rectangle();
                break;
            case 2:
                squareTriangle();
                break;
            case 3:
                isoscelesTriangle();
                break;
            case 4:
                System.out.println("Program has been stopped.");
        }
    }
}
