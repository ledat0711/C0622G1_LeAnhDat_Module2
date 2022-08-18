import java.util.Arrays;
import java.util.Scanner;

public class InsertionSortDescending {
    public static void insertionSortAscending(int[] array) {
        int pos;
        int key;
        for (int i = 1; i < array.length; i++) {
            key = array[i];
            for (pos = i; pos > 0 && key > array[pos - 1]; pos--) {
                array[pos] = array[pos - 1];
            }
            array[pos] = key;
        }
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        Scanner scanner2 = new Scanner(System.in);
        System.out.print("Nhập số lượng phần tử trong mảng: ");
        int lengthOfArray = Integer.parseInt(scanner2.nextLine());
        int[] array = new int[lengthOfArray];
        int i;
        for (i = 0; i < array.length; i++) {
            System.out.printf("Nhập phần tử array[%s]= ", i);
            array[i] = Integer.parseInt(scanner2.nextLine());
        }
        System.out.print("Mảng sau khi sắp xếp giảm dần: ");
        insertionSortAscending(array);
    }
}
