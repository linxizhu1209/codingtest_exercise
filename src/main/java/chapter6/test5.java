package chapter6;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class test5 {
    public String solution(int n,int[] arr){
// 강의에서 푼 코드(배열 정렬을 이용)
        String answer = "U";
        Arrays.sort(arr);
        for(int i=0;i<n-1;i++) {
            if (arr[i] == arr[i + 1]) return "D";
        }
        return answer;

        // 내가 푼 코드
        //        Queue<Integer> q = new LinkedList<>();
//        String answer = "U";
//        for(int x:arr){
//            q.offer(x);
//        }
//        int s = q.size();
//        for(int i=0;i<s;i++) {
//            if (q.contains(q.poll())) {
//                return "D";
//            }
//        }
//        return answer;
    }


    public static void main(String[] args) {
        test5 T = new test5();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.print(T.solution(n,arr));
    }
}

