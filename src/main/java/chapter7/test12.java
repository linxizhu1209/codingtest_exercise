package chapter7;

import java.util.Scanner;

public class test12 {
    static int n, m, answer = 0;
    static int[][] graph;
    static int[] ch;
    public void DFS(int v){
        if(v==n) answer++;
        else{
            for(int i=1; i<=n;i++){
                if(graph[v][i]==1 && ch[i]==0){ // 행을 돌면서 둘이 이어진 경로인지 확인 (이어진 경로이면 graph의 값이 1)
                    ch[i]=1;
                    DFS(i);
                    ch[i]=0;
                }
            }
        }
    }

    public static void main(String[] args){
        test12 T = new test12();
        Scanner in = new Scanner(System.in);
        n= in.nextInt();
        m= in.nextInt();
        graph=new int[n+1][n+1];
        ch=new int[n+1];
        for(int i=0;i<m;i++){
            int a=in.nextInt();
            int b=in.nextInt();
            graph[a][b]=1;
        }
        ch[1] = 1;
        T.DFS(1);
        System.out.println(answer);

    }
}
