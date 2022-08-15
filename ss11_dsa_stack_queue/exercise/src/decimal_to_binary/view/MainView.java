package decimal_to_binary.view;
//
//import static decimal_to_binary.service.DecimalToBinary.decimalToBinary;

import decimal_to_binary.service.DecimalToBinary;

public class MainView {
    public static void main(String[] args) {
        int numberDecimal = 26;
        DecimalToBinary.changeDecimalToBinary(numberDecimal);
    }
}