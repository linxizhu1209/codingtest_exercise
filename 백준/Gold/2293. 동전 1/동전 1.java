
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(token.nextToken());
        int k = Integer.parseInt(token.nextToken());
        int[] coin = new int[n];
        int[] dy = new int[k+1];
        for(int i=0;i<n;i++){
            int c = Integer.parseInt(br.readLine());
            coin[i] = c;
        }
        dy[0] = 1;
        for(int i=0;i<n;i++){
            for(int j=coin[i];j<=k;j++){
                dy[j]+=dy[j-coin[i]];
            }
        }
        bw.write(dy[k]+"\n");
        bw.close();
    }
}
