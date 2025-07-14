import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int[][] arr = new int[n][n];

        for(int i=0;i<n;i++){
            String str = in.readLine();
            for(int j=0;j<n;j++){
                arr[i][j] = str.charAt(j)-'0';
            }
        }
        List<Integer> list = new ArrayList<>();
        int[] dx = new int[]{-1,1,0,0};
        int[] dy = new int[]{0,0,-1,1};
        // bfs로 풀어보기
        Queue<int[]> q = new LinkedList<>();
        int total = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]==1){
                    int count = 0; // 인접한 가구 수 세기
                    q.add(new int[]{i,j});
                    arr[i][j]=0; // 방문한 집은 없애버리기
                    count++;
                    total++;
                    while(!q.isEmpty()){
                        int[] house = q.poll();
                        int x = house[0],y = house[1];
                        for(int p=0;p<4;p++){
                            int nx = x+dx[p];
                            int ny = y+dy[p];
                            if(nx>=0&&ny>=0&&nx<n&&ny<n){
                                if(arr[nx][ny]==1){
                                    q.add(new int[]{nx,ny});
                                    arr[nx][ny]=0;
                                    count++;
                                }
                            }
                        }
                    }
                    list.add(count);
                }
            }
        }
        System.out.println(total);
        Collections.sort(list);
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }

}