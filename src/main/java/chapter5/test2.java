package chapter5;


import java.util.Scanner;
import java.util.Stack;

public class test2 {
    public String solution(String str){
        // 강의 참고 코드
        String answer="";
        Stack<Character> stack = new Stack<>();
        for(char x:str.toCharArray()){
            if(x==')'){
                while(stack.pop()!='('){
//                    pop()메서드는 꺼낸 것을 리턴해줌
                    stack.pop();
                }
            }
            else{
                stack.push(x);
            }
        }
        for(int i=0;i<stack.size();i++) answer+=stack.get(i);

        // 내가 짠 코드
//        int n1=0;
//        String answer ="";
//        for(char x: str.toCharArray()){
//        if(x=='(') n1++;
//        else if(n1==0&&x!='('&&x!=')') answer+=x;
//        else if(x==')') n1--;
//        }
        return answer;
    }



    public static void main(String[] args) {
        test2 T = new test2();
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.print(T.solution(str));
    }
}

