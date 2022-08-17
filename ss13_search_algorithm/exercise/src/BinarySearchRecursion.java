import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BinarySearchRecursion {
    public static int searchBinaryByRecursion(int[] myArr, int left, int right, int valueToCheck) {
        if (right >= left) {
            int mid = (left + right) / 2;
            if (myArr[mid] == valueToCheck) {
                return mid;
            }
            if (myArr[mid] > valueToCheck) {
                return searchBinaryByRecursion(myArr, left, mid - 1, valueToCheck);
            }
            return searchBinaryByRecursion(myArr, mid + 1, right, valueToCheck);
        }
        return -1;
    }

    public static int checkValue(int[] arrInput, int i) {
        Scanner scanner = new Scanner(System.in);
        boolean isValidValue;
        int valueToFind;
        do {
            isValidValue=true;
            valueToFind = Integer.parseInt(scanner.nextLine());
            for (int element : arrInput) {
                if (valueToFind == element) {
                    System.out.printf("Bạn đã nhập trùng phần tử.\nVui lòng nhập lại phần tử array[%s]: ", i);
                    isValidValue = false;
                    break;
                }
            }
        } while (!isValidValue);
        return valueToFind;
    }

    public static void returnResult(int resultInput) {
        if (resultInput == -1) {
            System.out.println("Không tìm thấy phần tử trong mảng.");
        } else {
            System.out.println("Phần tử cần tìm có chỉ số: " + resultInput);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i;
        int[] array = new int[7];
        for (i = 0; i < array.length; i++) {
            System.out.printf("Nhập vào phần tử array[%s]: ", i);
            array[i] = checkValue(array,i);
        }
        System.out.println("Mảng sau khi sắp xếp tăng dần: ");
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        System.out.println("Nhập phần tử cần tìm: ");
        int valueToFind = Integer.parseInt(scanner.nextLine());
        int resultIndex1 = searchBinaryByRecursion(array, 0, array.length - 1, valueToFind);
        returnResult(resultIndex1);
    }
}