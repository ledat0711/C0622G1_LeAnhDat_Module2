package product_management.service.impl;

import product_management.model.Product;
import product_management.service.IProductManager;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

import static product_management.controller.ProductController.numericalOrder;

public class ProductManager implements IProductManager{
    private static Scanner scanner = new Scanner(System.in);
    private static List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(38, "Machine FX", 5));
        products.add(new Product(3478, "Machine PI", 4));
        products.add(new Product(7764, "Machine Alpha", 7));
        products.add(new Product(2271, "Machine GO", 2));
        products.add(new Product(5501, "Machine A", 9));
        products.add(new Product(228, "Machine B", 6));
    }

    @Override
    public void addProduct() {
        Product product = this.addInfoProduct();
        products.add(product);
        System.out.println("Thêm mới sản phẩm thành công.");
    }

    @Override
    public void displayAllProduct() {
        numericalOrder = 0;
        for (Product product : products) {
            System.out.println(product);
        }
    }

    @Override
    public void removeProduct() {
        System.out.print("Mời bạn nhập vào ID cần xóa: ");
        Product product = this.findIDSimple();
        if (product == null) {
            System.out.println("Không tìm thấy đối tượng cần xóa");
        } else {
            System.out.println("Bạn có chắc muốn xóa đối tượng có ID là " + product.getID() + " không?");
            System.out.println("1. Có");
            System.out.println("2. Không");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                products.remove(product);
                System.out.println("Xóa thành công!");
            }
        }
    }

    @Override
    public void updateProductByID() {
        System.out.println("Mời bạn nhập ID cần cập nhật ");
        Product productFinded = this.findIDSimple();
        if (productFinded == null) {
            System.out.println("Không tìm thấy đối tượng cần cập nhật");
        } else {
            int i;
            for (i = 0; i < products.size(); i++) {
                if (productFinded.equals(products.get(i))) {
                    products.remove(products.get(i));
                    products.add(i, this.addInfoProduct());
                    System.out.println("Đã cập nhập.");
                    break;
                }
            }
        }
    }

    @Override
    public void findProductByName() {
        System.out.print("Mời bạn nhập vào tên sản phẩm cần tìm: ");
        Product product = this.findNameSimple();
        if (product == null) {
            System.out.println("Không tìm thấy sản phẩm với tên cần tìm");
        } else {
            System.out.println("Sản phẩm của bạn cần tìm: ");
            System.out.println(product.toString2());
        }
    }

    @Override
    public void sortByPriceAscending() {
        products.sort(new Product());
        this.displayAllProduct();
    }

    @Override
    public void sortByPriceDescending() {
        products.sort(new Product());
        numericalOrder = 0;
        int i;
        for (i = products.size() - 1; i >= 0; i--) {
            System.out.println(products.get(i));
        }
    }

    public Product findIDSimple() {
        int iD = Integer.parseInt(scanner.nextLine());
        int i;
        for (i = 0; i < products.size(); i++) {
            if (products.get(i).getID() == iD) {
                return products.get(i);
            }
        }
        return null;
    }

    public Product findNameSimple() {
        String name = scanner.nextLine();
        int i;
        for (i = 0; i < products.size(); i++) {
            if (products.get(i).getName().equals(name)) {
                return products.get(i);
            }
        }
        return null;
    }

    public int inputPositiveID() {
        int iD;
        boolean isInvalidID;
        do {
            isInvalidID = true;
            iD = Integer.parseInt(scanner.nextLine());
            for (Product product : products) {
                if (iD == product.getID()) {
                    isInvalidID = false;
                    System.out.println("Bạn đã nhập trùng ID, xin hãy nhập lại.");
                    break;
                }
            }
        } while (!isInvalidID);
        return iD;
    }

    public Product addInfoProduct() {
        System.out.println("Mời bạn nhập ID sản phẩm (ID là một dãy số): ");
        int iD = this.inputPositiveID();
        System.out.println("Mời bạn nhập tên sản phẩm: ");
        String name = scanner.nextLine();
        System.out.println("Mời bạn nhập giá của sản phẩm (đơn vị: triệu VND): ");
        int price = Integer.parseInt(scanner.nextLine());
        return new Product(iD, name, price);
    }
}