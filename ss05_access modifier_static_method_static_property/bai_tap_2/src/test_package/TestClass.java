package test_package;

public class TestClass {
    String ten;
    private int tuoi;
    boolean gioiTinh;

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
    public int getTuoi() {
        return tuoi;
    }
}