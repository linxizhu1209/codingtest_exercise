package chapter5;


import java.util.Scanner;
import java.util.Stack;

public class test1 {
    // 강의 참고 코드
    public String solution(String str){
        String answer = "YES";
        Stack<Character> stack = new Stack<>();
        for(char x:str.toCharArray()){
            if(x=='(') stack.push(x);
            else{
                if(stack.isEmpty()) return "NO";
                else{
                    stack.pop();
                }
            }
        }
        if(!stack.isEmpty()) answer="NO";
        return answer;

        //내가 짠 코드
//        int n1=0 ,n2=0;
//        for(char x: str.toCharArray()){
//        if(x=='(') n1++;
//        else n1--;
//        if(n1<0) return "NO";
//        }
//        String answer = n1==n2? "YES":"NO";
    }



    public static void main(String[] args) {
        test1 T = new test1();
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.print(T.solution(str));
    }
}

