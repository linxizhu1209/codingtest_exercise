import java.io.*;
import java.util.*;

class zeldaXY implements Comparable<zeldaXY> {
    int x;
    int y;
    int cost;

    public zeldaXY(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }


    @Override
    public int compareTo(zeldaXY o) {
        if(this.cost==o.cost) return o.x-this.x;
        return this.cost-o.cost;
    }
}

public class Main {
    static int[][] graph;
    static int[][] costArr;
    static boolean[][] check;
    static int[] dx = {0,-1,0,1};
    static int[] dy = {-1,0,1,0};
    static int n,sum;
    static PriorityQueue<zeldaXY> pq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int idx = 1;
        String str = "";
        while((str=br.readLine())!=null){
            if(Integer.parseInt(str)==0) break;
            pq = new PriorityQueue<>();
            sum = 0;
            n = Integer.parseInt(str);
            graph = new int[n][n];
            costArr = new int[n][n];
            check = new boolean[n][n];
            for(int i=0;i<n;i++){
                Arrays.fill(costArr[i],Integer.MAX_VALUE);
            }
            for(int i=0;i<n;i++) {
                StringTokenizer token = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    graph[i][j] = Integer.parseInt(token.nextToken());
                }
            }
            Main t = new Main();
            costArr[0][0] = graph[0][0];
            check[0][0] = true;
            pq.offer(new zeldaXY(0,0,graph[0][0]));
            t.bfs();
            bw.write("Problem "+idx+": "+costArr[n-1][n-1]+"\n");
            idx++;
        }
        bw.close();
    }
    private void bfs(){
        while(!pq.isEmpty()) {
            zeldaXY zd = pq.poll();
            int x = zd.x;
            int y = zd.y;
            int cost = zd.cost;
            if(costArr[x][y]>costArr[n-1][n-1]) break;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < n && !check[nx][ny]) {
                    check[nx][ny]=true;
                    int nxCost = costArr[x][y] + graph[nx][ny];
                    if(nxCost<costArr[n-1][n-1]) {
                        pq.offer(new zeldaXY(nx, ny, nxCost)); // 우선순위큐에 좌표값과 비용을 넣어서 비용이 가장 작은 것부터 나오게함
                        costArr[nx][ny] = Math.min(costArr[nx][ny], nxCost); // costArr의 원래 값과 비교하는 로직 필요하며, 초기화해놔야함 =
                    }
                }
            }
        }
    }
}
