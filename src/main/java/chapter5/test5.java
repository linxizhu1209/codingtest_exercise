package chapter5;

import java.util.Scanner;
import java.util.Stack;


public class test5 {
    // 강의 참고 코드
    public int solution(String str) {
// ex: ()(((()())(())()))(())
        // (((()(()()))(())()))(()()) 3+4+4+1+1+4+3+2+2+1
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') stack.push(str.charAt(i));
            else if (str.charAt(i) == ')' && str.charAt(i-1) == '(') {
                stack.pop();
                answer += stack.size();
            } else if (str.charAt(i) == ')' && str.charAt(i - 1) != '(') {
                stack.pop();
                answer += 1;
            }
        }
        return answer;

    }


    public static void main(String[] args) {
        test5 T = new test5();
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        System.out.print(T.solution(str));
    }
}

