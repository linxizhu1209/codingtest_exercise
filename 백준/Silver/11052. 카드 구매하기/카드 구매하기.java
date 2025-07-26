import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int max;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        StringTokenizer token = new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++){
            arr[i] = Integer.parseInt(token.nextToken());
        }
        max = Integer.MIN_VALUE;
        int[] dp = new int[n+1];
        for(int i=1;i<=n;i++){
            dp[i] = arr[i];
            for(int j=1;j<=i;j++){
                dp[i] = Math.max(dp[i],dp[j]+dp[i-j]);
            }
        }

        System.out.println(dp[n]);
    }

 }
