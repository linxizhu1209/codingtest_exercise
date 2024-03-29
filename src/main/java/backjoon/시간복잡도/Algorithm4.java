package backjoon.시간복잡도;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * MenOfPassion(A[], n) {
 *     sum <- 0;
 *     for i <- 1 to n - 1
 *         for j <- i + 1 to n
 *             sum <- sum + A[i] × A[j]; # 코드1
 *     return sum;
 * }
 */
public class Algorithm4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Long n = Long.parseLong(bf.readLine());
        Long sum = 0l;
        for(int i=1;i<n;i++){
            sum += i;
        }
        System.out.println(sum);
        System.out.println(2);
    }
    }
