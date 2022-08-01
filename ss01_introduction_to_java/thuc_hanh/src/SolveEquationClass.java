import java.util.Scanner;

public class SolveEquationClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Solve the first degree equation: ax + b = 0");
        System.out.println("Enter the number a: ");
        float a = sc.nextFloat();
        System.out.println("Enter the number b: ");
        float b = sc.nextFloat();
        if (a!=0){
            if(b==0){
                System.out.println("The equation has a solution: x = 0.");
            }else {
                System.out.println("The equation has a solution: x= " + (-b) / a);
            }
        }else{
            if(b==0){
                System.out.println("The equation has infinitely many solutions.");
            }else{
                System.out.println("The equation has no solution.");
            }
        }
    }
}
