
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] dx = {1,0,1};
        int[] dy = {0,1,1};
        // 아래쪽, 오른쪽, 대각선으로 이동 가능
        // dp[n-1][m-1] 의 최대값 반환
        int[][] dp = new int[n][m];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }
        dp[0][0] = arr[0][0];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        while(!q.isEmpty()) {
            int[] cur = q.poll();;
            for(int i = 0; i < 3; i++) {
                int nx= cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if(nx < n && ny < m) {
                    int max = Math.max(dp[cur[0]][cur[1]] + arr[nx][ny], dp[nx][ny]);
                    if (max > dp[nx][ny]) {
                        q.offer(new int[]{nx, ny});
                        dp[nx][ny] = max;
                    }
                }
            }
        }
        System.out.println(dp[n-1][m-1]);
    }

 }
