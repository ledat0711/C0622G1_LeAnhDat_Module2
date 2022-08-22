package read_file_csv.view;

import read_file_csv.model.Country;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MainView {
    public static void main(String[] args) throws IOException {
        displayInfo();
    }

    public static void displayInfo() throws IOException {
        List<Country> countries = readFile();
        Country.numericalOrder = 0;
        for (Country country : countries) {
            System.out.println(country);
        }
    }

    public static List<Country> readFile() throws IOException {
        File file = new File("src\\read_file_csv\\data\\country_in.csv");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<Country> countries = new ArrayList<>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            if ("".equals(line)) {
                continue;
            }
            String[] info = line.split(",");
            Country country = new Country();
            countries.add(new Country(Integer.parseInt(info[0]), info[1], info[2]));
        }
        bufferedReader.close();
        return countries;
    }
}