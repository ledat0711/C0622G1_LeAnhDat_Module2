package package_quan_ly_ss16.view;

import package_quan_ly_ss16.model.Student;
import read_file_csv.model.Country;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainViewReadAndWrite2 {
    public static void main(String[] args) throws IOException {
        displayInfo();
    }

    public static void displayInfo() throws IOException {
        List<Student> students = readFile();
        Country.numericalOrder = 0;
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public static List<Student> readFile() throws IOException {
        File file = new File("src\\package_quan_ly_ss16\\data\\source_file.csv");
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
