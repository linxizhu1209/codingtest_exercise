package chapter8;

import java.util.Scanner;

public class test2 {
    /**
     * test1을 참고하여 내가 짠 코드
     */
    static int answer = 0;
    static int n,m = 0;

    public void DFS(int L,int sum, int[] arr) {
        if(n<sum) return;
        if(L==m){
            if(n>=sum){
                answer = Math.max(sum,answer);
            }
        }
        else{
            DFS(L+1,sum+arr[L],arr); //arr[L]을 포함한 경우
            DFS(L+1,sum,arr); // arr[L]을 포함하지 않은 경우
            }
        }



    public static void main(String[] args) {
        test2 T = new test2();
        Scanner in = new Scanner(System.in);
        n= in.nextInt();
        m= in.nextInt();
        int[] arr = new int[m];
        for(int i=0;i<m;i++){
            arr[i]=in.nextInt();
        }
        T.DFS(0,0,arr);
        System.out.println(answer);
    }
}

