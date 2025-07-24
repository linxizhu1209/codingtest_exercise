
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        } // 점수 관련 배열
        // 한번에 한계단 또는 두계단 가능, 연속으로 한계단씩 3번 불가능
        // dfs로 한계단 가는 경우, 두계단 가는 경우
        // 마지막 계단은 무조건 포함

        int[] dp = new int[n]; // 누적 점수 관련 배열
        if(n==0) System.out.println(0);
        else if(n==1) System.out.println(arr[0]);
        else if(n==2) System.out.println(arr[0]+arr[1]);
        else if(n==3) System.out.println(Math.max(arr[0]+arr[2], arr[1]+arr[2]));
        else {
            dp[0] = arr[0];
            dp[1] = arr[0]+arr[1];
            dp[2] = Math.max(arr[0]+arr[2], arr[1]+arr[2]);
            for(int i=3; i<n; i++){
                dp[i] = Math.max(dp[i-2],dp[i-3]+arr[i-1]) + arr[i];
            }

            System.out.println(dp[n - 1]);
        }
    }
}
