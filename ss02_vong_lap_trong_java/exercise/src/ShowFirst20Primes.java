public class ShowFirst20Primes {
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
        int count = 0;
        for (int i = 2; count != 20; i++) {
            if (checkPrime(i)) {
                System.out.print(i + "\t");
                count++;
            }
        }
    }
}