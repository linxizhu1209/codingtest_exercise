package chapter8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class test5 {
    /**
     * 내가 짠 코드
     */
    static int n,m = 0;
    static int answer = Integer.MAX_VALUE;
    public void DFS(int L, int sum,Integer[] arr) {
        if(sum>m) return;
        if(L>=answer) return;
        if (sum == m) {
            answer = Math.min(answer,L);
        } else {
            for (int i = 0; i < n; i++) {
                DFS(L + 1,sum+arr[i], arr);
            }
        }
    }


    public static void main(String[] args) {
        test5 T = new test5();
        Scanner in = new Scanner(System.in);
        n= in.nextInt();
        Integer[] arr = new Integer[n];
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }
        m= in.nextInt();
        Arrays.sort(arr, Collections.reverseOrder());
        T.DFS(0,0,arr);
        System.out.println(answer);
    }
}

