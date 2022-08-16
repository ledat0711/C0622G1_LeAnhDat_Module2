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