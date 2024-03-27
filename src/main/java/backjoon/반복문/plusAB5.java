package backjoon.반복문;


import java.util.Scanner;


public class plusAB5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int a= in.nextInt();
            int b= in.nextInt();
            if(a+b!=0) {
                System.out.println(a+b);
            }
        }
    }
}
