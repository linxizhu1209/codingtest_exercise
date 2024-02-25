package chapter1;

import java.util.ArrayList;
import java.util.Scanner;

public class test7 {
    public String solution(String str) {
        String answer = "YES";
        str = str.toLowerCase();
        int len = str.length();
        for(int i=0; i<len/2; i++){
            if(str.charAt(i)!=str.charAt(len-1-i)){
                return "NO";
            }
        }


//        <내가 짠 코드>
//        String answer = "";
//        str = str.toLowerCase();
//        int lt=0,rt=str.length()-1;
//        char[] x = str.toCharArray();
//        while (lt<rt){
//            if(x[lt]==x[rt]){
//                answer = "YES";
//                lt++;
//                rt--;
//            }
//            else{
//                return "NO";
//            }
//        }
        return answer;
    }

    public static void main(String[] args) {
        test7 T = new test7();
        Scanner in = new Scanner(System.in);
        String str = in.next();
        System.out.println(T.solution(str));

    }
}
