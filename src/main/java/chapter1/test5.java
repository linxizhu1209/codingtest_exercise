package chapter1;

import java.util.Scanner;

public class test5 {
    public String solution(String str) {

        char[] x = str.toCharArray();
        int lt = 0, rt=str.length()-1;
        while(lt<rt) {
            if (!Character.isAlphabetic(x[rt])) {
                rt--;
            }
            else if(!Character.isAlphabetic(x[lt])){
                lt++;
            }
            else{
                char tmp = x[lt];
                x[lt] = x[rt];
                x[rt] = tmp;
                lt++;
                rt--;
            }
        }
        return String.valueOf(x);
    }
    public static void main(String[] args) {
        test5 T = new test5();
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.println(T.solution(str));
        }
    }

