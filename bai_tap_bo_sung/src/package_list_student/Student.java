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

import java.util.Iterator;

public class Student {
    private String studentID;
    private String name;
    String birthDay;
    private boolean gender;
    private String className;
    private String course;
    static int numericalOrder = 1;

    public Student() {
    }

    public Student(String studentID) {
        this.studentID = studentID;
    }

    public Student(String studentID, String name) {
        this.studentID = studentID;
        this.name = name;
    }

    public Student(String studentID, String name, String birthDay, boolean gender, String className, String course) {
    }

    public static Iterator<String> iterator() {
        return null;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getName() {
        numericalOrder++;
        return name;
    }

    @Override
    public String toString() {
        return "Student " + numericalOrder + ": {" +
                "studentID=\"" + getStudentID() + '\"' +
                ", name=\"" + getName() + '\"' +
                '}';
    }
}
