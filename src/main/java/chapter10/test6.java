package chapter10;

import java.util.Arrays;
import java.util.Scanner;

public class test6 {
    // 강의 참고한 코드
    static int n, m;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        int[] dy = new int[m + 1];
        for (int i = 0; i < n; i++) {
            int ps = in.nextInt();
            int pt = in.nextInt();
            for (int j = m; j >= pt; j--) {
                dy[j] = Math.max(dy[j], dy[j - pt] + ps);
            }
        }
        System.out.println(dy[m]);
    }
}
