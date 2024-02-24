package chapter1;

import org.example.Main;

import java.util.Scanner;

public class test1 {
    public int solution(String str,char t) {
        String input3 = str.toLowerCase();
        char input4 = Character.toLowerCase(t);
        int count = 0;
//        for (int i = 0; i < input3.length(); i++) {
//            if (input3.charAt(i) == input4) {
//                count++;
//            }
//        }
        for(char x : input3.toCharArray()){
            if(x==input4) count++;
        }
        return count;
    }
    public static void main(String[] args) {
        test1 T = new test1();
        Scanner in = new Scanner(System.in);
        String input1 = in.next();
        char input2 = in.next().charAt(0);
        System.out.println(T.solution(input1,input2));
    }
}
