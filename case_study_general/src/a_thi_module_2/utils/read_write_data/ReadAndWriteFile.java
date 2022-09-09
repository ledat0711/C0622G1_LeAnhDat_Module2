package a_thi_module_2.utils.read_write_data;


import a_thi_module_2.model.Employee;
import a_thi_module_2.model.Student;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ReadAndWriteFile {
    public static void writeStringToFile(String path, List<String> stringList, boolean append) {
        try {
            File file = new File(path);
            FileWriter fileWriter = new FileWriter(file, append);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (String string : stringList) {
                bufferedWriter.write(string);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> readStringFromFile(String path) {
        String line;
        List<String> stringList = new ArrayList<>();
        File file = new File(path);
        FileReader fileReader;
        BufferedReader bufferedReader;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                stringList.add(line);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy file");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringList;
    }


    /**
     * EMPLOYEE!!
     * */
    public static void writeEmployeeToFile(String path, List<Employee> employeeList, boolean append) {
        List<String> stringList = new ArrayList<>();
        for (Employee employee : employeeList) {
            stringList.add(employee.toString());
        }
        writeStringToFile(path, stringList, append);
    }
    public static List<Employee> readEmployeeFromFile(String path) {
        List<Employee> employeeList = new ArrayList<>();
        List<String> stringList = ReadAndWriteFile.readStringFromFile(path);
        for (String string : stringList) {
            String[] array = string.split(",");
            employeeList.add(new Employee(array[0],
                    array[1],
                    LocalDate.parse(array[2], DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                    array[3],
                    array[4],
                    Double.parseDouble(array[5]),
                    array[6],
                    array[7]));
        }
        return employeeList;
    }


    /**
     * STUDENT!!!
     */
    public static void writeStudentToFile(String path, List<Student> studentList, boolean append) {
        List<String> stringList = new ArrayList<>();
        for (Student student : studentList) {
            stringList.add(student.toString());
        }
        writeStringToFile(path, stringList, append);
    }
    public static List<Student> readStudentFromFile(String path) {
        List<Student> studentList = new ArrayList<>();
        List<String> stringList = ReadAndWriteFile.readStringFromFile(path);
        for (String string : stringList) {
            String[] array = string.split(",");
            studentList.add(new Student(array[0],
                    array[1],
                    LocalDate.parse(array[2], DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                    array[3],
                    array[4],
                    Double.parseDouble(array[5]),
                    array[6],
                    LocalDate.parse(array[7], DateTimeFormatter.ofPattern("yyyy-MM-dd"))));
        }
        return studentList;
    }
}
