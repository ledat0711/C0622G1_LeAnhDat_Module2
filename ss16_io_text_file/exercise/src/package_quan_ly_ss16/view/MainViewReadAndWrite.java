package package_quan_ly_ss16.view;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MainViewReadAndWrite {
    public static void main(String[] args) throws IOException {
        add();
    }

    private static void writeFile(List<String> strings) throws IOException {
        File file = new File("src\\package_quan_ly_ss16\\data\\destination_file.csv");
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for (String str : strings) {
            bufferedWriter.write(str.toString());
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }

    private static void add() throws IOException {
        List<String> strings = readFile();
        writeFile(strings);
    }
    private static List<String> readFile() throws IOException {
        File file = new File("src\\package_quan_ly_ss16\\data\\source_file.csv");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> stringAndLengths = new ArrayList<>();
        String line;
        int lengthAllChar = 0;
        while ((line = bufferedReader.readLine()) != null) {
            if ("".equals(line)) {
                continue;
            }
            lengthAllChar += line.length();
            stringAndLengths.add(line);
        }
        System.out.println("Số ký tự trong tệp: " + lengthAllChar);
        return stringAndLengths;
    }
}
