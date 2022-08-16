/*Mục tiêu
Luyện tập sử dụng ArrayList, LinkedList trong Java Collection Framework

Mô tả
Xây dựng chương trình quản lý sản phẩm gồm các thao tác:

Thêm sản phẩm
Sửa thông tin sản phẩm theo id
Xoá sản phẩm theo id
Hiển thị danh sách sản phẩm
Tìm kiếm sản phẩm theo tên
Sắp xếp sản phẩm tăng dần, giảm dần theo giá
Chương trình sử dụng ArrayList để lưu danh sách sản phẩm.

Hướng dẫn nộp bài:

Up mã nguồn lên github
Paste link github vào phần nộp bài
Hướng dẫn
Bước 1: Xây dựng lớp Product

Bước 2: Xây dựng lớp ProductManager gồm các phương thức thêm, sửa, xoá, hiển thị, tìm kiếm, sắp xếp.

Trong lớp ProductManager khai báo ArrayList để lưu danh sách sản phẩm.

Bước 3: Chạy chương trình và test từng chức năng

Bước 4: Làm lại bài tập, thay thế ArrayList bằng LinkedList.

Practice using ArrayList, LinkedList in Java Collection Framework*/
package product_management.service.impl;

import product_management.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Product> students = new ArrayList<>();

    static {
        students.add(new Product(455, "Nguyen Lam", "12/12/1998", 4, "C06"));
        students.add(new Product(56, "Tran Ngoc", "12/12/1997", 9, "C07"));
    }
}
