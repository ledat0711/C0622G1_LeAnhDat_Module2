package thuat_toan_2_ngay_10_thang_8;

/*Kiểm tra mảng có “đẹp”:

Một mảng được gọi là "đẹp" nếu mảng đó chứa một phần tử
mà phần tử đó chia mảng làm 2 phần (không rỗng và không chứa phần tử đó) có tổng bằng nhau.
Hãy kiểm tra xem một mảng bất kì có phải là một mảng "đẹp" hay không?
Ví dụ:
Với a = [1, 2, 3] thì kết quả beautifulArray(a) = false
Với a = [1, 2, 3, 3] đầu ra của chương trình sẽ là beautifulArray(a) = true
Chọn phần tử ở vị trí thứ 3 (tính từ trái sang),
thì mảng ban đầu được chia thành 2 phần [1,2] và [3] có tổng 2 phần bằng nhau
Input:
Array.integer a
0 <= a.length <= 10000
Output:
boolean

[execution time limit] 4 seconds (js)

[input] array.integer arr

[output] boolean

[JavaScript] Syntax Tips*/
public class ThuatToan2GiaiThich {
    public static int left(int[] a, int index1) {
        int i;
        int sum1 = 0;
        for (i = 0; i < index1; i++) {
            sum1 += a[i];
            System.out.println(a[i]);
        }
        System.out.println("sum1: " + sum1);
        System.out.println("chỉ số left: " + index1);
        System.out.println();
        return sum1;
    }

    public static int right(int[] b, int index2) {
        int j;
        int sum2 = 0;
        for (j = b.length - 1; j > index2; j--) {
            System.out.println(b[j]);
            sum2 += b[j];
        }
        System.out.println("sum2: " + sum2);
        System.out.println("chỉ số right: " + index2);
        System.out.println();
        System.out.println("---------------------------------------------------");
        return sum2;
    }

    public static boolean check(int[] a) {
        int i;
        for (i = 0; i < a.length; i++) {
            if (left(a, i) == right(a, i)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,3};
        check(a);
        System.out.println(check(a));
    }
}
