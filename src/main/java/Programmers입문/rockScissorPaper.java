package Programmers입문;

import java.util.Scanner;

public class rockScissorPaper {
    public String solution(String rsp){
        /**
         * 가위 = 2 , 바위 = 0, 보 = 5
         */
        String answer = "";
        for(char x:rsp.toCharArray()) {
            if (x=='2') answer += "0";
            else if(x=='0') answer+="5";
            else answer+="2";
        }
        return answer;
    }

    public static void main(String[] args) {
        rockScissorPaper t = new rockScissorPaper();
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.println(t.solution(str));
    }

}
