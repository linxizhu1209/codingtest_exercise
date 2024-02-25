package chapter1;

import java.util.Scanner;

public class test9 {
    /** 강의 예시코드 */
//    public int solution(String str) {
//        int answer = 0;
//        for(char x:str.toCharArray()){
//            if(x>=48 && x<=57) answer = answer*10+(x-48);
//        }
//        return answer;
//
//    }

    /** 내가 구현한 코드 */
    public int solution(String str){
        String answer = "";
        char[] arr = str.toCharArray();
        for(char x: arr) {
            if(Character.isDigit(x)) answer += x;
        }


//        while(answer.startsWith("0")){
//            answer=answer.substring(1);
//        } Integer.parseInt로 int값으로 바꿔주면, 맨앞이 0인지 검증할 필요없이 0이 생략됨

        return Integer.parseInt(answer);
    }

    public static void main(String[] args) {
        test9 T = new test9();
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        System.out.println(T.solution(input));

    }
}
