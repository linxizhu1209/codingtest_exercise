package chapter5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class test7 {
    // 강의 참고 코드
    public String solution(String str1, String str2) {
        String answer = "YES";
        Queue<Character> q = new LinkedList<>(); // queue 는 linkedList로 선언
        for(int i=0;i<str1.length();i++) { //
            q.offer(str1.charAt(i));
        }
        for(int i=0;i<str2.length();i++) {
            if(q.contains(str2.charAt(i))){
                if(str2.charAt(i)!=q.peek()) return "NO";
                else q.poll();
            }
        }
        if(!q.isEmpty()) return "NO";
        return answer;
    }


    public static void main(String[] args) {
        test7 T = new test7();
        Scanner in = new Scanner(System.in);
        String str1 = in.nextLine();
        String str2 = in.nextLine();
        System.out.print(T.solution(str1,str2));
    }
}

