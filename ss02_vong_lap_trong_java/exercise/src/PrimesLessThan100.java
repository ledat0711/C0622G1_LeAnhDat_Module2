public class PrimesLessThan100 {
    public static boolean checkPrime(int numberInside) {
        int i;
        for (i = 2; i <= Math.sqrt(numberInside); i++) {
            if (numberInside % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int count = 0;
        for (int i = 2; i< 100; i++) {
            if (checkPrime(i)) {
                System.out.print(i + "\t");
            }
        }
    }
}
