public class PrimesLessThan100 {
    public static boolean checkPrime(int numberInside) {
        int j;
        for (j = 2; j <= Math.sqrt(numberInside); j++) {
            if (numberInside % j == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        for (int i = 2; i< 100; i++) {
            if (checkPrime(i)) {
                System.out.print(i + "\t");
            }
        }
    }
}
