import java.util.Scanner;

public class ChangeMoney {
    public static void main(String[] args) {
        double exchangeRate = 23000;
        double usdInput;
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the amount in USD: ");
        usdInput = sc.nextDouble();
        double vndOutput = usdInput * exchangeRate;
        System.out.println("Value of VND: " + vndOutput);
    }
}