import java.util.Scanner;

/*Nội dung
Viết một ứng dụng cho phép người dùng nhập vào một ma trận vuông của các số thực,
sau đó tính ra cho người dùng tổng của các số ở đường chéo chính.

Ma trận vuông là một ma trận có chiều cao và chiều rộng bằng nhau.

Đường chéo chính là tập hợp các phần tử được định vị bằng tọa độ [i][i].

Hướng dẫn
Bước 1: tính tổng các phần tử của một ma trận vuông có sẵn

Dùng một mảng hai chiều để phản ánh ma trận.

Dùng phương pháp khởi tạo nhanh để tạo ra một mảng có sẵn các phần tử.
Sử dụng vòng lặp để tính tổng tất cả các phần tử có tọa độ ở hàng ngang và cột dọc bằng nhau. Thông báo cho người dùng.

Thực thi chương trình để kiểm tra kết quả, thử với một số giá trị khác nhau để xác nhận rằng chương trình chạy đúng.

Bước 2: thu thập mảng thực từ nhập liệu của người dùng và hoàn thành yêu cầu

Viết mã để thay thế mảng được tạo nhanh bằng mảng được tạo ra từ nhập liệu của người dùng.
Trước tiên hỏi để biết kích thước ma trận, sau đó sử dụng vòng lặp để lần lượt hỏi từng giá trị của mảng.*/
public class SumNumbersOnMainDiagonal {
    public static void sum(float[][] arr2D) {
        Scanner sc = new Scanner(System.in);
        float sum = 0;
        for (int i = 0; i < arr2D.length; i++) {
            for (int j = 0; j < arr2D[i].length; j++) {
                if (i==j) {
                    sum += arr2D[i][j];
                }
            }
        }
        System.out.printf("\nTổng các phần tử đường chéo chính: %f ", sum);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào số hàng và cột của ma trận vuông: ");
        int indexRowColumn = Integer.parseInt(sc.nextLine());
        float[][] arr2DInside = new float[indexRowColumn][indexRowColumn];
        System.out.println("Nhập các phần tử cho mảng 2 chiều arr2D:");
        for (int i = 0; i < arr2DInside.length; i++) {
            for (int j = 0; j < arr2DInside[i].length; j++) {
                System.out.printf("Nhập phần tử arr2D[%d][%d]= ", i, j);
                arr2DInside[i][j] = sc.nextFloat();
            }
        }
        System.out.println("\nMảng vừa nhập: ");
        for (int m = 0; m < arr2DInside.length; m++) {
            for (int n = 0; n < arr2DInside[m].length; n++) {
                if (arr2DInside[m][n] == arr2DInside[m][arr2DInside[m].length - 1]) {
                    System.out.print(arr2DInside[m][n]);
                } else {
                    System.out.print(arr2DInside[m][n] + " ; ");
                }
            }
            System.out.println();
        }
        sum(arr2DInside);
    }
}
