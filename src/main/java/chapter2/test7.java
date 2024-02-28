package chapter2;

import java.util.Scanner;

public class test7 {
// 내가 푼 코드
    public int solution(int num,int[] arr){
        int answer = 0;
        int count = 0;
        for(int i=0;i<num;i++){
            if(arr[i]==1){
                count++;
                answer+=count;
            }
            else{
                count=0;
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        test7 T = new test7();
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[] arr = new int[num];
        for(int i=0;i<num;i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(T.solution(num,arr));
    }
}

