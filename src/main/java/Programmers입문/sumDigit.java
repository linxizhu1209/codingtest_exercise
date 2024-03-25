package Programmers입문;

import java.util.Scanner;

public class sumDigit {

    public int solution(int n){
        int answer = 0;
        while(n>0){
            // 1234
            answer += n%10;
            n=n/10;
        }
        return answer;
    }

    public static void main(String[] args) {
        sumDigit t = new sumDigit();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(t.solution(n));
    }



}
