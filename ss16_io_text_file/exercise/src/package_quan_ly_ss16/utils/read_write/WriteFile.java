package package_quan_ly_ss16.utils.read_write;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import package_quan_ly_ss16.controller.MainController;
import package_quan_ly_ss16.model.Student;
import read_file_csv.model.Country;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WriteFile {
    public static void main(String[] args) throws IOException {
        add();
        displayInfo();
    }

    public static void displayInfo() throws IOException {
        List<Student> students = readFile();
        System.out.println("Bạn đã nhập những thông tin sau vào file destination_student_list_file:");
        for (Student student : students) {
            System.out.println(student.toString2());
        }
    }

    public static void add() throws IOException {
        List<Student> students = readFile();
        writeFile(students, true);
    }

    public static void writeFile(List<Student> students, boolean appendValue) throws IOException {
        File file = new File("src\\package_quan_ly_ss16\\data\\students_destionation.csv");
        FileWriter fileWriter = new FileWriter(file, appendValue);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for (Student student : students) {
            bufferedWriter.write(student.toString2());
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }

    public static List<Student> readFile() throws IOException {
        File file = new File("src\\package_quan_ly_ss16\\data\\students_source.csv");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<Student> students = new ArrayList<>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            if ("".equals(line)) {
                continue;
            }
            String[] info = line.split(",");
            Student student = new Student();
            students.add(new Student(Integer.parseInt(info[0]), info[1], info[2], info[3], Double.parseDouble(info[4]), info[5]));
        }
        bufferedReader.close();
        return students;
    }
}
