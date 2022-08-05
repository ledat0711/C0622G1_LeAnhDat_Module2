package test_package;
//static không thể gọi non-static
public class TestClass {
    String ten;
    private int tuoi;
    boolean gioiTinh;
    static int soKhacStatic=18;
    private int soKhacNonStaticPrivate = 67;

    public TestClass() {
    }

    public TestClass(String ten, int tuoi, boolean gioiTinh) {
        this.ten = ten; // cụm this.ten của lớp ThuNghiemClass khai báo ở trên
        this.tuoi = tuoi;
        this.gioiTinh = gioiTinh;
    }
    public void setTuoi(int tuoi){
        this.tuoi=tuoi;
    }
    public static int getTuoi() {
        return soKhacStatic;
    }
}