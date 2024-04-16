
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int test = Integer.parseInt(br.readLine());
        for(int i=0;i<test;i++){
            int n = Integer.parseInt(br.readLine());
            int[][] sticker = new int[2][n];
            for(int j=0;j<2;j++){
                StringTokenizer token = new StringTokenizer(br.readLine());
                for(int l=0;l<n;l++){
                    sticker[j][l] = Integer.parseInt(token.nextToken());
                }
            }
            int[][] dis = new int[2][n];
            dis[0][0] = sticker[0][0];
            dis[1][0] = sticker[1][0];
            int max = 0;
            if(n==1) bw.write(Math.max(dis[0][0],dis[1][0])+"\n"); // 만약 스티커가 세로로 한줄밖에 없다면, for문을 돌지못하기에 max가 구해질 수 없으므로,,,,
            else {
                for (int j = 1; j < n; j++) {
                    if (j == 1) {
                        dis[0][j] = dis[1][j - 1] + sticker[0][j];
                        dis[1][j] = dis[0][j - 1] + sticker[1][j];
                        max = Math.max(dis[0][j],dis[1][j]);
                    } else {
                        int up = Math.max(dis[1][j - 1], dis[1][j - 2]) + sticker[0][j];
                        int down = Math.max(dis[0][j - 1], dis[0][j - 2]) + sticker[1][j];
                        dis[0][j] = up; // 내 왼쪽 대각선에 있는 스티커점수합계와, 왼쪽 대각선의 그 왼쪽에 있는 스티커점수합계를 비교하여 더 큰 숫자를 가져온다
                        dis[1][j] = down;
                        max = Math.max(up, down);
                    }
                }
                bw.write(max + "\n");
            }
        }
        bw.close();
    }
}
