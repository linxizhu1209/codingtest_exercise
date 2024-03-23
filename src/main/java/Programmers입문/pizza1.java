package Programmers입문;

import java.util.Scanner;

public class pizza1 {

    public int solution(int n){

        if(n%7==0) return n/7;
        return n/7!=0?n/7+1:1;
//        return (n%7==0)? n/7 : n/7+1;

    }

    public static void main(String[] args) {
        pizza1 t = new pizza1();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(t.solution(n));
    }

}
