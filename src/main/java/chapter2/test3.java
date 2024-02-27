package chapter2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test3 {

    // 내가 짠 코드
    public List<String> solution(int num, int[] A, int[] B) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            if (A[i] == B[i]) {
                result.add("D");
            } else if (A[i] == 1 && B[i] == 2) result.add("B");
            else if (A[i] == 2 && B[i] == 3) result.add("B");
            else if (A[i] == 2 && B[i] == 1) result.add("A");
            else if (A[i] == 1 && B[i] == 3) result.add("A");
            else if (A[i] == 3 && B[i] == 2) result.add("A");
            else if (A[i] == 3 && B[i] == 1) result.add("B");
        }
        return result;
    }

    public static void main(String[] args) {
        test3 T = new test3();
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[] A = new int[num];
        for (int i = 0; i < num; i++) {
            A[i] = in.nextInt();
        }
        int[] B = new int[num];
        for (int i = 0; i < num; i++) {
            B[i] = in.nextInt();
        }
        List<String> result = T.solution(num, A, B);
        for (String x : result) {
            System.out.println(x);
        }
    }
}

