package backjoon.시간복잡도;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Algorithm1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        System.out.println("1");
        System.out.println("0");
    }
}

/**
 * MenOfPassion(A[], n) {
 *     i = ⌊n / 2⌋;
 *     return A[i]; # 코드1
 * }
 */