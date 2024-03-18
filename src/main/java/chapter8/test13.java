
package chapter8;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point{
    public int x,y;
    Point(int x,int y){
        this.x = x;
        this.y = y;
    }
}

public class test13 {
    // 내가 짠 코드
    static int[][] board, dis;
    static int[] dx = {-1,0,1,0,-1,1,-1,1};
    static int[] dy = {0,1,0,-1,-1,-1,1,1};
    static int n,answer=0;
    static Queue<Point> q = new LinkedList<>();
    public void BFS(){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==1&&dis[i][j]==0){
                    q.offer(new Point(i,j));
                    dis[i][j]=1;
                    while(!q.isEmpty()){
                        Point p = q.poll();
                        int x= p.x;
                        int y=p.y;
                        for(int m=0;m<8;m++){
                            int nx = x+dx[m];
                            int ny = y+dy[m];
                            if(nx>=0 && nx<n && ny>=0 && ny<n && board[nx][ny]==1 && dis[nx][ny]==0){
                                dis[nx][ny]=1;
                                q.offer(new Point(nx,ny));
                            }
                        }
                    }
                    answer++;
            }
        }}
        }

    public static void main(String[] args){
        test13 T = new test13();
        Scanner in = new Scanner(System.in);
        n=in.nextInt();
        board=new int[n][n];
        dis=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++) {
                board[i][j]=in.nextInt();
            }
        }
        T.BFS();
        System.out.println(answer);
    }
}