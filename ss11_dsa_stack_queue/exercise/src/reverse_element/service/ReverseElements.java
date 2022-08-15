package reverse_element.service;

import java.util.Arrays;
import java.util.Stack;

public class ReverseElements {
    public static void reserveElements() {
        int[] arr = {0, 1, 2, 3, 4, 5, 6};
        System.out.println("Before: " + Arrays.toString(arr));
        Stack<Integer> stack1 = new Stack<>();
        int i;
        for (i = 0; i < arr.length; i++) {
            stack1.push(arr[i]);
        }
        int j = 0;
        while (!stack1.isEmpty()) {
            arr[j] = stack1.pop();
            j++;
        }
        System.out.print("After: ");
        System.out.println(Arrays.toString(arr));
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
        int p;
        for (p = arrChar.length - 1; p >= 0; p--) {
            arrChar[p] = wStack.pop();
        }
        System.out.print("After: ");
        System.out.println(arrChar);
    }
}
