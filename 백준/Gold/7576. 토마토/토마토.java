
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(token.nextToken());
        int n = Integer.parseInt(token.nextToken());
        int[][] tomato = new int[n][m];
        int[][] days = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine());
            Arrays.fill(days[i], Integer.MAX_VALUE);
            for(int j = 0; j < m; j++) {
                int x = Integer.parseInt(token.nextToken());
                tomato[i][j] = x;
                if(x == 1 || x== -1) days[i][j] = x;
                if(x==1) q.add(new int[]{i, j});
            }
        }
        int count = Integer.MIN_VALUE;
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            for(int h=0; h<4; h++) {
                int nx = x + dx[h];
                int ny = y + dy[h];
                if(nx>=0 && ny>=0 && nx<n && ny<m && (tomato[nx][ny]==0 && days[x][y]+1<days[nx][ny])) {
                    days[nx][ny] = Math.min(days[x][y]+1,days[nx][ny]);
                    q.add(new int[]{nx,ny});
                }
            }
        }


        boolean isFinish = true;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(days[i][j]==Integer.MAX_VALUE) {
                    isFinish = false;
                } else {
                    if(days[i][j]!=Integer.MAX_VALUE) {
                        count = Math.max(count, days[i][j]);
                    }
                }
            }
            if(!isFinish) break;
        }

        if(!isFinish) {
            System.out.println(-1);
        }
        else System.out.println(count-1);


    }
 }
