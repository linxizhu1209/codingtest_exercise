package backjoon.과제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class nAndM2 {
    static int n;
    static int m;
    static int[] check;
    static int[] assemble;
    public void DFS(int L,int s){
        if(L==m){
            for(int i=0;i<m;i++) {
                System.out.print(assemble[i]+" ");
            }
            System.out.println();
        } else{
            for(int i=s;i<=n;i++) {
                if (check[i]==0){
                    check[i]=1;
                    assemble[L]=i;
                    DFS(L + 1,i+1);
                    check[i]=0;
                }
            }
        }

    }
    public static void main(String[] args) throws IOException {
        nAndM2 t = new nAndM2();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());
        check = new int[n+1];
        assemble = new int[m];
        t.DFS(0,1);
    }
}
