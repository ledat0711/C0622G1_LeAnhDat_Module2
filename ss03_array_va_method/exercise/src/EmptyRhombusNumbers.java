import java.util.Scanner;

public class EmptyRhombusNumbers {
    public static void main(String[] args) {
        int i;
        int j;
        int[] arr = {1, 2, 3, 4, 5, 4, 3, 2, 1};
        for (i = 0; i < arr.length; i++) {
            for (j = 0; j < 10; j++) {
                if (((i == 0 && (j == 4 || j == 5)) ||
                        (i == 1 && (j == 3 || j == 6)) ||
                        (i == 2 && (j == 2 || j == 7)) ||
                        (i == 3 && (j == 1 || j == 8)) ||
                        (i == 4 && (j == 0 || j == 9)) ||
                        (i == 8 && (j == 4 || j == 5)) ||
                        (i == 7 && (j == 3 || j == 6)) ||
                        (i == 6 && (j == 2 || j == 7)) ||
                        (i == 5 && (j == 1 || j == 8)))) {
                    System.out.print(arr[i]);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}