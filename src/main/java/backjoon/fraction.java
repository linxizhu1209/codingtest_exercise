package backjoon;

import java.util.Scanner;

public class fraction {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int X = in.nextInt();
        int sum = 0;
        int i=1;
        while(sum<X) {
                sum += i;
                if (sum >= X) {
                    int slice = i;
                    int step = sum - X;
                    if (slice % 2 == 0) {
                        System.out.println((i - step) + "/" + (1 + step));
                    } else {
                        System.out.println((1 + step) + "/" + (i - step));
                    }

                }
            i++;
        }
    }
}
