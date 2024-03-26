package Programmers입문;

import java.util.Scanner;

public class repeatChar {
    public String solution(String my_string, int n) {
        String answer = "";
        for (char x : my_string.toCharArray()) {
            answer += String.valueOf(x).repeat(n);
        }
        return answer;
    }

    public static void main(String[] args) {
        repeatChar t = new repeatChar();
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int n = in.nextInt();
        System.out.println(t.solution(str,n));
    }


}
