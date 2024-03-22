package Programmers입문;

import java.util.Scanner;

public class letter {
    public int solution(String message) {
        int answer = 0;
        int length = message.length();
        answer = length*2;
        return answer;
    }

    public static void main(String[] args) {
        letter T = new letter();
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.println(T.solution(str));
    }
}
