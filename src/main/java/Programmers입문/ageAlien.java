package Programmers입문;

import java.util.Scanner;

public class ageAlien {
    public String solution(int age){
        // 내가 짠 코드
//        String answer = "";
//        String strAge = String.valueOf(age);
//        for(char x:strAge.toCharArray()){
//            if(x=='0') answer+="a";
//            else if(x=='1') answer+="b";
//            else if(x=='2') answer+="c";
//            else if(x=='3') answer+="d";
//            else if(x=='4') answer+="e";
//            else if(x=='5') answer+="f";
//            else if(x=='6') answer+="g";
//            else if(x=='7') answer+="h";
//            else if(x=='8') answer+="i";
//            else if(x=='9') answer+="j";
//        }
//
        //다른 사람의 풀이 참고
        StringBuilder sb = new StringBuilder();
        while(age>0) {
            sb.insert(0, (char)((age % 10) + (int) 'a'));
            age/=10;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        ageAlien t = new ageAlien();
        Scanner in = new Scanner(System.in);
        int age = in.nextByte();
        System.out.println(t.solution(age));
    }
}
