package test_package;

public class TestMain {
    public static void main(String[] args) {
        TestClass object = new TestClass();
        System.out.println(object.getNumberCheckStatic()); //object không truy cập được phương thức có static
        System.out.println(object.khongStaticKhongPrivate);
    }
}