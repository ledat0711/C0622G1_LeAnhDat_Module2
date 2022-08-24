package _test;

import package_quan_ly_ss16.model.Person;
import package_quan_ly_ss16.model.Student;
import package_quan_ly_ss16.model.Teacher;
import package_quan_ly_ss16.service.IStudentService;
import package_quan_ly_ss16.utils.exception.InvalidException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {

    public static Person test(List<? extends Person> personList) {
        return personList.get(0);
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(455, "An Nguyen", "12/12/1998", "Nam", 4, "C06"));
        students.add(new Student(881, "Ngoc Tran", "06/07/1995", "Nữ", 14, "C07"));
        List<Teacher> teachers = new ArrayList<>();
        teachers.add(new Teacher(15, "Truong Le", "06/07/1991","Nam", "Tutor", 30));
        teachers.add(new Teacher(26, "Binh Nguyen", "24/07/1990","Nam", "Instructor", 20));
        System.out.println(test(students));
        System.out.println(test(teachers));
    }
}
