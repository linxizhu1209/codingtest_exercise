import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 문제 해결 방식 : 1인 곳을 찾아 해당 위치부터 가장 가까운 1의 거리를 찾는다. 이를 기록해두고, 그 중에서 가장 큰 값을 찾는다.
 * 2. 이때 거리는 상어가 위치한 곳을 포함하는 게 아니라 -1 해줘야한다. 즉, 도착하기 전의 칸까지 이다.
 * 3. 이차원 배열을 만들고, 8방향을 탐색할 수 있도록 dx,dy배열 만들고, 맨 처음에 이차원배열 입력받을때 맨 처음 1의 위치 받아놓고 거기부터 for문시작
 * 4. dfs로 방향하나씩 나가면서 1을 만나면 해당 L에서 break하고, 최소인지 확인. 계속 dfs를 반복할텐데, 시간초과 막기위해 만약 현 최소값보다 높아지면 break;
 * 5. 상어 마리수만큼 배열만들어놓기. 그래서 상어마리수만큼 for문 돌면서, 최소값찾고 이후에 그 배열에서 최대값 찾기
 */

class XY{
    int x;
    int y;

    public XY(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int[][] graph;
    static int n,m,min;
    static int[] shark; // 상어의 안전거리 최소값 저장
    static int[] dx,dy;
    static boolean[][] check;
    static Queue<XY> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token = new StringTokenizer(br.readLine());
        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());
        graph = new int[n][m];
        dx = new int[]{0,-1,0,1,1,1,-1,-1};
        dy = new int[]{-1,0,1,0,1,-1,1,-1};
        int count = 0;
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                int bbshark =  Integer.parseInt(st.nextToken());
                graph[i][j] = bbshark;
            }
        }
        shark= new int[count];
        int max = Integer.MIN_VALUE;
        Main t = new Main();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(graph[i][j]!=1) {
                    q = new LinkedList<>();
                    check = new boolean[n][m];
                    check[i][j] = true;
                    min = Integer.MAX_VALUE;
                    q.offer(new XY(i,j));
                    t.dfs(0);
                    max = Math.max(min, max);
                }
            }
        }

        bw.write(max+"\n");
        bw.close();
    }
    private int dfs(int L){
        boolean isFind = false;
        while(!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                XY xy = q.poll();
                for (int j = 0; j < 8; j++) {
                    int nx = xy.x + dx[j];
                    int ny = xy.y + dy[j];
                    if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                    if (!check[nx][ny] && graph[nx][ny] != 1) {
                        check[nx][ny] = true;
                        q.offer(new XY(nx, ny));
                    } else if (graph[nx][ny] == 1) {
                        min = Math.min(min, L + 1);
                        isFind = true;
                        break;
                    }
                }
                if(isFind) {
                    q.clear();
                    break;
                }
            }
            L++;
        }
        return min;
    }
}
