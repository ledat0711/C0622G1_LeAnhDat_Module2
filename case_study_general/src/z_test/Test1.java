package z_test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Test1 {
    public static void main(String[] args) {
        LocalDate dateInput1 = LocalDate.parse("01/09/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate dateInput2 = LocalDate.parse("10/09/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate dateInput3 = LocalDate.parse("05/09/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        int a = dateInput1.until(LocalDate.now()).getDays();
        int b = dateInput2.until(LocalDate.now()).getDays();
        int c = dateInput3.until(LocalDate.now()).getDays();

        System.out.println(a + "," + b + "," + c);
    }
}