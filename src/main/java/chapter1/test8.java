package chapter1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class test8 {
    public String solution(String str) {
//        <강의에서 배운 코드>
        String answer = "NO";
        str = str.toUpperCase().replaceAll("[^A-Z]", "");
        String tmp = new StringBuilder(str).reverse().toString();
        if (str.equals(tmp)) answer = "YES";
        return answer;

    }

//        <내가 작성한 코드>
//        String answer = "";
//        str = str.toLowerCase();
//        int lt=0,rt=str.length()-1;
//        char[] arr = str.toCharArray();
//        while (lt<rt){
//            if(arr[lt]==arr[rt]){
//                answer = "YES";
//                lt++;
//                rt--;
//            }
//            else if(!Character.isAlphabetic(arr[lt])){
//                lt++;
//            }
//            else if(!Character.isAlphabetic(arr[rt])){
//                rt--;
//            }
//            else{
//                return "NO";
//            }
//        }
//        return answer;
//    }

    public static void main(String[] args) {
        test8 T = new test8();
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        System.out.println(T.solution(input));

    }
}
