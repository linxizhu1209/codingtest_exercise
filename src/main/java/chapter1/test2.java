package chapter1;

import java.util.Scanner;

public class test2 {
    public String solution(String str) {
        String str2 = "";
        for (char x : str.toCharArray()) {
//            if(Character.isUpperCase(x)){
//                str2 += Character.toLowerCase(x);
//            }
//            else{
//                str2 +=Character.toUpperCase(x);
//            }
//        }
            if (65 <= x && x <= 90) str2 += (char)(x + 32);
            else str2 += (char)(x - 32);
        }
        return str2;
    }
    public static void main(String[] args) {
        test2 T = new test2();
        Scanner in = new Scanner(System.in);
        String input1 = in.next();
        System.out.println(T.solution(input1));
    }
}
