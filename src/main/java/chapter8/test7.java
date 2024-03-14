package chapter8;

import java.util.Scanner;

public class test7 {
    int[][] dy = new int[35][35];
    public int DFS(int n, int r){
        if(dy[n][r]>0) return dy[n][r];
        if(n==r || r==0) return 1;
        else return dy[n][r] = DFS(n-1,r-1)+DFS(n-1,r);
    }
    public static void main(String[] args){

        test7 T = new test7();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int r = in.nextInt();
        System.out.println(T.DFS(n,r));

    }


}
