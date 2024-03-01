package chapter3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;


public class test3 {

    // 강의 참고한 코드
    public int solution(int[] arr1, int n1, int n2) {
        int sum = 0;
        for (int i = 0; i < n2; i++) {
            sum += arr1[i];
        }
        int p1 = n2;
        int result = sum;
        while (p1 + n2 < n1) {

            result += arr1[p1] - arr1[p1 - n2];
            if (result > sum) {
                sum = result;
                p1++;
            }
            else p1++;
        }
        return sum;
    }
        // 내가 짠 코드
//    public int solution(int[] arr1, int n1, int n2) {
//        int max = Integer.MIN_VALUE;
//        int p1 = 0;
//        while(p1+n2-1<n1){
//            int sum = 0;
//            for(int i=p1;i<p1+n2;i++){
//                sum += arr1[i];
//            }
//            if(sum>max){
//                max=sum;
//                p1++;
//            }
//            else p1++;
//        }
//        return max;
//


    public static void main(String[] args) {
        test3 T = new test3();
        Scanner in = new Scanner(System.in);
        int num1 = in.nextInt();
        int num2 = in.nextInt();
        int[] arr1 = new int[num1];
        for(int i=0;i<num1;i++){
            arr1[i] = in.nextInt();
        }
        System.out.println(T.solution(arr1,num1,num2));
    }
}

