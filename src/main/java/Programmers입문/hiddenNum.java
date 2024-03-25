package Programmers입문;

import java.util.Scanner;

public class hiddenNum {
    public int solution(String my_string){
        int answer = 0;
        for(char x:my_string.toCharArray()){
            if(Character.isDigit(x)) answer+=x-'0';
        }
        return answer;
    }

    public static void main(String[] args) {
        hiddenNum t = new hiddenNum();
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.println(t.solution(str));
    }
}
