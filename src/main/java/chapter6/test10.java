package chapter6;


import java.util.Arrays;
import java.util.Scanner;

public class test10 {
    public int count(int[] arr, int distance){
        int cnt = 1; // 말의 마리수
        int ep = arr[0]; // 마지막으로 말을 배치한 좌표
        for(int i=1; i<arr.length;i++){
            if(arr[i]-ep>= distance){
                cnt++;
                ep=arr[i];
            }
        }
        return cnt;
    }
    public int solution(int n, int m, int[] arr) {
        int answer = 0;
        Arrays.sort(arr);
        int lt = 1;
        int rt = arr[n-1];
        while (lt <= rt) {
            int mid = (rt+lt) / 2;
            if(count(arr,mid)>=m){
                answer = mid;
                lt=mid+1;
            }
            else rt=mid-1;
    }
        return answer;
    }

    public static void main(String[] args) {
        test10 T = new test10();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.print(T.solution(n,m,arr));
    }
}

