package chapter2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class test4 {

    // 내가 짠 코드
    public int[] solution(int num) {
        int[] answer = new int[num+1];
        answer[0] = 0;
        answer[1] = 1;
        for(int i=2;i<num+1;i++){
            answer[i]=answer[i-1]+answer[i-2];
        }
        return answer;
    }

    public static void main(String[] args) {
        test4 T = new test4();
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[] arr = T.solution(num);
        for(int i=1;i<=num;i++) {
            System.out.print(arr[i]+" ");
        }
    }
}

