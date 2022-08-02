import java.util.Arrays;
import java.util.Scanner;

public class RemoveElementFromArray {
    public static int[] removeTheElement(int[] arr, int value) {
        if (arr == null) {
            return arr;
        }
        int check = 0;
        for (int j=0; j<arr.length;j++){
            if(arr[j]==value){
                check++;
            }
        }
        if(check==0){
            return arr;
        }
        int[] anotherArray = new int[arr.length - 1];
        for (int i = 0, k = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                continue;
            }
            anotherArray[k++] = arr[i];
        }
        return anotherArray;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = { 1, 44, 32, 27, 5 };
        System.out.println("Original Array: "  + Arrays.toString(arr));
        System.out.println("\nEnter the value of the element you want to delete");
        int value = sc.nextInt();
        System.out.println("\nValue to be removed: " + value);
        arr = removeTheElement(arr, value);
        System.out.println("\nResultant Array: " + Arrays.toString(arr));
    }
}