package decimal_to_binary.service;

import java.util.Stack;

public class DecimalToBinary {
    public static void changeDecimalToBinary( int numberDecimal) {
        Stack<Integer> stackBinary = new Stack<>();
        while (numberDecimal != 0) {
            stackBinary.push(numberDecimal % 2);
            numberDecimal /= 2;
        }
        while (!stackBinary.isEmpty()){
            System.out.print(stackBinary.pop());
        }
    }
}
