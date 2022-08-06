/*Xây dựng một chương trình quản  lý danh  sách các  sinh viên  của một lớp.
Mỗi sinh viên gồm các thông tin: mã số sinh viên (MSSV),  họ  tên, ngày sinh, giới tính, tên lớp, khóa.
Chương trình sẽ thực hiện các chức năng cụ thể như sau:
-	Add(student, p): Bổ sung thêm một sinh viên student vào vị trí  cuối của danh sách.
-	Remove(mssv): Loại bỏ một sinh viên với MSSV được nhập từ bàn phím.
-	Remove(p): Loại bỏ sinh viên ở vị trí thứ p bất  kỳ trong danh  sách (phần tử  đầu tiên có vị trí là 1).
-	Search(s): Tìm một sinh viên theo MSSV hoặc theo tên
(với một thông tin s  vào thì trước tiên tìm sinh viên có MSSV =  s, nếu không thấy thì  tìm sinh  viên có Họ tên = s.
-	Print(): In ra nội dung danh sách sinh viên.
-	Sort(type): sắp xếp danh sách theo MSSV.
*/
package package_list_student;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Object> studentList = new ArrayList<>();//Mảng có thể thay đổi kích thước
        studentList.add(new Student("A1", "Cuong"));
        studentList.add(new Student("B1", "Lam"));
        studentList.add(new Student("C1", "Binh"));
        studentList.add(new Student("D1", "Phuong"));
        studentList.add(new Student("E1", "Chinh"));
        int i;
        for (i = 0; i < studentList.size(); i++) {
            System.out.println(studentList.get(i));
        }
        System.out.print("Nhập ID của sinh viện bạn muốn xóa: ");
        String deleteID = scanner.nextLine();
        for (i = 0; i < studentList.size(); i++) {
            Student student = (Student) studentList.get(i);
            if (student.getStudentID().equals(deleteID)) {
                studentList.remove(studentList.get(i));
            }
        }
        Student.numericalOrder = 1;
        for (i = 0; i < studentList.size(); i++) {
            System.out.println(studentList.get(i));
        }
        System.out.print("Xóa sinh viên ở vị trí: ");
        int deletePlace = Integer.parseInt(scanner.nextLine());
        for (i = 0; i < studentList.size(); i++) {
            if (deletePlace==(i+1)) {
                studentList.remove(studentList.get(i));
            }
        }
        Student.numericalOrder = 1;
        for (i = 0; i < studentList.size(); i++) {
            System.out.println(studentList.get(i));
        }
    }
}