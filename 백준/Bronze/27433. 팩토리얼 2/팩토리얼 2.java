
import java.io.*;

public class Main {
    private static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        if(n==0) bw.write(1+"\n");
        else {
            Main t = new Main();
            bw.write(t.dfs(1) + "\n");
        }
        bw.close();
    }
    private long dfs(int D){
        if(D==n) return D;
        else return D*dfs(D+1);
    }
}
