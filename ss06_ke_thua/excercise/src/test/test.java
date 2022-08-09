package test;

class Cat extends Animal{
    public Cat() {
    }
    public Cat(String name, String color) {
        super(name, color);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}

class Animal {
    String name;
    String color;

    public Animal(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public Animal() {
    }
}

public class test {
    public static void main(String[] args) {
        Cat cat = new Cat("mèo moon", "trắng");
        Animal cat2 = new Cat("mèo moon", "trắng");
        Animal cat3 = new Cat();
        System.out.println(cat);
        System.out.println(cat3);
        System.out.println(cat==cat3);
        System.out.println(cat.equals(cat3));
    }
}