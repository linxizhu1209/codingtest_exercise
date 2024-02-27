package chapter2;


import java.util.Scanner;

public class test2 {
    // 내가 짠 코드
    public int solution(int[] arr){
        int answer = 0;
        int num=0;
        for(int x:arr){
            if(x>num){
                answer++;
                num=x;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        test2 T = new test2();
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[] arr = new int[num];
        for(int i=0;i<num;i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(T.solution(arr));
    }
}

