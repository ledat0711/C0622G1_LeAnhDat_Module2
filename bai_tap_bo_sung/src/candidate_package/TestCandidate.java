package candidate_package;

import java.util.Scanner;

public class TestCandidate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào số thí sinh: ");
        int candidatesNumber = Integer.parseInt(scanner.nextLine());
        System.out.println();

        Candidate candidate = new Candidate();
        int i;
        StringBuilder list = new StringBuilder();
        for (i = 0; i < candidatesNumber; i++) {
            System.out.println("Nhập thông tin thí sinh thứ " + (i + 1));
            System.out.print("Mã số học sinh: ");
            candidate.setStudentID(scanner.nextLine());
            System.out.print("Tên: ");
            candidate.setName(scanner.nextLine());
            System.out.print("Điểm Toán: ");
            candidate.setMathScore(Integer.parseInt(scanner.nextLine()));
            System.out.print("Điểm Văn: ");
            candidate.setLiteratureScore(Integer.parseInt(scanner.nextLine()));
            System.out.print("Điểm Anh: ");
            candidate.setEnglishScore(Integer.parseInt(scanner.nextLine()));
            System.out.println();
            if (candidate.getSum() > 15) {
                list.append("\nMã số thí sinh: ").append(candidate.getStudentID()).
                        append(". Tên thí sinh: ").append(candidate.getName()).
                        append(". Tổng điểm: ").append(candidate.getSum());
            }
        }
        System.out.println("\nNhững thí sinh có số điểm hơn 15: ");
        System.out.println(list);
    }
}
