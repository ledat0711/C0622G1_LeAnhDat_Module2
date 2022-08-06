package candidate_package;

import java.util.Scanner;

public class TestCandidate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào số thí sinh: ");
        int candidatesNumber = Integer.parseInt(scanner.nextLine());

        Candidate candidate = new Candidate();
        Candidate score15 = new Candidate(" ", " ", 15);
        int i;
        String list = "";
        for (i = 0; i < candidatesNumber; i++) {
            System.out.println("Nhập thông tin thí sinh thứ " + (i + 1));
            System.out.print("Mã số học sinh: ");
            candidate.setStudentID(scanner.nextLine());
            System.out.print("Tên: ");
            candidate.setName(scanner.nextLine());
            System.out.print("Điểm Toán: ");
            candidate.setMathScore(Integer.parseInt(scanner.nextLine()));
            if (candidate.getMathScore() > score15.getMathScore()) {
                list += "\nMã số thí sinh: " + candidate.getStudentID() +
                        ". Tên thí sinh: " + candidate.getName() +
                        ". Điểm: " + candidate.getMathScore();
            }
        }
        System.out.println("\nNhững thí sinh có số điểm hơn 15: ");
        System.out.println(list);
    }
}
