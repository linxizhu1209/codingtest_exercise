
import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> list;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dx = {-1,1,0,0,-1,1,-1,1};
        int[] dy = {0,0,-1,1,-1,1,1,-1};
        while (true){
            StringTokenizer token = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(token.nextToken());
            int w = Integer.parseInt(token.nextToken());
            if(w==0 && h==0){
                break;
            }

            int[][] arr = new int[w][h];

            Queue<int[]> q = new LinkedList<>();
            for(int i=0;i<w;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0;j<h;j++){
                    int x = Integer.parseInt(st.nextToken());
                    arr[i][j] = x;
                }
            }
            int count = 0;
            for(int i=0;i<w;i++){
                for(int j=0;j<h;j++){
                    if(arr[i][j]==1){
                        q.offer(new int[]{i,j});
                        arr[i][j] = 0;
                        while(!q.isEmpty()){
                            int[] cur = q.poll();
                            for(int k=0;k<8;k++){
                                int nx = cur[0]+dx[k];
                                int ny = cur[1]+dy[k];
                                if(nx>=0 && nx<w && ny>=0 && ny<h){
                                    if(arr[nx][ny]==1){
                                        q.add(new int[]{nx,ny});
                                        arr[nx][ny] = 0;
                                    }
                                }
                            }
                        }
                        count++;

                    }
                }
            }
            System.out.println(count);
        }
    }
}