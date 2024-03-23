package Programmers입문;

import java.util.Scanner;

public class 세균증식 {

    public int solution(int n, int t){
        int answer = 0;
        answer = (int)(n*(Math.pow((double) 2,(double) t)));
        return answer;
    }

    public static void main(String[] args) {
        세균증식 T = new 세균증식();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int t = in.nextInt();
        System.out.println(T.solution(n,t));


    }

}
