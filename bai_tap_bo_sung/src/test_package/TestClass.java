package test_package;
//static không thể gọi non-static
public class TestClass {
    String ten;
    private int tuoi=19;
    boolean gioiTinh;
    static int soKhacStatic=18;
    private int soKhacNonStaticPrivate = 67;
    static int numberCheckStatic = 789;
    public TestClass() {
    }

    public TestClass(String ten, int tuoi1, boolean gioiTinh, int numberCheckStatic) {
        this.ten = ten; // cụm this.ten của lớp ThuNghiemClass khai báo ở trên
        this.tuoi = tuoi1;
        this.gioiTinh = gioiTinh;
        TestClass.numberCheckStatic=numberCheckStatic;
    }
    public void setTuoi(int tuoi){
        this.tuoi=tuoi;
    }

    public static int getNumberCheckStatic(){
        return TestClass.numberCheckStatic;
    }

    public int getTuoi(){
        return this.tuoi;
    }
}