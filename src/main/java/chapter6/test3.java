package chapter6;


import java.util.Scanner;

public class test3 {

    /** 삽입 정렬이란?
     *  1. 자료 배열의 모든 요소를 앞에서부터 차례대로 이미 정렬된 배열부분과 비교하여 자신의 위치를 찾아 삽입
     *  2. 두번째 요소부터 시작하여 앞쪽과 비교하여 위치 지정
     */
    // 내가 짠 코드
    public int[] solution(int[] arr){

        for(int i=1;i<arr.length;i++){ // i가 j보다 뒤쪽 배열
            for(int j=0;j<i;j++){ //j가 앞쪽 배열
                if(arr[j]>arr[i]){
                    int tmp=arr[j];
                    arr[j]=arr[i];
                    arr[i]=tmp;
                }
            }
        }
        return arr;
    }


    public static void main(String[] args) {
        test3 T = new test3();
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

