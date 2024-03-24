package Programmers입문;

import javax.script.ScriptContext;
import java.util.Scanner;

public class pizza3 {
    public int solution(int slice, int n){
        int answer = 0;
        answer = n%slice==0?n/slice:(n/slice)+1;
        return answer;

    }

    public static void main(String[] args) {
        pizza3 t = new pizza3();
        Scanner in = new Scanner(System.in);
        int slice = in.nextInt();
        int n = in.nextInt();
        System.out.println(t.solution(slice,n));
    }
}
