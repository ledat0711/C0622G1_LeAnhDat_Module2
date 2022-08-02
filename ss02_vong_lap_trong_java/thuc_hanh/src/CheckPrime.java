import java.util.Scanner;

public class CheckPrime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number;
        do {
            System.out.println("Enter a number: ");
            number = sc.nextInt();
        }while(number<=1);
        int count = 0;
        int i;
        for (i=2; i<=Math.sqrt(number); i++) {
            if(number%i==0){
                count++;
            }
        }
        if(count==0){
            System.out.println(number+" is a prime number.");
        }else{
            System.out.println(number+" a is not a prime number.");
        }
    }
}
