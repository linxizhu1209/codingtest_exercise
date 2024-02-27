package chapter2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test1 {
    public List<Integer> solution(int[] arr){
        // String answer = "";
        List<Integer> answer = new ArrayList<>();
        int n=0;
        for(int x:arr){
            if(x>n) answer.add(x);
            n=x;
        }
        return answer;
    }
    public static void main(String[] args) {
        test1 T = new test1();
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[] arr = new int[num];
        for(int i=0;i<num;i++) {
            arr[i] = in.nextInt();
        }
        for(int x:T.solution(arr)){
         System.out.print(x+" ");
        }
    }
}

