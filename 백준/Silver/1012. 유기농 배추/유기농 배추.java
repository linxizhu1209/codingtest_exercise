
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int bachu = Integer.parseInt(st.nextToken());
            int[][] arr = new int[n][m];
            for (int j = 0; j < bachu; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[y][x] = 1;
            }
            int count = 0;
            Queue<int[]> q = new LinkedList<>();
            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (arr[j][k] == 1) {
                        arr[j][k] = 0;
                        count++;
                        q.offer(new int[]{j, k});

                        while (!q.isEmpty()) {
                            int[] cur = q.poll();
                            for (int l = 0; l < 4; l++) {
                                int nx = cur[0] + dx[l];
                                int ny = cur[1] + dy[l];
                                if (nx>=0 && ny>=0 && nx<n && ny<m && arr[nx][ny] == 1) {
                                    arr[nx][ny] = 0;
                                    q.add(new int[]{nx, ny});
                                }
                            }
                        }
                    }
                }
            }
            System.out.println(count);
        }
    }
 }
