package chapter8;

import java.util.Scanner;

public class test3 {
    /**
     * test1을 참고하여 내가 짠 코드
     */
    static int answer = 0;
    static int n,m = 0;

    public void DFS(int L,int sumMin, int total, int[][] arr) {
        if(sumMin>m) return;
        if(L==n){
            if(m>=sumMin){
                answer = Math.max(total,answer);
            }
        }
        else{
            DFS(L+1,sumMin+arr[L][1],total+arr[L][0],arr); //arr[L]을 포함한 경우
            DFS(L+1,sumMin,total,arr); // arr[L]을 포함하지 않은 경우
            }
        }



    public static void main(String[] args) {
        test3 T = new test3();
        Scanner in = new Scanner(System.in);
        n= in.nextInt();
        m= in.nextInt();
        int[][] arr = new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0]=in.nextInt();
            arr[i][1]=in.nextInt();
        }
        T.DFS(0,0, 0,arr);
        System.out.println(answer);
    }
}

