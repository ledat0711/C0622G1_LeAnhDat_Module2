package service.impl;

import service.IMemberService;
import service.IStudentService;

import java.util.Scanner;

public class MemberService implements IMemberService {
    private static Scanner scanner = new Scanner(System.in);
    private static IStudentService studentService1;

    @Override
    public void showTypesOfMembers() {
        System.out.print("Mời bạn chọn mục 1 hoặc 2: ");
        int id = Integer.parseInt(scanner.nextLine());
    }
}
