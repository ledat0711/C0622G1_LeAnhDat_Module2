package test;

public class MyClass {
    private final StringBuilder str = new StringBuilder();

    public void add(String str) {
        this.str.append(str);
    }

    public void remove(int start, int end) {
        this.str.delete(start, end);
    }

    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        myClass.add("a");
        myClass.remove(1,3);
        System.out.println(myClass.str);
    }
}
