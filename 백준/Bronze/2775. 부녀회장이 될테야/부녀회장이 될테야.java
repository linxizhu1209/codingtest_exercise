import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for(int i = 0; i < tc; i++) {
            int k = Integer.parseInt(br.readLine()); // 몇층
            int n = Integer.parseInt(br.readLine()); // 호수
            dp = new int[k+1][n+1];
            dp[0][1] = 1;
            for(int j=1;j<=n;j++){
                dp[0][j] = j;
            }

            int x = comb(k,n);
            System.out.println(x);

        }
    }

    static private int comb(int x, int y){
        if(y==1) return 1;
        if(x==0) return dp[0][y];
        if(dp[x][y]!=0) return dp[x][y];
        return dp[x][y] = comb(x-1,y) + comb(x,y-1);
    }
 }
