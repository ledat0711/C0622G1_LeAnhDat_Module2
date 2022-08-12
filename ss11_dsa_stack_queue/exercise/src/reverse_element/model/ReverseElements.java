package reverse_element.model;

import java.util.Arrays;
import java.util.Stack;

public class ReverseElements {
    public static void reserveElements(){
        int[] arr = {0, 1, 2, 3, 4, 5, 6};
        System.out.println("Before: " + Arrays.toString(arr));
        Stack<Integer> stack1 = new Stack<>();
        int i;
        for (i = arr.length - 1; i >= 0; i--) {
            stack1.push(arr[i]);
        }
        System.out.println("After: " + stack1);
        Stack<Character> wStack = new Stack<>();
        String string1 = "abcdef";
        char[] arrChar = string1.toCharArray();
        System.out.println("-----------------------");
        System.out.print("Before: ");
        System.out.println(arrChar);
        int k;
        for (k = arrChar.length - 1; k >= 0; k--) {
            wStack.push(arrChar[k]);
        }
        int j;
        for (j = arrChar.length - 1; j >= 0; j--) {
            arrChar[j] = wStack.pop();
        }
        System.out.print("After: ");
        System.out.println(arrChar);
    }
}
