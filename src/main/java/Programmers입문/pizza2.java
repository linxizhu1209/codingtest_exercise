package Programmers입문;

import java.util.Scanner;

public class pizza2 {

    public int solution(int n){
        int answer=0;
        for(int i=1;i<n*6;i++){
            if((6*i)%n==0) return i;
        }
        return answer;
    }

    // n과 6의 최소공배수
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        pizza2 t = new pizza2();
        int n = in.nextInt();
        System.out.println(t.solution(n));
    }
}
