package thuat_toan_2_ngay_10_thang_8;

import java.util.Arrays;

public class ThuatToan2RutGon {
    public static int left(int[] a, int index1) {
        int i;
        int sum1 = 0;
        for (i = 0; i < index1; i++) {
            sum1 += a[i];
        }
        return sum1;
    }

    public static int right(int[] b, int index2) {
        int j;
        int sum2 = 0;
        for (j = b.length - 1; j > index2; j--) {
            sum2 += b[j];
        }
        return sum2;
    }

    public static boolean check(int[] a) {
        int i;
        for (i = 1; i < a.length - 1; i++) {
            if (left(a, i) == right(a, i)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 3, 2, 1};
        System.out.println(check(a));
        int[] b = {1, 2, 3, 4, 7, 7, 1};
        System.out.println(check(b));
    }
}