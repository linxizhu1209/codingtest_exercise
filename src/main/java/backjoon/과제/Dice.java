package backjoon.과제;

import java.util.Scanner;

public class Dice {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int l = in.nextInt();
        if (n != m && n != l && m != l) {
            int max = Math.max(n, m);
            System.out.println(100 * Math.max(max, l));
        } else if (n == m && n != l) System.out.println(1000 + (n * 100));
        else if (n == l && n != m) System.out.println(1000 + (n * 100));
        else if (m == l && m != n) System.out.println(1000 + (m * 100));
        else System.out.println(10000 + (n * 1000));
    }
}
