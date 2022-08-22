/*Mô tả bài toán
Viết một chương trình cho phép người dùng sao chép các tập tin.
Người sử dụng cần phải cung cấp một tập tin nguồn (source file) và một tập tin đích (target file).

Chương trình sao chép tệp nguồn vào tệp tin đích và hiển thị số ký tự trong tệp.
Chương trình nên cảnh báo người dùng nếu tệp nguồn không tồn tại hoặc nếu tập tin đích đã tồn tại.

Để sao chép nội dung từ tệp tin nguồn đến tệp tin đích,
bạn nên sử dụng luồng đầu vào để đọc ký tự từ tệp nguồn và luồng đầu ra để gửi byte đến tệp tin đích,
bất kể nội dung của tệp.*/
package copy_file_text;

import java.io.*;
import java.util.*;

public class MainView {
    public static void main(String[] args) throws IOException {
        add();
    }

    private static void writeFile(List<String> strings) throws IOException {
        File file = new File("src\\copy_file_text\\data\\destination_file.csv");
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
        File file = new File("src\\copy_file_text\\data\\source.csv");
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