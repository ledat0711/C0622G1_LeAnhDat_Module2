import java.util.Scanner;

public class SmallestValueInArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào số hàng: ");
        int rowOrigin = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập vào số cột: ");
        int columnOrigin = Integer.parseInt(sc.nextLine());
        float[][] arr2DInside = new float[rowOrigin][columnOrigin];
        System.out.println("Nhập các phần tử cho mảng 2 chiều arr2D:");
        for (int i = 0; i < arr2DInside.length; i++) {
            for (int j = 0; j < arr2DInside[i].length; j++) {
                System.out.printf("Nhập phần tử arr2D[%d][%d]= ", i, j);
                arr2DInside[i][j] = Float.parseFloat(sc.nextLine());
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
        int row = 0;
        int column = 0;
        int rowMin = 0;
        int columnMin = 0 ;
        float min = arr2DInside[row][column];
        for (row = 0; row < arr2DInside.length; row++) {
            for (column = 0; column < arr2DInside[row].length; column++) {
                if (min > arr2DInside[row][column]) {
                    min = arr2DInside[row][column];
                    rowMin=row;
                    columnMin=column;
                }
            }
        }
        System.out.printf("\nMảng có giá trị nhỏ nhất: min = %f . \nTại vị trí arr2D[%d][%d].\n", min, rowMin, columnMin);
    }
}