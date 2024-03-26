package Programmers입문;

import java.util.Scanner;

public class ants {
    public int solution(int hp){
        int answer = (hp/5) + (hp%5)/3 + ((hp%5)%3);
        return answer;
    }

    public static void main(String[] args) {
        ants t = new ants();
        Scanner in = new Scanner(System.in);
        int hp = in.nextInt();
        System.out.println(t.solution(hp));
    }
}
