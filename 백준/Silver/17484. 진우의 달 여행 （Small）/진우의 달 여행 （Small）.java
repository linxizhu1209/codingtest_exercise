
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {
    /**
     * 1. n*m 행렬 - 지구와 우주 사이
     * 2. 각 행렬 칸에는 그 공간을 지날 때 소모되는 연료의 양
     * 3. 지구 -> 달로 가는 우주선은 아래쪽으로만 이동 가능 (대각선 가능)
     * 4. 같은 방향으로 두번 연속 움직일 수 없음. 즉, 왼대각선 갔으면 그다음은 왼대각선 못감
     * 5. 최소값 구하기
     */

    static int[][] arr;
    static int n;
    static int m;
    static int min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());
        arr = new int[n][m];

        for(int i=0;i<n;i++){
            token = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                arr[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        // 깊이가 m이 될때 break; dfs 로 풀고싶은데,
        int dept = 0 ;
        int[] pos = new int[3]; // 왼대, 아래, 오대
        // 근데 맨처음 시작점을 뭘로 잡을지는 열기준 for문
        min = Integer.MAX_VALUE;
        for(int i=0;i<m;i++) {
            dfs(0, i, dept, pos);
        }
        System.out.println(min);
    }

    public static void dfs(int sum, int start, int dept, int[] pos){
        if(dept == n) {
            min = Math.min(min,sum);
            return;
        }
        int a = arr[dept][start];
        sum += a;
        for(int i=0;i<3;i++){
            if(pos[i]==0){
                if(i==0) {
                    // 원래 pos는 유지하고 새로운 pos2 를 만들어서 넣어줘야함
                    // 여기서 다 초기화 하면 안되고, i를 제외한
                    int[] pos2 = new int[3];
                    pos2[i] = 1;
                    if(start-1 >= 0) dfs(sum, start-1, dept + 1, pos2); // start가 m과0을 넘지않게해야함
                }
                if(i==1){
                    int[] pos2 = new int[3];
                    pos2[i] = 1;
                    dfs(sum, start, dept + 1, pos2); // start가 m과0을 넘지않게해야함
                }
                if(i==2){
                    int[] pos2 = new int[3];
                    pos2[i] = 1;
                    if(start+1 < m) dfs(sum, start+1, dept + 1, pos2); // start가 m과0을 넘지않게해야함
                }
            }
        }

    }
}