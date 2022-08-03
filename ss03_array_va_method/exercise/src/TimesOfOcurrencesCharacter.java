import java.util.Scanner;
public class TimesOfOcurrencesCharacter {
    public static void main(String[] args) {
        String str = "an apple";
        char a = 'a';
        int count = 0;
        int i;
        for(i=0;i<str.length();i++){
            if (str.charAt(i)==a){
                count++;
            }
        }
        System.out.printf("Chuỗi: ''%s''",str );
        System.out.println("\nXét số lần xuất hiện ký tự 'a'\n");
        System.out.printf("Số lần xuất hiện: %d", count);
    }
}
