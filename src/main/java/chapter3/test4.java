package chapter3;

import java.util.Scanner;


public class test4 {
    // 강의에서 구현한 코드
    public int solution(int[] arr, int n1, int n2){
        int answer =0, sum=0, lt=0;
        for(int rt=0;rt<n1;rt++){
            sum+=arr[rt];
            if(sum==n2) answer++;
            while(sum>=n2){
                sum-=arr[lt++];
                if(sum==n2) answer++;
            }
        }
        return answer;
    }



    // 강의 참고하여 내가 짠 코드
//    public int solution(int[] arr, int n1, int n2){
//    int lt=0,rt=0;
//    int count = 0;
//    int sum = 0;
//    while(rt<n1){
//        if(sum<n2){
//            sum+=arr[rt++];
//        }
//        else if(sum==n2){
//            count++;
//            sum-=arr[lt++];
//        }
//        else{
//            sum-=arr[lt++];
//        }
//    }
//    while(lt<n1) {
//        if (sum > n2) {
//            sum -= arr[lt++];
//        }
//        else if(sum==n2){
//            count++;
//            break;
//        }
//        else{
//            break;
//        }
//    }
//    return count;
//    }


    // 내가 짠 코드
//    public int solution(int[] arr1, int n1, int n2) {
//        int count = 0;
//        int p1 = 0;
//        while(p1<n1){
//            p1++;
//            int sum = 0;
//            for(int i=p1;i<n1;i++){
//                sum += arr1[i];
//                if(sum==n2) {
//                    count++;
//                    break;
//                }
//            }
//        }
//        return count;
//
//    }
//



    public static void main(String[] args) {
        test4 T = new test4();
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

