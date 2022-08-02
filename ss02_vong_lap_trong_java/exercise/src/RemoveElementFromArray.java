import java.util.Arrays;
import java.util.Scanner;

public class RemoveElementFromArray {

    public static boolean check(int[] arrCheck, int valueCheck) {
        for (int j = 0; j < arrCheck.length; j++) {
            if (arrCheck[j] == valueCheck) {
                return true;
            }
        }
        return false;
    }

    public static int[] removeTheElement(int[] arr, int value) {
        int[] anotherArray = new int[arr.length - 1];
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                continue;
            }
            anotherArray[k] = arr[i];
            k++;
        }
        return anotherArray;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {1, 44, 32, 27, 5};
        System.out.println("Original Array: " + Arrays.toString(arr));
        System.out.println("\nEnter the value of the element you want to delete");
        int value = sc.nextInt();
        if (check(arr, value)) {
            System.out.println("\nValue to be removed: " + value);
            arr = removeTheElement(arr, value);
        } else {
            System.out.println("Does not have the element you entered.");
        }
        System.out.println("\nResultant Array: " + Arrays.toString(arr));
    }
}