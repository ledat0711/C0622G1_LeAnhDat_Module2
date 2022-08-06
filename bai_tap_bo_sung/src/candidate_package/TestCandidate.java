package candidate_package;

import java.util.Scanner;

public class TestCandidate {
    public static void main(String[] args) {
        Candidate candidate1 = new Candidate();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào số thí sinh:");
        int candidatesNumber = Integer.parseInt(scanner.nextLine());
        int i;
        for (i = 0; i < candidatesNumber; i++)
            if (candidate1.getSum() > 15) {
                System.out.println();
            }
    }
}
