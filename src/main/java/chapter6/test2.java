package chapter6;


import java.util.Scanner;

public class test2 {
    // 강의 참고하여 짠 코드(버블정렬 활용)


    /** 버블 정렬이란?
     *  1. 첫번째 요소부터 시작하여 인접한 요소와 비교
     *  2. 만약 두 요소의 순서가 요구한 조건과 맞지않다면(오름차순인데 앞이 더 큰 숫자), 두 요소의 위치를 교환
     *  3. 배열의 끝까지 순회한 후, 가장 큰 요소가 배열의 마지막 위치로 이동(오름차순의 경우)
     */
    public int[] solution(int[] arr){

        for(int i=0;i<arr.length;i++){
            for(int j=1;j<arr.length-i;j++){
            int tmp = 0;
            if(arr[j-1]>arr[j]){
                tmp = arr[j-1];
                arr[j-1] = arr[j];
                arr[j] = tmp;
            }
        }}
        return arr;
    }


    public static void main(String[] args) {
        test2 T = new test2();
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

