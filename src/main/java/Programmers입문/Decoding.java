package Programmers입문;

import java.util.Scanner;

public class Decoding {
    public String solution(String cipher, int code){
        String answer = "";
        for(int i=code-1;i<cipher.length();i+=code){
            answer+=cipher.charAt(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        Decoding t = new Decoding();
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int n = in.nextInt();
        System.out.println(t.solution(str,n));


    }
}
