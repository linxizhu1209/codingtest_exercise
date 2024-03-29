import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[] check;
    static int[] situation;

    public void DFS(int x) throws IOException {
        if(x==m){
            for(int i=0;i<m;i++) {
                System.out.print(situation[i]+" ");
            }
            System.out.println();
        } else{
            for(int i=1;i<=n;i++) {
                if (check[i]==0){
                    check[i]=1;
                    situation[x]=i;
                    DFS(x + 1);
                    check[i]=0;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        Main t = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());
        check = new int[n+1];
        situation = new int[m];
        t.DFS(0);
    }
}
