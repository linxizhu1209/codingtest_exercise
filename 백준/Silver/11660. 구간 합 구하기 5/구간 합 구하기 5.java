
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());
        int[][] arr = new int[n][n];
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++){
            token = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                arr[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        dp[0][0] = arr[0][0]; // //
        /**
         * 4 3
         * 1 2 3 4
         * 2 3 4 5
         * 3 4 5 6
         * 4 5 6 7
         * 2 2 3 4
         * 3 4 3 4
         * 1 1 4 4
         */


        for(int i=1;i<n;i++){
            dp[0][i] = dp[0][i-1] + arr[0][i];
        } // 가로로만 더하기

        for(int i=1;i<n;i++){
            dp[i][0] = dp[i-1][0] + arr[i][0];
        } // 가로로만 더하기

        for(int i=1;i<n;i++){
            for(int j=1;j<n;j++){
                dp[i][j] = dp[i][j-1] + dp[i-1][j] - dp[i-1][j-1] + arr[i][j];
            }
        }

        for(int i=0;i<m;i++){
            token = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(token.nextToken())-1;
            int y= Integer.parseInt(token.nextToken())-1;
            int x1 = Integer.parseInt(token.nextToken())-1;
            int y1 = Integer.parseInt(token.nextToken())-1;
            int sum = 0;

            sum+=dp[x1][y1];
            if(x-1>=0) {
                sum -= dp[x - 1][y1];
            }
            if(y-1>=0) {
                sum -= dp[x1][y - 1];
            }
            if(x-1>=0 && y-1>=0) {
                sum += dp[x - 1][y - 1];
            }

            System.out.println(sum);
        }


    }
}