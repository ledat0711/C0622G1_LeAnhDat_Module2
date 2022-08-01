import java.util.Scanner;

public class ReadNumbersIntoLetters {
    public static void arrayNumber(int index) {
        String[] array = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        System.out.print(array[index]);
    }

    public static void oneNumber(int number) {
            if (number == 0) {
                System.out.println("Zero");
            } else {
                arrayNumber(number);
            }
    }

    public static void twoNumbers(int number) {
        if (number >= 0 && number <= 9) {
            arrayNumber(number);
        } else if (number >= 10 && number <= 15) {
            String[] arrayInTwoNum = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen"};
            System.out.println(arrayInTwoNum[number - 10]);
        } else if (number >= 16 && number <= 19) {
            int numberIn = number % 10;
            arrayNumber(numberIn);
            System.out.println("teen");
        } else {
            if (number <= 29) {
                System.out.print("Twenty ");
                int rightNumberOf20 = number % 20;
                arrayNumber(rightNumberOf20);
            } else if (number <= 39) {
                System.out.print("Thirty ");
                int rightNumberOf30 = number % 30;
                arrayNumber(rightNumberOf30);
            } else if (number <= 49) {
                System.out.print("Forty ");
                int rightNumberOf40 = number % 40;
                arrayNumber(rightNumberOf40);
            } else if (number <= 59) {
                System.out.print("Fifty ");
                int rightNumberOf50 = number % 50;
                arrayNumber(rightNumberOf50);
            } else if (number <= 69) {
                System.out.print("Sixty ");
                int rightNumberOf60 = number % 60;
                arrayNumber(rightNumberOf60);
            } else if (number <= 79) {
                System.out.print("Seventy ");
                int rightNumberOf70 = number % 70;
                arrayNumber(rightNumberOf70);
            } else if (number <= 89) {
                System.out.print("Eighty ");
                int rightNumberOf80 = number % 80;
                arrayNumber(rightNumberOf80);
            } else {
                System.out.print("Ninety ");
                int rightNumberOf90 = number % 90;
                arrayNumber(rightNumberOf90);
            }
        }
    }

    public static void threeNumbers(int number) {
        int hundredNumber = number / 100;
        if (number % 100 == 0) {
            arrayNumber(hundredNumber);
            System.out.print(" Hundred");
        } else {
            arrayNumber(hundredNumber);
            System.out.print(" Hundred and ");
            int tenAndUnit = number % 100;
            twoNumbers(tenAndUnit);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number you want to read: ");
        int number = sc.nextInt();
        while (number<0 || number>999){
            System.out.println("Out of ability. Please re-enter. ");
            number = sc.nextInt();
        }
        if (number <= 9) {
            oneNumber(number);
        }else if (number <= 99) {
            twoNumbers(number);
        } else {
            threeNumbers(number);
        }
    }
}
