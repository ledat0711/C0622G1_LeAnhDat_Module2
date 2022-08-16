/*Mục tiêu
Luyện tập sử dụng ArrayList, LinkedList trong Java Collection Framework
Mô tả:
Xây dựng chương trình quản lý sản phẩm gồm các thao tác:
Thêm sản phẩm
Sửa thông tin sản phẩm theo id
Xoá sản phẩm theo id
Hiển thị danh sách sản phẩm
Tìm kiếm sản phẩm theo tên
Sắp xếp sản phẩm tăng dần, giảm dần theo giá
Chương trình sử dụng ArrayList để lưu danh sách sản phẩm.
Hướng dẫn
Bước 1: Xây dựng lớp Product
Bước 2: Xây dựng lớp ProductManager gồm các phương thức thêm, sửa, xoá, hiển thị, tìm kiếm, sắp xếp.
Trong lớp ProductManager khai báo ArrayList để lưu danh sách sản phẩm.
Bước 3: Chạy chương trình và test từng chức năng
Bước 4: Làm lại bài tập, thay thế ArrayList bằng LinkedList.
Practice using ArrayList, LinkedList in Java Collection Framework*/
package product_management.controller;

import product_management.service.IProductManager;
import product_management.service.impl.ProductManager;

import java.util.Scanner;


public class ProductController {
    public static int numericalOrder=0;
    private static Scanner scanner = new Scanner(System.in);
    private static IProductManager productManager = new ProductManager();
    public static void productManagementMenu() {
        int i = 0;
        while (i < 10) {
            System.out.println("-------------------------------------------");
            System.out.println("Quản lý danh sách sản phẩm.");
            System.out.println("1. Thêm mới sản phẩm.");
            System.out.println("2. Cập nhật sản phẩm.");
            System.out.println("3. Xóa sản phẩm.");
            System.out.println("4. Tìm kiếm sản phẩm.");
            System.out.println("5. Hiển thị theo giá tăng dần.");
            System.out.println("6. Hiển thị theo giá giảm dần.");
            System.out.print("Mời bạn nhập chức năng: ");
            i++;
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    productManager.addProduct();
                    break;
                case 2:
                    productManager.updateProduct();
                    break;
                case 3:
                    productManager.displayAllProduct();
                    productManager.removeProduct();
                    break;
                case 4:
                    productManager.findProductByName();
                    break;
                case 5:
                   productManager.sortByPriceAscending();
                    break;
                case 6:
                   productManager.sortByPriceDescending();
                    break;
                default:
                    System.out.println("Lựa chọn bạn nhập không đúng!");
            }
        }
    }
}