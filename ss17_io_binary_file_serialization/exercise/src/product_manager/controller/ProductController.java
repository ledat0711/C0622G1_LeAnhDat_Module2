package product_manager.controller;

import product_manager.service.IProductService;
import product_manager.service.impl.ProductService;
import product_manager.utils.exception.InvalidException;

import java.util.Scanner;

public class ProductController {
    private static Scanner scanner = new Scanner(System.in);
    private static IProductService productService = new ProductService();

    public static int inputValidChoice() {
        int choice = 0;
        int j = 0;
        while (j < 10) {
            j++;
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice > 11 || choice < 1) {
                    throw new InvalidException("\nBạn đã nhập giá trị ngoài phạm vi.");
                }
                break;
            } catch (NumberFormatException n) {
                System.out.println("\nBạn đã nhập kiểu dữ liệu không phải là số.");
            } catch (InvalidException p) {
                System.out.println(p.getMessage());
            } catch (Exception e) {
                System.out.println("\nThông tin bạn nhập đã bị lỗi");
            }
            System.out.print("Vui lòng nhập lại lựa chọn: ");
        }
        return choice;
    }

    public static void menuManagementStudent() throws Exception {
        int i = 0;
        int choice;
        while (i < 10) {
            System.out.println("-------------------------------------------");
            System.out.println("Quản lý danh sách sản phẩm.");
            System.out.println("1. Thêm thông tin sản phẩm");
            System.out.println("2. Hiển thị thông tin sản phẩm");
            System.out.println("3. Tìm kiếm thông tin sản phẩm");
            System.out.println("4. Xóa thông tin sản phẩm");
            System.out.print("Mời bạn nhập lựa chọn: ");
            i++;
            choice = inputValidChoice();
            switch (choice) {
                case 1:
                    productService.add();
                    break;
                case 2:
                    System.out.println("****Danh sách sản phẩm****");
                    productService.display();
                    break;
                case 3:
                    productService.find();
                    break;
                case 4:
                    productService.remove();
                    break;
                default:
                    System.out.println("Lựa chọn bạn nhập không đúng!");
            }
        }
    }
}
