import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
public class MergeArray {
    public static int[] mergeArray(int[]arr1, int[]arr2){
        int[] arr3 = new int[9];
        for(int i =0; i<arr1.length;i++){
            arr3[i]=arr1[i];
        }
        for(int j=0; j<arr2.length; j++){
            arr3[arr1.length+j]=arr2[j];
        }
        return arr3;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] firstArray = new int[4];
        int[] secondArray = new int[5];
        int[] thirdArray;
        System.out.println("Nhập các phần tử cho mảng thứ nhất (4 phần tử) :");
        for (int i = 0; i < firstArray.length ; i++) {
            System.out.printf("Nhập firstArray[%d]= ", i);
            firstArray[i]= sc.nextInt();
        }
        System.out.println( "firstArray= "+Arrays.toString(firstArray) +"\n\n");

        System.out.println("Nhập các phần tử cho mảng thứ hai (5 phần tử):");
        for (int i = 0; i < secondArray.length ; i++) {
            System.out.printf("Nhập secondArray[%d]= ", i);
            secondArray[i]= sc.nextInt();
        }
        System.out.println("secondArray= "+Arrays.toString(secondArray)+"\n\n");
        thirdArray = mergeArray(firstArray, secondArray);
        System.out.println("thirdArray = firstArray + secondArray = " + Arrays.toString(thirdArray));
    }
}
