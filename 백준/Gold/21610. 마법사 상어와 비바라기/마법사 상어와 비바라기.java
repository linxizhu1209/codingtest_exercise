import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Cloud{
    int x;
    int y;

    public Cloud(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    private static int[][] graph;
    private static boolean[][] check;
    private static int[] dx,dy;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());
        dx = new int[]{0,-1,-1,-1,0,1,1,1};
        dy = new int[]{-1,-1,0,1,1,1,0,-1};
        graph = new int[n][n];
        for(int i=0;i<n;i++){
            StringTokenizer token1 = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                graph[i][j] = Integer.parseInt(token1.nextToken());
            }
        } // 그래프 만들기.
        Queue<Cloud> q = new LinkedList<>();
        q.add(new Cloud(n-1,0));
        q.add(new Cloud(n-1,1));
        q.add(new Cloud(n-2,0));
        q.add(new Cloud(n-2,1));
        for(int i=0;i<m;i++){
            StringTokenizer token2 = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(token2.nextToken())-1; // dx,dy의 인덱스는 0부터 시작하기때문에 -1을 해준다
            int s = Integer.parseInt(token2.nextToken());
            check = new boolean[n][n]; // 현재 단계에서 구름의 위치를 체크해야하므로 매 단계마다 초기화
            // 스택의 사이즈만큼 반복하면서 각각의 객체 좌표를 해당 방향으로 s만큼이동할건데, 이동한 후의 좌표를 다시 스택에 넣을 것이므로
            // 사이즈를 미리 재놓고, 그 만큼 for문으로 반복
            int size = q.size();
            for(int j=0;j<size;j++){
                Cloud cloud = q.poll();
                int nx = (n + cloud.x + dx[d] * (s % n)) % n;
                int ny = (n + cloud.y + dy[d] * (s % n)) % n;
                q.add(new Cloud(nx, ny)); // 새로 이동한 곳 스택에 넣어줌
                graph[nx][ny]++; // 새로 이동한 곳의 물양 +1
            }
            // 대각선 방향 체크 (dx,dy의 인덱스 1,3,5,7을 돌면됨)
            int size2 = q.size();
            for(int j=0;j<size2;j++){
                Cloud cloud = q.poll();
                int count = 0;
                check[cloud.x][cloud.y]=true;
                for(int c=1;c<8;c+=2){
                    int nx = cloud.x+dx[c];
                    int ny = cloud.y+dy[c];
                    if(nx<0||ny<0||nx>=n||ny>=n) continue;
                    if(graph[nx][ny]>0) count++;
                }
                graph[cloud.x][cloud.y]+=count;

            }
            // 다시 스택에 구름을 넣어주는 작업 ==> 물의양이 2이상인 모든 칸에 구름이 생기고 물의 양을 -2
            // 다만 이때 전에 stack에 들어있었던 좌표의 경우엔 구름이 생성되지 않는다.
            for(int a=0;a<n;a++){
                for(int b=0;b<n;b++){
                    if(graph[a][b]>=2&&!check[a][b]) {
                        q.add(new Cloud(a,b));
                        graph[a][b]-=2;
                    }
                }
            }

        }
        int sum = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                sum+= graph[i][j];
            }
        }
        System.out.println(sum);
    }
}
