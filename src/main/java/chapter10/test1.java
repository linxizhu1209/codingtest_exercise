package chapter10;

import java.util.Scanner;

public class test1 {
    static int[] dy;
    public int solution(int n){
        dy[1]=1;
        dy[2]=2;
        for(int i=3;i<=n;i++){
            dy[i]= dy[i-2]+dy[i-1];
        }
        return dy[n];
    }
    public static void main(String[] args){
        test1 T = new test1();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        dy=new int[n+1];
        System.out.println(T.solution(n));



    }


}



