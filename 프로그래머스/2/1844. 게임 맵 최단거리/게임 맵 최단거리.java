import java.util.LinkedList;
import java.util.Queue;
class GameMapNode{
    int x;
    int y;

    public GameMapNode(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class Solution {
    public int solution(int[][] maps) {
         int r = maps.length;
        int c = maps[0].length;
        int[] dx = {0,-1,0,1};
        int[] dy = {-1,0,1,0};
        int[][] ch = new int[r][c];
        Queue<GameMapNode> q = new LinkedList<>();
        q.add(new GameMapNode(0,0));
        ch[0][0] = 1;
        while(!q.isEmpty()){
            GameMapNode node = q.poll();
            for(int i=0;i<4;i++){
                int nx = node.x+dx[i];
                int ny = node.y+dy[i];
                if(nx>=0&&ny>=0&&nx<r&&ny<c&&ch[nx][ny]==0&&maps[nx][ny]==1){
                    q.add(new GameMapNode(nx,ny));
                    ch[nx][ny]=ch[node.x][node.y]+1;
                }
            }
        }
                if(ch[r-1][c-1]==0) return -1;
        return ch[r-1][c-1];
    }

}