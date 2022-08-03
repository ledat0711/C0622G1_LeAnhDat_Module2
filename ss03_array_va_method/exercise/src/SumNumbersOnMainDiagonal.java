import java.util.Scanner;
public class SumNumbersOnMainDiagonal {
    public static void sum(float[][] arr2D) {
        Scanner sc = new Scanner(System.in);
        float sum = 0;
        for (int i = 0; i < arr2D.length; i++) {
            for (int j = 0; j < arr2D[i].length; j++) {
                if (i==j) {
                    sum += arr2D[i][j];
                }
            }
        }
        System.out.printf("\nTổng các phần tử đường chéo chính: %f ", sum);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào số hàng và cột của ma trận vuông: ");
        int indexRowColumn = Integer.parseInt(sc.nextLine());
        float[][] arr2DInside = new float[indexRowColumn][indexRowColumn];
        System.out.println("Nhập các phần tử cho mảng 2 chiều arr2D:");
        for (int i = 0; i < arr2DInside.length; i++) {
            for (int j = 0; j < arr2DInside[i].length; j++) {
                System.out.printf("Nhập phần tử arr2D[%d][%d]= ", i, j);
                arr2DInside[i][j] = sc.nextFloat();
            }
        }
        System.out.println("\nMảng vừa nhập: ");
        for (int m = 0; m < arr2DInside.length; m++) {
            for (int n = 0; n < arr2DInside[m].length; n++) {
                if (arr2DInside[m][n] == arr2DInside[m][arr2DInside[m].length - 1]) {
                    System.out.print(arr2DInside[m][n]);
                } else {
                    System.out.print(arr2DInside[m][n] + " ; ");
                }
            }
            System.out.println();
        }
        sum(arr2DInside);
    }
}
