/*Mục đích
Luyện tập sử dụng Stack
Mô tả
Kiểm tra dấu ngoặc trong biểu thức.
Một biểu thức sử dụng dấu ngoặc (Bracket) đúng nếu:
với mỗi dấu ngoặc trái sẽ có 1 dấu ngoặc phải gần nhất khớp với nó;
với mỗi dấu ngoặc phải sẽ có 1 dấu ngoặc trái gần nhất (bên trái) khớp với nó;
một đoạn biểu thức nằm giữa một cặp dấu ngoặc trái, phải được gọi là sử dụng đúng dấu ngoặc;
Ví dụ về sử dụng dấu ngoặc trong biểu thức toán học:
s * (s – a) * (s – b) * (s – c)            → Well
(– b + (b2 – 4*a*c)^0.5) / 2*a                  → Well
s * (s – a) * (s – b * (s – c)             → ???
s * (s – a) * s – b) * (s – c)             → ???
(– b + (b^2 – 4*a*c)^(0.5/ 2*a))     → ???
Hướng dẫn
Giải thuật kiểm tra sử dụng dấu ngoặc:
1. Tạo một bStack rỗng (Stack chứa dấu ngoặc).
2. Với mỗi ký hiệu sym trong đoạn (từ trái sang phải):
2.1. Nếu sym là dấu ngoặc trái:
2.1.1. Đưa sym vào bStack.
2.2. Nếu sym là dấu ngoặc phải:
2.2.1. Nếu bStack rỗng, return false.
2.2.2. Lấy dấu ngoặc ở bStack, đưa vào biến left.
2.2.3. Nếu left và sym không khớp được với nhau, return false.
3. Dừng giải thuật, trả về True nếu bStack rỗng, hoặc False với các trường hợp khác.*/
package check_brackets_in_expressions.service;

import java.util.Stack;

public class CheckBracketsInExpressions {
    public static boolean check(String stringInside) {
        Stack<Character> bStack = new Stack<>();
        char[] charArr = stringInside.toCharArray();
        for (char sym : charArr) {
            if (sym == '(') {
                bStack.push(sym);
            } else if (sym == ')') {
                if (bStack.isEmpty()) {
                    return false;
                } else {
                    bStack.pop();
                }
            }
        }
        if (bStack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
