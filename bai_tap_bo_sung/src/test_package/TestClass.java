package test_package;

//static không thể gọi non-static
public class TestClass {
    String ten;
    private int tuoi = 19;
    boolean gioiTinh;
    static int soKhacStatic = 18;
    private final int soKhacNonStaticPrivate = 67;
    static int numberCheckStatic = 789;
    String khongStaticKhongPrivate = "khongStaticKhongPrivate";
    public static int numberPublic = 190;
    static String nameStatic;
    int numberTest9 = 999;

    static {
        nameStatic = "Chuoi";
    }

    //    nameStatic = "Chuoi"; ///ko được
    static {
        int numberLocalStatic; // bi
    }

//    static {
//        numberLocalStatic = 2;
//    }

    public TestClass() {
    }

    public TestClass(String ten, int tuoi1, boolean gioiTinh, int numberCheckStatic) {
        this.ten = ten; // cụm this.ten của lớp ThuNghiemClass khai báo ở trên
        this.tuoi = tuoi1;
        this.gioiTinh = gioiTinh;
        TestClass.numberCheckStatic = numberCheckStatic;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public int getNumberCheckStatic2() {
        return numberCheckStatic;
    }


    public int nonStaticGetStatic() {
        return nonStaticPhuongThuc();
    }

    public static int staticClass(int soKhac) {
        return soKhacStatic;
    }

    public int nonStaticPhuongThuc() {
        return 2;
    }
}