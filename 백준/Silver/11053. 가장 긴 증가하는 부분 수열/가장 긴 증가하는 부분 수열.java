
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 10 20 10 30 20 50
        // 3 2 3 2 2 1/ 뒤에서 부터 for문 돌면서, 자기보다 작은 애가 있으면 걔의  나의 수 + 1 (최초의 수는 1)
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        if(n==0) System.out.println(0);
        else if(n==1) System.out.println(1);
        else {
            dp[n - 1] = 1;
            int max = 1;
            for (int i = n - 1; i >= 1; i--) {
                int x = arr[i];
                for (int j = i - 1; j >= 0; j--) {
                    int y = arr[j];
                    if (x > y) {
                        dp[j] = Math.max(dp[i] + 1, dp[j]);
                        max = Math.max(max, dp[j]);
                    }
                }
            }

            System.out.println(max);
        } // 9 4 2 8 9 3
        // 0 2 2 1 0 1
        }
 }
