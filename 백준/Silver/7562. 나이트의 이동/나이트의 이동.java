import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class PointXY{
    int x;
    int y;

    public PointXY(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int[][] arr;
    static boolean[][] check;
    static int targetX;
    static int targetY;
    static int min;
    static int m;
    static int[] dx =  {-1,1,-1,1,2,2,-2,-2};
    static int[] dy = {2,2,-2,-2,-1,1,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Main t = new Main();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            min = Integer.MAX_VALUE;
            m = Integer.parseInt(br.readLine());
            arr = new int[m][m];
            check = new boolean[m][m];
            String[] str = br.readLine().split(" ");
            int startX = Integer.parseInt(str[0]);
            int startY = Integer.parseInt(str[1]);
            String[] str2 = br.readLine().split(" ");
            targetX = Integer.parseInt(str2[0]);
            targetY = Integer.parseInt(str2[1]);
            t.BFS(startX,startY); // 시작지점과 현재 이동횟수 넘겨주기
            sb.append(arr[targetX][targetY]).append("\n");
        }
        bw.write(sb.toString());
        bw.close();
    }
    public void BFS(int x,int y){
        Queue<PointXY> q = new LinkedList<>();
        q.offer(new PointXY(x,y));
        check[x][y] = true;
        while(!q.isEmpty()){
            PointXY point = q.poll();
            for(int i=0;i<8;i++){
             if(point.x+dx[i]>=0&&point.y+dy[i]>=0&&point.y+dy[i]<m&&point.x+dx[i]<m&&!check[point.x+dx[i]][point.y+dy[i]]){
                 q.offer(new PointXY(point.x+dx[i], point.y+dy[i]));
                 check[point.x+dx[i]][point.y+dy[i]] = true;
                 arr[point.x+dx[i]][point.y+dy[i]]=arr[point.x][point.y]+1; // 몇번째로 방문했는지 방문 순번을 체크배열에 기록
             }
            }
        }
    }
}
