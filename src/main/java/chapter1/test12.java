package chapter1;

import java.util.Arrays;
import java.util.Scanner;

public class test12 {
    public String solution(int n,String s){
        String answer = "";
        for(int i=0;i<n;i++){
            String tmp = s.substring(0,7).replace('#','1').replace('*','0');
            int num = Integer.parseInt(tmp,2);
            answer += (char)num;
            s=s.substring(7);
        }
        return answer;
    }


    /** 내가 구현한 코드- 정답 하나만 맞고 런타임 에러 발생 */
//    public String solution(int num, String s) {
//        String answer = "";
//        String[] arr = {"","","",""};
//        int x = 0;
//        for(int j=0;j<num;j++){
//            for(int i=x;i<x+7;i++){
//                arr[j] += s.charAt(i)=='#'? 1:0;
//            }
//            x= x+7;
//        }
//        for(String a: arr){
//            char[] charArr = a.toCharArray();
//            int n = 0;
//            int m = 0;
//            for(char b:charArr){
//                if(b=='1'){
//                    m += (int) Math.pow(2, 7 - n- 1);
//                }
//                n++;
//            }
//            answer += (char) m+"";
//            n=0;
//            m=0;
//        }
//        return answer;
//    }


    public static void main(String[] args) {
        test12 T = new test12();
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        String str = in.next();
        System.out.print(T.solution(num,str));

    }
}
