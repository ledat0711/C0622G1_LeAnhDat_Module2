public class test {
    //top right
    public static void main(String[] args) {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if ((i == 0 && (j == 5)) ||
                        (i == 1 && (j == 4 || j == 5)) ||
                        (i == 2 && (j == 3 || j == 4 || j == 5)) ||
                        (i == 3 && (j == 2 || j == 3 || j == 4 || j == 5)) ||
                        (i == 4 && (j == 1 || j == 2 || j == 3 || j == 4 || j == 5)) ||
                        (i == 5)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
