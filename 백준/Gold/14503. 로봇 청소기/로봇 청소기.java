
import java.io.*;
import java.util.*;

public class Main {
    /**
     * 1. 각 칸은 빈칸 또는 벽
     * 2. 동,서,남,북으로만 이동
     * 3. d가 주어지는데 0 -> 북, 1-> 동, 2-> 남, 3->서
     */
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());
        token = new StringTokenizer(in.readLine());
        int[][] arr = new int[n][m];
        int[] pos = new int[2];
        pos[0] = Integer.parseInt(token.nextToken());
        pos[1] = Integer.parseInt(token.nextToken()); // 로청 위치
        int dir = Integer.parseInt(token.nextToken()); // 방향

        for(int i=0;i<n;i++){
            token = new StringTokenizer(in.readLine());
            for(int j=0;j<m;j++){
                arr[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        int[] dx = new int[]{-1,1,0,0};
        int[] dy = new int[]{0,0,-1,1};
        int count = 0;
        boolean isFinish = false;
        boolean[][] visited  = new boolean[n][m];
//        q.add(new int[]{pos[0],pos[1]});
        while(!isFinish){
            if(arr[pos[0]][pos[1]] == 0 && !visited[pos[0]][pos[1]]){
                // 1. 현재 위치 청소
                count++;
                visited[pos[0]][pos[1]] = true;
            }
            boolean isClean = true;
            for(int i=0;i<4;i++){
                int nx = pos[0] + dx[i];
                int ny = pos[1] + dy[i];
                if(arr[nx][ny] == 0 && !visited[nx][ny]){
                    isClean = false;
                }
            }
            if(isClean){
                int x = pos[0];
                int y = pos[1];
                // 2. 4방향이 다 깨끗한 경우
                if(dir==0){ // 북쪽
                    // 남쪽으로 후진, 행 +1
                    pos[0] += 1;
                    if(x+1>=n || arr[x+1][y] == 1 ){
                        isFinish = true;
                        break;
                    }
                } else if(dir==1){ // 동쪽
                    // 서쪽으로 후진, 열 -1
                    pos[1] -= 1;
                    if(y-1<0 || arr[x][y-1] == 1){
                        isFinish = true;
                        break;
                    }
                } else if(dir==2){ // 남쪽
                    // 북쪽으로 후진, 행 -1
                    pos[0] -= 1;
                    if(x-1< 0 || arr[x-1][y] == 1){
                        isFinish = true;
                        break;
                    }
                } else { // 서쪽
                    // 동쪽으로 후진, 열 +1
                    pos[1] += 1;
                    if(y+1>=m || arr[x][y+1] == 1){
                        isFinish = true;
                        break;
                    }
                }
            } else {
                // 3. 주변 4칸 중 빈칸이 있는 경우
                // 현재 방향 dir 에서 반시계 방향으로

                while(true) {
                    if (dir == 0) {
                        dir = 3;
                        if(pos[1]-1>=0 && arr[pos[0]][pos[1]-1] == 0 && !visited[pos[0]][pos[1]-1]){
                            pos[1] -= 1;
                            break;
                        }
                    } else if(dir == 1) {
                        dir -= 1;
                        if(pos[0]-1>=0 && arr[pos[0]-1][pos[1]] == 0 && !visited[pos[0]-1][pos[1]]){
                            pos[0] -= 1;
                            break;
                        }
                    } else if(dir == 2) {
                        dir -= 1;
                        if(pos[1]+1<m && arr[pos[0]][pos[1]+1] == 0 && !visited[pos[0]][pos[1]+1]){
                            pos[1] += 1;
                            break;
                        }
                    } else {
                        dir -= 1;
                        if(pos[0]+1<n && arr[pos[0]+1][pos[1]] == 0 && !visited[pos[0]+1][pos[1]]){
                            pos[0] += 1;
                            break;
                        }
                    }
                }
            }
            if(isFinish){
                break;
            }

        }
        System.out.println(count);
    }

}