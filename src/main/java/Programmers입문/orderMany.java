package Programmers입문;

import java.util.Scanner;

public class orderMany {
    public int solution(int n){
        int answer=0;
        for(int i=1;i<=n;i++){
            if(n%i==0) answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        orderMany t = new orderMany();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(t.solution(n));
    }
}
