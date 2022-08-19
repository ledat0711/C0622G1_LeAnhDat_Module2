/*
Mục tiêu:
Luyện tập sử dụng try-catch để xử lý ngoại lệ.
Mô tả:
Viết một ứng dụng nhập vào 3 cạnh của hình tam giác.
Kiểm tra nếu giá trị nhập vào là số âm hoặc tổng 2 cạnh không lớn hơn cạnh còn lại thì sinh ngoại lệ.
Sử dụng IllegalTriangleException để sinh lỗi khi kiểm tra tam giác.
*/

package illegal_triangle_exception;

import java.util.Scanner;

public class MainView {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        int firstEdge;
        int secondEdge;
        int thirdEdge;
        do{
            i++;
            firstEdge = Integer.parseInt(scanner.nextLine());
            secondEdge = Integer.parseInt(scanner.nextLine());
            thirdEdge = Integer.parseInt(scanner.nextLine());
        }while(i<10);
    }
    public static void illegalTriangleException(int firstEdge, int secondEdge, int thirdEdge){
        try{

        }catch (NumberFormatException e){
            System.out.println("Bạn đã nhập không đúng định dạng");
        }
    }
}