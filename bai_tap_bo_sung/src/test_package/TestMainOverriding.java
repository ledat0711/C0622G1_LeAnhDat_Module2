package test_package;

public class TestMainOverriding {
    public static void main(String[] args) {
        c c1 = new c();
        c1.p(10);
        c1.p(10.0);
    }
}

class c extends d {
    public void p(double number) {
        System.out.println(number);
    }
}

class d {
    public void p(double number) {
        System.out.println(number * 2);
    }
}