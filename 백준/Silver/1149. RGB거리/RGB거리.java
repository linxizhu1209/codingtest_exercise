
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] home = new int[n][3];
        int[][] dy = new int[n][3];
        for(int i=0;i<n;i++){
            StringTokenizer token = new StringTokenizer(br.readLine());
            Arrays.fill(dy[i],Integer.MAX_VALUE);
            for(int j=0;j<3;j++){
                home[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        dy[0][0] = home[0][0];
        dy[0][1] = home[0][1];
        dy[0][2] = home[0][2];

        for(int i=1;i<n;i++){
            for(int j=0;j<3;j++){
                for(int l=0;l<3;l++){
                    if(l!=j){
                        dy[i][j] = Math.min(dy[i-1][l]+home[i][j],dy[i][j]);
                    }
                }
            }
        }
        int min = Arrays.stream(dy[n-1]).min().getAsInt();
        bw.write(min+"\n");
        bw.close();
    }
}
