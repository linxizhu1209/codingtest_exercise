package chapter5;


import java.util.Scanner;
import java.util.Stack;

public class test4 {
    // 강의 참고하여 짠 코드
    public int solution(String str){
        int answer = 0;
        int rt=0;
        int lt=0;
        Stack<Integer> stack = new Stack<>();
        for(char x:str.toCharArray()){
            if(Character.isDigit(x)){
                stack.push(x-48);
            }
            else{
                rt = stack.pop();
                lt = stack.pop();
                if(x=='+'){
                    stack.push(lt+rt);
                }
                else if(x=='-'){
                    stack.push(lt-rt);
                } else if (x == '*') {
                    stack.push(lt*rt);
                }
                else{
                    stack.push(lt/rt);
                }
            }
        }
        answer = stack.firstElement();


        return answer;
    }



    public static void main(String[] args) {
        test4 T = new test4();
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        System.out.print(T.solution(str));
    }
}

