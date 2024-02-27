package chapter1;

import java.util.Scanner;

public class test11 {
    public String solution(String s){
        String answer="";
        s=s+" "; // for문에서 i와 i+1을 비교할때 index out of range를 막기위해 빈칸추가
        int cnt = 1;
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)==s.charAt(i+1)) cnt++;
            else{
                answer += s.charAt(i);
                if(cnt>1)answer+=String.valueOf(cnt);
                cnt=1;
            }
        }
        return answer;
    }

    /** 내가 구현한 코드 */
//    public String solution(String s) {
//        String answer = "";
//        int count = 0;
//        char t = ' ';
//        for(char x: s.toCharArray()){
//            if(x!=t) {
//                if(count!=0&&count!=1) {
//                    answer += count;
//                }
//                count=0;
//                t=x;
//                count++;
//                answer+=t;
//            }
//            else{
//                count++;
//            }
//        }
//        if(count!=0&&count!=1){
//            answer+=count;
//        }
//        return answer;
//    }


    public static void main(String[] args) {
        test11 T = new test11();
        Scanner in = new Scanner(System.in);
        String str = in.next();
        System.out.print(T.solution(str));

    }
}
