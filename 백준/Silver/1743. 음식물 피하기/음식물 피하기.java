
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
        int food = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        for(int i=0;i<food;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a-1][b-1] = 1;
        }
        int max = Integer.MIN_VALUE;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]==1){
                    int count = 0;
                    q.add(new int[]{i,j});
                    arr[i][j] = 0;
                    while(!q.isEmpty()){
                        int[] cur = q.poll();
                        for(int k=0;k<4;k++){
                            int nx = cur[0]+dx[k];
                            int ny = cur[1]+dy[k];

                            if(nx>=0 && nx<n && ny>=0 && ny<m){
                                if(arr[nx][ny]==1){
                                    arr[nx][ny] = 0;
                                    q.offer(new int[]{nx,ny});
                                }
                            }

                        }
                        count++;
                    }
                    max = Math.max(max,count);


                }
            }
        }

        System.out.println(max);
    }
}