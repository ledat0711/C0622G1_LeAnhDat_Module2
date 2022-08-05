/*Bài 1:
Xây dựng lớp Candidate (Thí sinh) gồm các thuộc tính:
 mã, tên, ngày tháng năm sinh, điểm thi Toán, Văn, Anh và các phương thức cần thiết.
Xây dựng lớp TestCandidate để kiểm tra lớp trên:
– Nhập vào n thí sinh (n do người dùng nhập)
– In ra thông tin về các thí sinh có tổng điểm lớn hơn 15
*/

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
                System.out.println(candidate.getSum());
            }
    }
}
