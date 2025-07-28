import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for(int i=0;i<tc;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            // 조합 => m-1Cn-1 + m-1Cn
            dp = new int[31][31];
            System.out.println(comb(m,n));
        }
    }
    static int comb(int m, int n){
        
        if(n==0 || m==n) return 1;
        if(dp[m][n]!=0) return dp[m][n];
        return dp[m][n] = comb(m-1,n-1) + comb(m-1,n);
    }
 }
