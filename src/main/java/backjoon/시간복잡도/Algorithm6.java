package backjoon.시간복잡도;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * MenOfPassion(A[], n) {
 *     sum <- 0;
 *     for i <- 1 to n - 2
 *         for j <- i + 1 to n - 1
 *             for k <- j + 1 to n
 *                 sum <- sum + A[i] × A[j] × A[k]; # 코드1
 *     return sum;
 * }
 */
public class Algorithm6 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Long n = Long.parseLong(bf.readLine());
        Long sum = ((n-1)*(n-2) + (n-2)*(n-3) + (n-3)*(n-4))/2 + n-3;
        System.out.println(sum);
        System.out.println(3);
    }



}
