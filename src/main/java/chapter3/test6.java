package chapter3;

import java.util.Scanner;

public class test6 {
    // 강의 참고 코드
    public int solution(int n,int k,int[] arr){
        int answer=0, cnt=0, lt=0;
        for(int rt=0;rt<n; rt++){
            if(arr[rt]==0) cnt++;
            while(cnt>k){  // 만약 cnt가 k보다 커졌다면, 길이 계산전에 cnt를 조정해야함
                if(arr[lt]==0) cnt--; // lt가 0을 만나는지점까지 계속 증가하다가 0을 만나면 cnt를 마이너스1해주고
                lt++; // lt를 1 증가시켜서 0을 지나침 --> 0을 지나치는 이유는 그래야지 rt부터 lt까지의 길이를 구하니까
            }
            answer=Math.max(answer,rt-lt+1); //
        }
        return answer;
    }

//    public int solution(int num1,int num2, int[] arr) {
//        int max = Integer.MIN_VALUE;
//        int idx = 0;
//        while(num1-idx+1>max) {
//            int sum = 0;
//            int count = 0;
//            for (int i = idx; i < num1; i++) { //count가 1일때 idx를 i+1로 해야함
//                if (arr[i] == 0 && count < num2 && count ==0) {
//                    count++;
//                    sum += 1;
//                    idx = i+1;
//                } else if(arr[i] == 0 && count < num2 && count !=0) {
//                    count++;
//                    sum += 1;
//                }
//                else if (arr[i] == 0 && count == num2) {
//                    break;
//                } else {
//                    sum += arr[i];
//                }
//            }
//            if (sum > max) {
//                max = sum;
//            }
//        }
//        return max;
//    }

    public static void main(String[] args) {
        test6 T = new test6();
        Scanner in = new Scanner(System.in);
        int num1 = in.nextInt();
        int num2 = in.nextInt();
        int[] arr = new int[num1];
        for(int i=0;i<num1;i++){
            arr[i] = in.nextInt();
        }
        System.out.println(T.solution(num1,num2,arr));
    }
}

