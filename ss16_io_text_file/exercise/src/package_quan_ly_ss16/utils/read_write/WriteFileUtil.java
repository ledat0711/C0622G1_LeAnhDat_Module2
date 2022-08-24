package package_quan_ly_ss16.utils.read_write;

import package_quan_ly_ss16.model.Student;
import package_quan_ly_ss16.model.Teacher;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteFileUtil {
    public static void writeFile(String path, String data) throws IOException {
        File file = new File(path);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write(data);
        bufferedWriter.close();
    }

    public static void writeStudentFile(String path, List<Student> studentList) throws IOException {
        String data = "";
        for (Student student : studentList) {
            data += student.toString() + "\n";
        }
        writeFile(path, data);
    }
    public static void writeTeacherFile(String path, List<Teacher> teacherList) throws IOException {
        String data = "";
        for (Teacher teacher : teacherList) {
            data += teacher.toString() + "\n";
        }
        writeFile(path, data);
    }
}
