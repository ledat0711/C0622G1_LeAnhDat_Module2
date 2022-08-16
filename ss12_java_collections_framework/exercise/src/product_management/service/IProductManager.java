package product_management.service;

public interface IProductManager {
    void addProduct();

    void displayAllProduct();

    void removeProduct();

    void updateProductByID();

    void findProductByName();

    void sortByPriceAscending();

    void sortByPriceDescending();
}