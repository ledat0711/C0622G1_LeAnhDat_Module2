/*Thêm sản phẩm
Sửa thông tin sản phẩm theo id
Xoá sản phẩm theo id
Hiển thị danh sách sản phẩm
Tìm kiếm sản phẩm theo tên
Sắp xếp sản phẩm tăng dần, giảm dần theo giá
Chương trình sử dụng ArrayList để lưu danh sách sản phẩm.*/
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