package chapter2;

import java.util.Scanner;

public class test5 {
// 강의 참고 코드(에라토스테네스 체-소수를 구하는 방법)
    public int solution(int num){
        int answer = 0;
        int[] arr = new int[num+1];
        for(int i=2;i<num+1;i++){
            if(arr[i]==0){
                answer++;
            for(int j=i;j<num+1;j=j+i) { // j=j+i 인 이유는 i의 배수를 인덱스로 갖는 곳에 1씩 넣을 거니까
                    arr[j] = 1;
                }
            }
        }
        return answer;
    }

    // 내가 짠 코드 (시간 초과로 오답)
   // public int solution(int num) {
//        int count = 0;
//        int answer = 0;
//        for(int i=2;i<=num;i++){
//            for(int j=2;j<=i;j++){
//                if(i%j==0&&i!=j){
//                    count++;
//                }
//            }
//            if(count!=0){
//                count=0;
//            }
//            else{
//                answer++;
//            }
//        }
//        return answer;
//    }

    public static void main(String[] args) {
        test5 T = new test5();
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        System.out.println(T.solution(num));
    }
}

