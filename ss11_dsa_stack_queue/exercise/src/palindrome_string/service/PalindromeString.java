/*Mục đích
Luyện tập sử dụng Queue
Mô tả
Kiểm tra chuỗi Palindrome sử dụng Queue.
Khái niệm: Một chuỗi được gọi là Palindrome nếu như đọc xuôi giống đọc ngược.
Bài toán: Cho trước một chuỗi, kiểm tra xem chuỗi đó có phải là chuỗi palindrome hay không?
Ví dụ về chuỗi palindrome: Able was I ere I saw Elba*/

package palindrome_string.service;

import java.util.LinkedList;
import java.util.Queue;

public class PalindromeString {
    public static void checkPalindromeString(String string) {
        char[] charArr = string.toCharArray();
        Queue<Character> queue1 = new LinkedList<>();
        Queue<Character> queue2 = new LinkedList<>();
        int i;
        int j;
        for (i = 0, j = charArr.length - 1; i < charArr.length; i++, j--) {
            queue1.add(charArr[i]);
            queue2.add(charArr[j]);
        }
        if (queue1.equals(queue2)) {
            System.out.println("Đây ĐÚNG là chuỗi palindrome");
            return;
        }
        System.out.println("Đây KHÔNG phải chuỗi palindrome");
    }
}
