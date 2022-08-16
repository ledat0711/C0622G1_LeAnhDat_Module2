package product_management.service;

public interface IProductManager {
    void addProduct();

    void displayAllProduct();

    void removeProduct();

    void updateProduct();

    void findProductByName();

    void sortByPriceAscending();

    void sortByPriceDescending();
}