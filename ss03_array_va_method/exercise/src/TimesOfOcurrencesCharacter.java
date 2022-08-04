import java.util.Scanner;
public class TimesOfOcurrencesCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = "an apple";
        System.out.printf("Chuỗi: \"%s\"", str);
        System.out.printf("\nNhập ký tự cần đếm số lần xuất hiện: ");
        char charFind = sc.nextLine().charAt(0);
        int count = 0;
        int i;
        for(i=0;i<str.length();i++){
            if (str.charAt(i)==charFind){
                count++;
            }
        }
        if(count!=0) {
            System.out.printf("\nKết quả");
            System.out.printf("\nKý tự %c xuất hiện %d lần", charFind, count);
        }else{
            System.out.printf("\nKết quả: ");
            System.out.printf("\nKhông tìm thấy ký tự %c trong chuỗi",charFind);
        }
    }
}
