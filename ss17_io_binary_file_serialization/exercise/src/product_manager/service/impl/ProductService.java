package product_manager.service.impl;

import product_manager.model.Product;
import product_manager.service.IProductService;
import product_manager.utils.input_output.OutputStream;
import product_manager.utils.input_output.InputStream;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductService implements IProductService {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Product> products = new ArrayList<>();
    private static final String DESTINATION_FILE = "src\\product_manager\\data\\destination.txt";
    static {
        products.add(new Product("A12", "Product FX", "Apple", 200000));
        products.add(new Product("BA1", "Product ALP", "Yamaha", 800000));
        products.add(new Product("LH1", "Machine NY", "Factor A", 30000));
    }

    @Override
    public void add() {
        Product product = this.addInfoProduct();
        products.add(product);
        OutputStream.writeToFile(DESTINATION_FILE, products);
        System.out.println("Thêm mới học sinh thành công");
    }
    public Product addInfoProduct() {
        System.out.print("Mời bạn nhập ID: ");
        String iD = scanner.nextLine();
        System.out.print("Mời bạn nhập tên sản phẩm: ");
        String name = scanner.nextLine();
        System.out.print("Mời bạn nhập tên nhà sản xuất: ");
        String manufacturer = scanner.nextLine();
        System.out.print("Mời bạn nhập giá: ");
        long price = Integer.parseInt(scanner.nextLine());
        return new Product(iD, name, manufacturer,price);
    }

    @Override
    public void display() {
        OutputStream.writeToFile(DESTINATION_FILE, products);
        for (Product student : products) {
            System.out.println(student);
        }
    }

    @Override
    public void find() {
        System.out.println("Mời bạn nhập ID cần tìm: ");
        Product product = CheckAndEnter.enterIDToFindUpdateRemove(products);
        if (product == null) {
            System.out.println("Không tìm thấy học viên với ID cần tìm");
        } else {
            System.out.println("Thông tin học viên mà bạn cần tìm: ");
            System.out.println(product);
        }
    }

    @Override
    public void remove() {
        System.out.print("Mời bạn nhập vào ID cần xóa: ");
        Product student = CheckAndEnter.enterIDToFindUpdateRemove(products);
        if (student == null) {
            System.out.println("Không tìm thấy đối tượng cần xóa");
        } else {
            System.out.println("Bạn có chắc muốn xóa đối tượng có ID là " + student.getID() + " không?");
            System.out.println("1. Có");
            System.out.println("2. Không");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                products.remove(student);
                System.out.println("Xóa thành công!");
                OutputStream.writeToFile(DESTINATION_FILE, products);
            } else {
                System.out.println("Bạn chưa thực hiện xóa thông tin.");
            }
        }
    }
}