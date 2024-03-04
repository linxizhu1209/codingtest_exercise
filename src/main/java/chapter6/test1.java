package chapter6;


import java.util.Arrays;
import java.util.Scanner;

public class test1 {
    // 강의 참고하여 짠 코드(선택정렬 활용)
    public int[] solution(int[] arr){
        for(int i=0;i<arr.length-1;i++){ // 어차피 j가 끝까지 돌면서 정렬이 완료된 상태이기에 마지막까지 돌 필요없음
            int idx=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[idx]>arr[j]){
                    idx=j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = tmp;
        }
        return arr;
    }



    // 내가 짠 코드
//    public int[] solution(int[] arr) {
//        Arrays.sort(arr);
//        return arr;
//    }

    public static void main(String[] args) {
        test1 T = new test1();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int[] result = T.solution(arr);
        for (int x : result) {
            System.out.print(x + " ");
        }
    }
}

