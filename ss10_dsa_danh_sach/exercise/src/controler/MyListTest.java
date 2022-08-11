package controler;

import model.MyList;


public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> integerMyList = new MyList<>();
        integerMyList.add(0);
        integerMyList.add(1);
        integerMyList.add(2);
        integerMyList.add(3);
        System.out.println(integerMyList);
        System.out.printf("Phần tử có chỉ số 2: %d\n", integerMyList.get(2));
        System.out.printf("Phần tử có chỉ số 3: %d\n", integerMyList.get(3));
        integerMyList.add(1, 20);
        System.out.println(integerMyList);
        System.out.printf("Phần tử có chỉ số 2: %d\n", integerMyList.get(2));
        System.out.printf("Phần tử có chỉ số 3: %d\n", integerMyList.get(3));
        System.out.println("Phần tử bị xóa: " + integerMyList.remove(1));
        System.out.println("Mảng sau khi bị xóa 1 phần tử:" + integerMyList);
        integerMyList.clear();
        System.out.println();
        System.out.println(integerMyList);
    }
}
