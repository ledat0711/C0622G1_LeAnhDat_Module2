/*Hai thuộc tính có access modifier là private: name (string) có giá trị mặc định là "John",
class (String) có giá trị mặc định là "C02".
Một hàm tạo không có tham số.
Hai phương thức có access modifier là public: setName và setClasses.
Hãy tạo lớp Test, tạo đối tượng  và truy cập đến các phương thức setName(name: String) và setClasses(classes: String).

Thay đổi access modifier cho các phương thức setName(name: String)
 và setClasses(classes: String), sau đó test lại.*/
package student_package;

public class Test {
    public static void main(String[] args) {
        Student studentObject = new Student();
        studentObject.setClassName("C12");
        studentObject.setName("Kevin");
    }
}
