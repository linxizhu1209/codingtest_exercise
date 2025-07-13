
import java.io.*;
import java.util.*;

public class Main {
    /**
     * 1. (1.1) -> (n,m) 까지 최소의 칸 수
     */
    static int n;
    static int m;
    static int[][] dp;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(in.readLine());
        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());
        arr = new int[n][m];
        for(int i = 0; i < n; i++) {
            String str = in.readLine();
            for(int j = 0; j < m; j++) {
                arr[i][j] = str.charAt(j)-'0';
            }
        }
        dp = new int[n][m];
        visited = new boolean[n][m];
        pos(0,0);
        System.out.println(dp[n-1][m-1]);
    }

    public static void pos(int i, int j) {

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i,j});
        visited[i][j] = true;
        dp[i][j] = 1;
        while(!q.isEmpty()) {
            int[] qarr = q.poll();
            int x = qarr[0];
            int y = qarr[1];

            for(int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if(nx>=0 && nx<n && ny>=0 && ny<m) {
                    if(arr[nx][ny] == 1 && !visited[nx][ny]) {
                        q.offer(new int[]{nx,ny});
                        dp[nx][ny] = dp[x][y]+1;
                        visited[nx][ny] = true;
                    }
                }
            }

        }


    }

}