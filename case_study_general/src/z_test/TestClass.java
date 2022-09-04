package z_test;

import case_study.model.person.Customer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class TestClass {
    public TestClass(){
    }

    private static final List<Customer> CUSTOMER_LIST = new LinkedList<>();
    public static void main(String[] args) {
        TestClass testObject = new TestClass();
        testObject.checkStaticMethod();
    }

    public void checkNonStaticMethod(){
        System.out.println("Phương thức checkNonStatic()");

    }

    public static void checkStaticMethod(){
        System.out.println("Phương thức static checkStatic()");
    }

    static {
        CUSTOMER_LIST.add(new Customer("Vinh Nguyễn", LocalDate.parse("1994/09/26", DateTimeFormatter.ofPattern("yyyy/MM/dd")), "Nam", "201768999",
                "0978112556", "vinh12344@gmail.com", "KH44512",
                "Silver", "An Hải Đông - Sơn Trà - Đà Nẵng"));
//        CUSTOMER_LIST.add(new Customer("Tâm Nguyễn", LocalDate.parse("11/09/1996"), "Nữ", "201111786",
//                "0956119007", "tamnguyen67@gmail.com", "1",
//                "Gold", "An Hải Tây - Sơn Trà - Đà Nẵng"));
//        CUSTOMER_LIST.add(new Customer("Khang Lê", LocalDate.parse("22/11/1999"), "Nam", "204589111",
//                "0967454666", "khangle123@gmail.com", "KH88500",
//                "Member", "Hòa Khánh Bắc - Liên Chiểu - Đà Nẵng"));
    }


}
