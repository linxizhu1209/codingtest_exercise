
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            for(int j = 0; j < m; j++) {
                char x = str.charAt(j);
                if(x=='O') arr[i][j] = 0;
                else if(x=='P') arr[i][j] = 1;
                else if(x=='I') q.add(new int[]{i,j});
                else arr[i][j] = 2;
            }
        }
        int count = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for(int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if(nx>=0 && ny>=0 && nx<n && ny<m) {
                    if(arr[nx][ny]==0) {
                        q.add(new int[]{nx,ny});
                        arr[nx][ny] = 2;
                    } else if(arr[nx][ny]==1) {
                        arr[nx][ny] = 2;
                        q.add(new int[]{nx,ny});
                        count++;
                    }
                }
            }
        }
        if(count==0) {
            System.out.println("TT");
        } else {
            System.out.println(count);
        }
    }
}