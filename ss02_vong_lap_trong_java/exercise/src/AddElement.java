import java.util.Arrays;
import java.util.Scanner;

public class AddElement {

    public static int[] addElement(int[] arr, int value, int indexInput) {
        int[] anotherArray = new int[arr.length + 1];
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            anotherArray[k] = arr[i];
            if (i == indexInput) {
                anotherArray[k] = value;
                for (int j = i; j < arr.length; j++) {
                    anotherArray[j + 1] = arr[j];
                }
                return anotherArray;
            }
            k++;
        }
        return anotherArray;
    }

    public static void main(String[] args) {
        int[] arr = {56, 34, 78, 3, 8};
        System.out.println("Mảng ban đầu: " + Arrays.toString(arr));
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập vị trí muốn chèn: ");
        int index = sc.nextInt();
        if( index <= -1 || index >= arr.length-1){
            System.out.println("Không chèn được phần tử vào mảng.");
        }else {
            System.out.print("Nhập giá trị của phần tử cần chèn: ");
            int value = sc.nextInt();
            arr = addElement(arr, value, index);
            System.out.println("Mảng sau khi chèn: " + Arrays.toString(arr));
        }
    }
}